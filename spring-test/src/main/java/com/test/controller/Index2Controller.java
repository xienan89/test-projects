package com.test.controller;

import com.test.model.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/12/13.
 */
@Controller("index2Controller")
@RequestMapping("index2")
public class Index2Controller implements InitializingBean{
    @Autowired
    TestInitializeBean testInitializeBean;

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("paramTest")
    @ResponseBody
    public Object paramTest(User user){
        System.out.println(user);
        return "ok";
    }

    public void testindex(){
        System.out.println("index2 controller test index.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("index2 controller after properties set!");
    }
}
