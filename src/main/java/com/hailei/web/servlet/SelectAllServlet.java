package com.hailei.web.servlet;

import com.alibaba.fastjson.JSON;
import com.hailei.pojo.Brand;
import com.hailei.pojo.User;
import com.hailei.service.BrandService;
import com.hailei.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private BrandService brandService=new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.调用service查询
        List<User> users=brandService.selectAll();

        //2.转为JSON
        String jsonString= JSON.toJSONString(users);

        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
