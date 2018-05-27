package com.ruijie.rgcc.controller;

import com.ruijie.rgcc.entity.Qualification;
import com.ruijie.rgcc.inter.EfficientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import rgcc.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class EfficientController {
    @Resource
    private EfficientService efficientService;

    @RequestMapping(value = "all")
    @ResponseBody   //会自动封装成json
    public List<Qualification> hello(){
        List<Qualification> l=efficientService.getAll();
        return l;
    }
}
