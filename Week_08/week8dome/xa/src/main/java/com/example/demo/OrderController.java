package com.example.demo;

import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 肖震
 * @date: 2021/3/16
 * @since:
 */

@RestController
public class OrderController {
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderController(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @RequestMapping(value = "/dome")
    @ShardingTransactionType(TransactionType.XA)
    public void dt() throws Exception {
        String sql =
                "INSERT INTO t_order (`user_id`, `product_id`, `receipt_address_id`, `order_amount`, `status`, `order_pay_time`, `delete_status`, `order_snapshot`,`create_time`, `update_time`) VALUES" +
                        " (  ? ,?, 3, 4, 5,1,0,0,'2021-03-16 22:46:42', '2021-03-04 22:46:39');";

        jdbcTemplate.execute(sql, (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            preparedStatement.setObject(1, 1);
            preparedStatement.setObject(2, 1);
            preparedStatement.executeUpdate();//成功

            preparedStatement.setObject(1, 2);
            preparedStatement.setObject(2, 2);
            preparedStatement.executeUpdate();//失败
            //最终失败
            return null;
        });
    }
}
