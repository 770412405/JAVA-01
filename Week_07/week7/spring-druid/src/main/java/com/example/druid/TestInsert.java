package com.example.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javafx.util.converter.DateStringConverter;


import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 肖震
 * @date: 2021/3/6
 * @since:
 */
public class TestInsert {
    private static DataSource dataSource;

    public static void main(String[] args) throws Exception {
        //数据源配置
        Properties properties = new Properties();
        //通过当前类的class对象获取资源文件
        InputStream is = TestInsert.class.getResourceAsStream("/application.yml");
        properties.load(is);
        //返回的是DataSource，不是DruidDataSource
        dataSource = DruidDataSourceFactory.createDataSource(properties);

        //获取连接
        // Connection connection = dataSource.getConnection();


        // addMany1执行完毕耗时：13.192
        //addMany1(20000,50,connection);
        //addMany2执行完毕耗时：11.953
        //addMany2(20000,50,connection);
        //15:59:01.854 [pool-1-thread-2] DEBUG com.alibaba.druid.pool.PreparedStatementPool - {conn-10005, pstmt-20000} enter cache
        //addMany2执行完毕耗时：7.153
        //15:59:01.998 [pool-1-thread-1] DEBUG com.alibaba.druid.pool.PreparedStatementPool - {conn-10004, pstmt-20001} enter cache
        //addMany2执行完毕耗时：7.296
        addMany3();
        //关闭连接
        //   connection.close();
    }

    /**
     * @param length 数据个数
     * @return
     */
    private static String getValuesPart(int length) {
        String val = "(1,2,3,4,'5',1,'0',0,'2021-03-03 12:00:00','2021-03-03 12:00:00')";
        StringBuilder sb = new StringBuilder(val);
        for (int i = 0; i < length - 1; i++) {
            sb.append(",");
            sb.append(val);
        }
        return sb.toString();
    }

    /**
     * 插入一捆数据
     *
     * @param length 一捆包含的数据条数
     * @return
     * @throws SQLException
     */
    public static int addChunk(int length, Connection conn) throws SQLException {
        String sql = "insert into t_order (user_id, product_id, receipt_address_id, order_amount, status,order_pay_time, delete_status, order_snapshot,create_time,update_time) values" + getValuesPart(length);
//        try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {
        try (Statement statement = conn.createStatement()) {
            return statement.executeUpdate(sql);
        }
//        }
    }

    /**
     * 批量添加-1
     * 分50次插入
     *
     * @throws SQLException
     */
    public static void addMany1(int chunkCap, int chunkNum, Connection conn) throws SQLException {
        long startMs = System.currentTimeMillis();
        try {
            for (int i = 0; i < chunkNum; i++) {
                addChunk(chunkCap, conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        long endMs = System.currentTimeMillis();
        System.out.println("addMany1执行完毕耗时：" + (endMs - startMs) / 1000.0);
    }

    /**
     * 批量添加-2
     * 分50次插入 使用PreparedStatement
     *
     * @throws SQLException
     */
    public static void addMany2(int chunkCap, int chunkNum, Connection conn) throws SQLException {
        long startMs = System.currentTimeMillis();
        int length = chunkCap;
        String sql = "insert into t_order (user_id, product_id, receipt_address_id, order_amount, status,order_pay_time, delete_status, order_snapshot,create_time,update_time) values" + getValuesPart(length);
        //获取连接

        try {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for (int i = 0; i < chunkNum; i++) {
                    ps.addBatch();
                }
                ps.executeBatch();
                conn.commit();
            }
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
        long endMs = System.currentTimeMillis();
        System.out.println("addMany2执行完毕耗时：" + (endMs - startMs) / 1000.0);
    }

    public static void addMany3() {
        long startMs = System.currentTimeMillis();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            long endMs = System.currentTimeMillis();
            System.out.println("addMany3执行完毕耗时：" + (endMs - startMs) / 1000.0);
        });
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = () -> {
            try {
                Connection connection = dataSource.getConnection();
                addMany2(10000, 50, connection);
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.shutdown();
    }


}
