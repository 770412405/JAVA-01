package com.example.xz.service;


import com.example.xz.config.Master;
import com.example.xz.config.Slave;


import com.example.xz.mapper.AccountMapper;
import com.example.xz.model.Account1;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Master
    public void addMaster(Account1 account) {
        int i = accountMapper.insert(account);
        System.out.println("新增成功：" + i + "条");
    }

    @Master
    public List<Account1> findAllMaster() {
        return accountMapper.selectAll();
    }

    @Slave
    public void addSlave(Account1 account) {
        int i = accountMapper.insert(account);
        System.out.println("新增成功：" + i + "条");
    }

    @Slave
    public List<Account1> findAllSlave() {
        return accountMapper.selectAll();
    }


}
