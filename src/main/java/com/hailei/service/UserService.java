package com.hailei.service;

import com.hailei.pojo.User;
import exceptions.MoneyNotEnoughException;
import exceptions.TransferException;

public interface UserService {
    /**
     * 登录方法
     * @param username
     * @param land_pwd
     * @return
     */

    User login(String username, String land_pwd);

    /**
     * 注册方法
     * @return
     */

    boolean register(User user);

    /**
     * 转账业务
     * @param fromact 转出账户
     * @param toact 转入账户
     * @param money 转账金额
     */
    void transfer(String fromact,String toact,double money) throws MoneyNotEnoughException, TransferException;
}
