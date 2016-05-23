package com.test.controller;

import com.test.model.User;
import com.test.service.Service1;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/8/27.
 */
@RequestMapping("/")
@Controller
public class IndexController {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private BeanFactory beanFactory;
    @Autowired @Qualifier("com.test.service.Service1#1")
    Service1 service1;

/*    @Autowired @Qualifier("index2Controller")
    Index2Controller index2Controller;*/

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("index/{id:\\d+}")
    @ResponseBody
    public String index(@PathVariable("id")int id,  @CookieValue(value = "t", required = false)String t, HttpServletRequest request, User user1){
        User user = (User) request.getAttribute("user");
        System.out.println(user);

        System.out.println("IndexController index method");

        System.out.println(id);
        System.out.println(t);
        System.out.println(user1.getId());
        System.out.println(request.getParameterMap());
        return "ok";
    }

    @RequestMapping("paramTest")
    @ResponseBody
    public Object paramTest(User user){
        //index2Controller.testindex();
        System.out.println(user);
        return "ok";
    }

    @RequestMapping("forward")
    public String forward(){
        return "forward:paramTest";
    }

    @RequestMapping("redirect")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY)
    public String redirect(){
        return "redirect:paramTest";
    }

    @RequestMapping("redirect1")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY)
    public View redirect1(){
        RedirectView redirectView = new RedirectView("paramTest");
        return redirectView;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("IndexController afterPropertiesSet!");
    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
