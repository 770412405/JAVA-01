package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: 肖震
 * @date: 2021/3/16
 * @since:
 */
@RestController
public class domeController {
    @Resource
    private DataSource dataSource;

    @RequestMapping(value = "/date")
    public void dt(Integer userId,Integer productId) {
        try {
            Connection connection = dataSource.getConnection();
            String sql =
                    "INSERT INTO t_order (`user_id`, `product_id`, `receipt_address_id`, `order_amount`, `status`, `order_pay_time`, `delete_status`, `order_snapshot`,`create_time`, `update_time`) VALUES" +
                            " ("+ userId +" ,"+ productId +", 3, 4, 5,1,0,0,'2021-03-16 22:46:42', '2021-03-04 22:46:39');\n";

            System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
