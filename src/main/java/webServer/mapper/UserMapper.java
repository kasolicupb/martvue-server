package webServer.mapper;

import org.springframework.data.repository.query.Param;
import webServer.bean.CartBean;
import webServer.bean.ItemBean;
import webServer.bean.OrderBean;
import webServer.bean.UserBean;

import java.util.List;

public interface UserMapper {
    UserBean getInfo(@Param("username")String username, @Param("password")String password);
    int reg(@Param("username")String username, @Param("password")String password);
    List<ItemBean> getItem();
    List<ItemBean> getDetail(int id);
    List<CartBean> getCart(int id);
    int modifyCart(int user_id,int item_id,int num);
    int delCart(int user_id,int item_id);
    int addCart(int user_id,int item_id);
    int addCartNum(int user_id,int item_id);
    List<OrderBean> getOrder(int user_id);
    int pushOrder(int user_id,int item_id,int num,String time);
    OrderBean getOrderDetail(int order_id);
    int cancelOrder(int order_id);
}
