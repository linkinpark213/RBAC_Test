package com.linkinpark213.controller;

import com.alibaba.fastjson.JSON;
import com.linkinpark213.model.*;
import com.linkinpark213.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

/**
 * Created by ooo on 2017/5/8 0008.
 */
@Controller
public class IndexController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    AuthorizationRepository authorizationRepository;
    @Autowired
    PermissionRepository permissionRepository;
    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(HttpSession session, PrintWriter printWriter, @RequestParam("user-id") int userId) {
        UserEntity user = userRepository.findOne(userId);
        System.out.println("User Logging in: " + userId);
        if (user != null) {
            session.setAttribute("user", user);
            printWriter.write(JSON.toJSONString(articleRepository.findAll()));
            printWriter.flush();
            printWriter.close();
        }
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public String article(ModelMap modelMap, HttpSession session, @PathVariable("id") int articleId) {
        ArticleEntity article = articleRepository.findOne(articleId);
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (article != null && user != null) {
            modelMap.addAttribute("article", article);
            modelMap.addAttribute("comments", commentRepository.findByArticleId(articleId));
            modelMap.addAttribute("permittedOperations", permittedOperations(user.getId(), articleId));
            return "article";
        } else
            return "redirect:/";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(ModelMap modelMap,
                          HttpSession session,
                          @RequestParam("article-id") int articleId,
                          @RequestParam("comment") String content) {
        CommentEntity comment = new CommentEntity();
        UserEntity user = (UserEntity) session.getAttribute("user");
        if(user != null && permissionCheck(user.getId(), articleId, OperationEntity.COMMENT)) {
            comment.setArticleId(articleId);
            comment.setContent(content);
            comment.setUserId(user.getId());
            commentRepository.saveAndFlush(comment);
        }
        return "redirect:/article/" + articleId;
    }

    @RequestMapping(value = "/resubmit", method = RequestMethod.POST)
    public String resubmit(ModelMap modelMap,
                           HttpSession session,
                           @RequestParam("article-id") int articleId,
                           @RequestParam("resubmit-title") String title,
                           @RequestParam("resubmit-content") String content) {
        ArticleEntity article = articleRepository.findOne(articleId);
        UserEntity user = (UserEntity) session.getAttribute("user");
        if(article != null && user != null && permissionCheck(user.getId(), articleId, OperationEntity.EDIT)) {
            article.setTitle(title);
            article.setContent(content);
            articleRepository.saveAndFlush(article);
        }
        return "redirect:/article/" + articleId;
    }

    public boolean[] permittedOperations(int userId, int articleId) {
        UserEntity user = userRepository.findOne(userId);
        RoleEntity role = user.getRoleByRoleId();
        Collection<AuthorizationEntity> authorizationCollection = role.getAuthorizationsById();
        Object[] authorizationEntities = authorizationCollection.toArray();
        int n = authorizationEntities.length;
        boolean[] operations = new boolean[4];
        for (int i = 0; i < 4; i++) {
            operations[i] = false;
        }
        for (int i = 0; i < n; i++) {
            operations[((AuthorizationEntity) authorizationEntities[i]).getPermissionByPermissionId().getOperationId()] = true;
        }
        return operations;
    }

    public boolean permissionCheck(int userId, int articleId, int operationId) {
        UserEntity user = userRepository.findOne(userId);
        RoleEntity role = user.getRoleByRoleId();
        Collection<AuthorizationEntity> authorizationCollection = role.getAuthorizationsById();
        PermissionEntity permission = permissionRepository.findByArticleIdAndOperationId(articleId, operationId);
        if (permission == null) return false;
        return authorizationCollection.contains(new AuthorizationEntity(role.getId(), permission.getId()));
    }

}
