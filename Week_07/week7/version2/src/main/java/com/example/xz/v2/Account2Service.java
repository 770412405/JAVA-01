package com.example.xz.v2;



import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Account2Service {

    @Resource
    private Account2Mapper accountMapper;


    public void add(Account2 account) {
        int i = accountMapper.insert(account);
        System.out.println("新增成功：" + i + "条");
    }

    public List<Account2> findAll() {
        return accountMapper.selectAll();
    }

}
