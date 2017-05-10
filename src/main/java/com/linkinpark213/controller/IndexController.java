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
    OperationRepository operationRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
//        UserEntity user = userRepository.findOne(1);
//        RoleEntity role = user.getRoleByRoleId();
//
//        ArticleEntity article = articleRepository.getOne(1);
//        modelMap.addAttribute("article", article);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(ModelMap modelMap, PrintWriter printWriter, @RequestParam("user-id") int userId) {
        UserEntity user = userRepository.findOne(userId);
        System.out.println("User Logging in: " + userId);
        if(user != null) {
            modelMap.addAttribute("user", user);
            printWriter.write(JSON.toJSONString(articleRepository.findAll()));
            printWriter.flush();
            printWriter.close();
        }
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public void req(ModelMap modelMap, PrintWriter printWriter, @PathVariable("id") int articleId) {

    }

    public int[] articlePermissions(int userId, int articleId) {
        UserEntity user = userRepository.findOne(userId);
        RoleEntity role = user.getRoleByRoleId();
        Collection<AuthorizationEntity> authorizationCollection = role.getAuthorizationsById();
        AuthorizationEntity[] authorizationEntities = (AuthorizationEntity[]) authorizationCollection.toArray();
        int n = authorizationEntities.length;
        int[] operations = new int[n];
        for (int i = 0; i < n; i++) {
            operations[i] = authorizationEntities[i].getPermissionByPermissionId().getOperationId();
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
