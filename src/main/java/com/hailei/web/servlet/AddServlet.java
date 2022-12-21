package com.hailei.web.servlet;

import com.alibaba.fastjson.JSON;
import com.hailei.pojo.Brand;
import com.hailei.service.BrandService;
import com.hailei.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService=new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.接受品牌数据
        BufferedReader br=request.getReader();
        String params=br.readLine();//json字符串
        //转为Brand对象
        Brand brand= JSON.parseObject(params,Brand.class);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
