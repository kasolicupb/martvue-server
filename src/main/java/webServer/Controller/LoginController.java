package webServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webServer.bean.UserBean;
import webServer.service.UserService;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public HashMap login(@RequestBody UserBean userBean) {
        System.out.println(userBean.getUsername());
        System.out.println(userBean.getPassword());
        UserBean res = userService.loginIn(userBean.getUsername(), userBean.getPassword());
        System.out.println("userBean="+res);
        if (res != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Status","200");
            hashMap.put("msg","OK");
            hashMap.put("data",res);
            System.out.println("result="+hashMap);
            return hashMap;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("Status","401");
            hashMap.put("msg","wrong username or password");
            return hashMap;
        }
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public HashMap reg(@RequestBody UserBean userBean) {
        System.out.println(userBean.getUsername());
        System.out.println(userBean.getPassword());
        if (userBean!=null) {
            int status = userService.reg(userBean.getUsername(), userBean.getPassword());
            System.out.println("Status="+status);
            if (status != 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("Status", "200");
                hashMap.put("msg", "OK");
                System.out.println("result="+hashMap);
                return hashMap;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("Status", "401");
                hashMap.put("msg", "has been registered");
                return hashMap;
            }
        }
        else {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "400");
            hashMap.put("msg", "unknown err");
            System.out.println(hashMap);
            return hashMap;
        }

}}

