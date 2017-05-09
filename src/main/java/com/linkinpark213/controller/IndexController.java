package com.linkinpark213.controller;

import com.linkinpark213.model.ArticleEntity;
import com.linkinpark213.model.RoleEntity;
import com.linkinpark213.model.UserEntity;
import com.linkinpark213.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.PrintWriter;
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
        UserEntity user = userRepository.findOne(1);
        RoleEntity role = user.getRoleByRoleId();

        ArticleEntity article = articleRepository.getOne(1);
        modelMap.addAttribute("article", article);
        return "index";
    }

    @RequestMapping(value = "/req", method = RequestMethod.GET)
    public void req(ModelMap modelMap, PrintWriter printWriter) {

    }

}
