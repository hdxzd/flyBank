package com.hailei.service.impl;

import com.hailei.mapper.AdminMapper;
import com.hailei.pojo.PageBean;
import com.hailei.pojo.User;
import com.hailei.service.BrandService;
import com.hailei.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<User> selectAll() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

        //4. 调用方法
        List<User> users = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();

        return users;
    }

    @Override
    public void add(User user) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

        //4. 调用方法
        mapper.add(user);
        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

        //4. 调用方法
        mapper.deleteById(id);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public void updateById(User user) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

        //4. 调用方法
        mapper.updateById(user);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<User> selectByPage(int currentPage, int pageSize) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        //5. 查询当前页数据
        List<User> rows = mapper.selectByPage(begin, size);

        //6. 查询总记录数
        int totalCount = mapper.selectTotalCount();

        //7. 封装PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<User> selectByPageAndCondition(int currentPage, int pageSize, User user) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        // 处理brand条件，模糊表达式
        String bank_name = user.getBank_name();
        if (bank_name != null && bank_name.length() > 0) {
            user.setBank_name("%" + bank_name + "%");
        }

        String phone = user.getPhone();
        if (phone != null && phone.length() > 0) {
            user.setPhone("%" + phone + "%");
        }


        //5. 查询当前页数据
        List<User> rows = mapper.selectByPageAndCondition(begin, size, user);

        //6. 查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(user);

        //7. 封装PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }


}
