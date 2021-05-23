package webServer.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import webServer.bean.CartBean;
import webServer.bean.OrderBean;
import webServer.service.UserService;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    //  获取所有购物车商品
    @RequestMapping(value = "/getOrder", method = RequestMethod.GET)
    public HashMap getOrder(int user_id) {
        List<OrderBean> res = userService.getOrder(user_id);
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

    @RequestMapping(value = "/pushOrder", method = RequestMethod.GET)
    public HashMap pushOrder(int user_id,int item_id,int num,String time) {
        int res = userService.pushOrder(user_id,item_id,num,time);
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

    @RequestMapping(value = "/getOrderDetail", method = RequestMethod.GET)
    public HashMap getOrderDetail(int order_id) {
        OrderBean res = userService.getOrderDetail(order_id);
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

    @RequestMapping(value = "/cancelOrder", method = RequestMethod.GET)
    public HashMap cancelOrder(int order_id) {
        int res = userService.cancelOrder(order_id);
//        System.out.println("userBean=" + res);
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