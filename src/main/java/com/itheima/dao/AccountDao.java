package com.itheima.dao;

import com.itheima.damain.Account;
import com.itheima.damain.AccountUser;

import java.util.List;

public interface AccountDao {
    List<Account>findAll();

    List<AccountUser>findAllAccount();
}
