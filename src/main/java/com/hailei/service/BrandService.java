package com.hailei.service;

import com.hailei.pojo.PageBean;
import com.hailei.pojo.User;
import exceptions.MoneyNotEnoughException;
import exceptions.TransferException;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 添加数据
     * @param user
     */
    void add(User user);

    /**
     * 删除
     * @param bank_id
     */
    void deleteById(int bank_id);

    /**
     * 修改
     * @param user
     */
    void updateById(User user);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds( int[] ids);

    /**
     * 分页查询
     * @param currentPage  当前页码
     * @param pageSize   每页展示条数
     * @return
     */
    PageBean<User>  selectByPage(int currentPage,int pageSize);

    /**
     * 分页条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param user
     * @return
     */
    PageBean<User> selectByPageAndCondition(int currentPage, int pageSize, User user);




    /**
     * 转账业务
     * @param fromact 转出账户
     * @param toact 转入账户
     * @param money 转账金额
     */
    void transfer(String fromact,String toact,double money) throws MoneyNotEnoughException, TransferException;

    /**
     * 转账业务
     * @param toact 转入账户
     * @param money 转账金额
     */
    void inmoney(String toact,double money) throws MoneyNotEnoughException, TransferException;

    /**
     * 转账业务
     * @param fromact 转出账户
     * @param money 转账金额
     */
    void outmoney(String fromact,double money) throws MoneyNotEnoughException, TransferException;
}
