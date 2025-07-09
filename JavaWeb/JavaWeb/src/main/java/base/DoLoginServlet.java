package base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoLoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("root".equals(username) && "root".equals(password)){
            // 账号密码正确 登录成功 请求转发
            req.getRequestDispatcher("jsp/loginResult/success.jsp").forward(req,resp);
        }else{
            // 账号或密码错误 登录失败  重定向
            resp.sendRedirect("jsp/login_page.jsp");
        }
    }
}
