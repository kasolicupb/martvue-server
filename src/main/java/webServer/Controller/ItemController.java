package webServer.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webServer.bean.ItemBean;
import webServer.bean.UserBean;
import webServer.service.UserService;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ItemController {

    //将Service注入Web层
    @Autowired
    UserService userService;

//  获取所有商品
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public HashMap getItem() {
        List<ItemBean> res = userService.getItem();
        System.out.println("userBean=" + res);
        if (res != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", res);
            System.out.println("result=" + res);
            return hashMap;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "401");
            hashMap.put("msg", "wrong username or password");
            return hashMap;
        }
    }

//    获取商品详细信息
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
        public HashMap getDetail(int id) {
            System.out.println(id);
            List<ItemBean> res = userService.getDetail(id);
            System.out.println("userBean="+res);
            if (res != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Status","200");
                hashMap.put("msg","OK");
                hashMap.put("data",res);
                System.out.println("result="+res);
                return hashMap;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("Status", "401");
                hashMap.put("msg", "wrong username or password");
                return hashMap;
            }
    }}

