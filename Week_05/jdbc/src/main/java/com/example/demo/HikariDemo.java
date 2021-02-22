package com.example.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: 肖震
 * @date: 2021/2/22
 * @since:
 */
public class HikariDemo {

    public static void main(String[] args) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/study");
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //创建connection
            conn = ds.getConnection();
            statement = conn.createStatement();
            //执行sql
            rs = statement.executeQuery("select 100 s  from dual");

            //取数据
            if (rs.next()) {
                System.out.println(rs.getString("s"));
            }
            //关闭connection
            conn.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
