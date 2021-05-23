package webServer.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webServer.bean.CartBean;
import webServer.bean.ItemBean;
import webServer.bean.UserBean;
import webServer.service.UserService;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CartController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    //  获取所有购物车商品
    @RequestMapping(value = "/getCart", method = RequestMethod.GET)
    public HashMap getCart(int id) {
        List<CartBean> res = userService.getCart(id);
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
            hashMap.put("Status", "400");
            hashMap.put("msg", "unknown err");
            return hashMap;
        }
    }

    //  修改购物车商品数量
    @RequestMapping(value = "/modifyCart", method = RequestMethod.GET)
    public HashMap getCart(int user_id,int item_id,int num) {
        int res = userService.modifyCart(user_id,item_id,num);
        System.out.println("userBean=" + res);
        if (res != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", res);
            System.out.println("result=" + res);
            return hashMap;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "400");
            hashMap.put("msg", "unknown err");
            return hashMap;
        }
    }

    //  删除购物车商品
    @RequestMapping(value = "/delCart", method = RequestMethod.GET)
    public HashMap delCart(int user_id,int item_id) {
        int res = userService.delCart(user_id,item_id);
        System.out.println("userBean=" + res);
        if (res != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", res);
            System.out.println("result=" + res);
            return hashMap;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "400");
            hashMap.put("msg", "unknown err");
            return hashMap;
        }
    }

    //  添加购物车商品
    @RequestMapping(value = "/addCart", method = RequestMethod.GET)
    public HashMap addCart(int user_id,int item_id,int status) {
        int res = userService.addCart(user_id,item_id,status);
        System.out.println("userBean=" + res);
        if (res != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", res);
            System.out.println("result=" + res);
            return hashMap;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", "400");
            hashMap.put("msg", "unknown err");
            return hashMap;
        }
    }

}

