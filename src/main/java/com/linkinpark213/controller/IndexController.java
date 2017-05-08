package com.linkinpark213.controller;

import com.linkinpark213.model.ArticleEntity;
import com.linkinpark213.model.RoleEntity;
import com.linkinpark213.model.UserEntity;
import com.linkinpark213.model.UserRoleEntity;
import com.linkinpark213.repository.ArticleRepository;
import com.linkinpark213.repository.UserRepository;
import com.linkinpark213.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by ooo on 2017/5/8 0008.
 */
@Controller
public class IndexController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        UserEntity author = userRepository.findOne(1);
        List<UserRoleEntity> userRoleEntityList = userRoleRepository.findByUserByUserid(author);
        RoleEntity roleEntity = userRoleEntityList.get(0).getRoleByRoleid();

        ArticleEntity article = articleRepository.findOne(1);

        modelMap.addAttribute("author", author);
        modelMap.addAttribute("role", roleEntity);
        return "index";
    }

}
