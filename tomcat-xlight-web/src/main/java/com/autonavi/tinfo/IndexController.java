package com.autonavi.tinfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xienan.xn
 *
 * @date 2016/8/16 20:46
 */
@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        StringBuilder sb = new StringBuilder(100000);
        for (int i = 0; i < 1000000; i++) {
            sb.append('A');
        }
        return sb.toString();
    }
}
