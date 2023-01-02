package com.hailei.web.servlet;

import com.hailei.service.UserService;
import com.hailei.service.impl.UserServiceImpl;
import exceptions.MoneyNotEnoughException;
import exceptions.TransferException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    UserService accountService = new UserServiceImpl();//为了让这个对象在其他方法也可以使用
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fromactno = request.getParameter("fromactno");
        String toactno = request.getParameter("toactno");
        double money = Double.parseDouble(request.getParameter("money"));
        //调用service的转账方法完成转账(调业务层)
        try {
            accountService.transfer(fromactno,toactno,money);
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");
        }catch (Exception e){
            response.sendRedirect(request.getContextPath() + "/error2.html");
        }
    }
}
