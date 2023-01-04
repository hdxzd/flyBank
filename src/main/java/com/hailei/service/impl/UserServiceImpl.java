package com.hailei.service.impl;

import com.hailei.mapper.UserMapper;
import com.hailei.pojo.User;
import com.hailei.service.UserService;
import com.hailei.util.SqlSessionFactoryUtils;
import exceptions.MoneyNotEnoughException;
import exceptions.TransferException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.http.HttpServletRequest;

public class UserServiceImpl implements UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     * @param username
     * @param land_pwd
     * @return
     */

    public User login(String username, String land_pwd){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 调用方法
        User user = mapper.select(username, land_pwd);

        //释放资源
        sqlSession.close();

        return  user;
    }



    /**
     * 注册方法
     * @return
     */

    public boolean register(User user){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getBank_name());

        if(u == null){
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;

    }

    @Override
    public void transfer(String fromact, String toact, double money) throws MoneyNotEnoughException, TransferException {
        //处理事务
        SqlSession sqlSession = factory.openSession();

        //1.判断转出账户余额是否充足，不充足提示
        User fromAccount =selectByid(fromact);
        if (fromAccount.getMoney() < money) {
            //提示用户
            throw new MoneyNotEnoughException("不好意思，账户余额不足");
        }

        //2.转出账户余额充足，更新转出账户余额
        User toactAccount = selectByid(toact);
        fromAccount.setMoney(fromAccount.getMoney() - money);

        /*String s = null;//这里模拟异常，测试事务处理是否成功
        s.toString();*/

        toactAccount.setMoney(toactAccount.getMoney() + money);

        int count = updateByid(fromAccount);
        count += updateByid(toactAccount);
        if (count != 2) {
            sqlSession.rollback();//事务回滚
            throw new TransferException("转账异常，未知原因");
        }

        sqlSession.commit();//事务提交
        sqlSession.close();
    }


    public User selectByid(String bank_id) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("selectByid", bank_id);
        return user;
    }


    public int updateByid(User user) {
        HttpServletRequest SqlSessionUtil;
        SqlSession SqlSession  = factory.openSession();
        int count = SqlSession.update("updateByid",user);
        return count;
    }


    @Override
    public void outmoney(String fromact, double money) throws MoneyNotEnoughException, TransferException {
        SqlSession sqlSession = factory.openSession();

        //1.判断转出账户余额是否充足，不充足提示
        User fromAccount =selectByid(fromact);
        if (fromAccount.getMoney() < money) {
            //提示用户
            throw new MoneyNotEnoughException("不好意思，账户余额不足");
        }

        //2.转出账户余额充足，更新转出账户余额

        fromAccount.setMoney(fromAccount.getMoney() - money);

        /*String s = null;//这里模拟异常，测试事务处理是否成功
        s.toString();*/



        int count = updateByid(fromAccount);
        count +=1;
        if (count != 2) {
            sqlSession.rollback();//事务回滚
            throw new TransferException("转账异常，未知原因");
        }

        sqlSession.commit();//事务提交
        sqlSession.close();
    }


}
