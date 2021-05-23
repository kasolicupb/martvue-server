package webServer.service;

import webServer.bean.CartBean;
import webServer.bean.ItemBean;
import webServer.bean.OrderBean;
import webServer.bean.UserBean;

import java.util.List;

public interface UserService {
    UserBean loginIn(String username, String password);
    int reg(String username,String password);
    List<ItemBean> getItem();
    List<ItemBean> getDetail(int id);
    List<CartBean> getCart(int id);
    int modifyCart(int user_id,int item_id,int num);
    int delCart(int user_id,int item_id);
    int addCart(int user_id,int item_id,int status);
    List<OrderBean> getOrder(int user_id);
    int pushOrder(int user_id,int item_id,int num,String time);
    OrderBean getOrderDetail(int order_id);
    int cancelOrder(int order_id);
}
