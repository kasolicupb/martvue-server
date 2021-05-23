package webServer.service.impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webServer.bean.CartBean;
import webServer.bean.ItemBean;
import webServer.bean.OrderBean;
import webServer.bean.UserBean;
import webServer.mapper.UserMapper;
import webServer.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(String username, String password) {
        return userMapper.getInfo(username, password);
    }

    @Override
    public int reg(String username, String password) {
        return userMapper.reg(username,password);
    }

    @Override
    public List<ItemBean> getItem() {
        List<ItemBean> list = userMapper.getItem();
        return list;
    }

    @Override
    public List<ItemBean> getDetail(int id) {
        List<ItemBean> list = userMapper.getDetail(id);
        return list;
    }

    @Override
    public List<CartBean> getCart(int id) {
        List<CartBean> list = userMapper.getCart(id);
        return list;
    }

    @Override
    public int modifyCart(int user_id,int item_id,int num) {
        int list = userMapper.modifyCart(user_id,item_id,num);
        return list;
    }

    @Override
    public int delCart(int user_id,int item_id) {
        int list = userMapper.delCart(user_id,item_id);
        return list;
    }

    @Override
    public int addCart(int user_id,int item_id,int status) {
        if(status==1) {
            int list = userMapper.addCartNum(user_id,item_id);
            return list;
        }else {
            int list = userMapper.addCart(user_id,item_id);
            return list;
        }
    }

    @Override
    public List<OrderBean> getOrder(int user_id) {
        List<OrderBean> list = userMapper.getOrder(user_id);
            return list;
    }

    @Override
    public int pushOrder(int user_id,int item_id,int num,String time) {
        int list = userMapper.pushOrder(user_id,item_id,num,time);
        return list;
    }

    @Override
    public OrderBean getOrderDetail(int order_id) {
        OrderBean list = userMapper.getOrderDetail(order_id);
        return list;
    }

    @Override
    public int cancelOrder(int order_id) {
        int list = userMapper.cancelOrder(order_id);
        return list;
    }
}
