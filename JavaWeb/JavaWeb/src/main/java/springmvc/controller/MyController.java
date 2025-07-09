package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/mvc")
public class MyController {

    @RequestMapping(value = "/test")
    public String demo(){
        System.out.println("test  function demo ");

        return "aa";
    }

    @RequestMapping(value = "/gain_data_req")
    public String gain_data_req(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("紧耦合的方式获取请求数据 : username = " +username +",password = "+ password);
        return "aa";
    }

    @RequestMapping(value = "/gain_data_mvc")
    // required = false 表示非必须这个参数赋值，
    public String gain_data_mvc(@RequestParam(value = "username" ,defaultValue = "默认用户名" , required = false) String username , String password){
        System.out.println("解耦合的方式获取请求数据 : username = " +username +",password = "+ password);
        return "aa";
    }

    @RequestMapping(value = "/mvc_restful/{username_rest}/password")
    public String mvc_restful(@PathVariable(value = "username_rest") String username,@PathVariable(value = "password") String password){
        System.out.println("解耦合的方式获取请求数据 : username = " +username +",password = "+ password);
        return "aa";
    }

    @RequestMapping(value = "/req_ArgCode")
    public String mvc_ArgCode(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        username = new String(username.getBytes("iso-8859-1"),"utf-8");
        System.out.println("request解决中文乱码的问题 : username = " +username +",password = "+ password);
        return "aa";
    }

    @RequestMapping(value = "/response")
    public void response(HttpServletResponse response ,HttpServletRequest request) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 处理请求

        // 响应结果
        // 1. 直接响应
        response.getWriter().write("直接响应");
        // 2. 请求转发
        request.getRequestDispatcher("/mvc/forward_page.jsp").forward(request,response);
        // 3. 重定向
        response.sendRedirect("/mvc/redirect_page.jsp");

    }


    @RequestMapping(value = "/mvc_forward")
    public String mvc_forward(){
        System.out.println("  mvc_forward  ");

        // forward 关键字可以省略不写
        return "forward:/mvc/forward_page.jsp";
    }


    @RequestMapping(value = "/mvc_redirect")
    public String mvc_redirect(){
        System.out.println(" mvc_redirect ");

        return "redirect:/mvc/redirect_page.jsp";
    }
    @RequestMapping(value = "/mvc_data_request")
    public String mvc_data_request(HttpServletRequest request){
        System.out.println(" mvc_data_request 请求转发中使用request对象作为数据流转的载体 ");

        request.setAttribute("mvc_data_request","请求转发 -- request对象的数据参数");

        return "forward:/mvc/forward_page.jsp";
    }
    @RequestMapping(value = "/mvc_data_session")
    public String mvc_data_session(HttpSession session){
        System.out.println(" mvc_data_session 请求转发中使用session对象作为数据流转的载体 ");

        session.setAttribute("mvc_data_session","请求转发 -- session 对象的数据参数");

        return "forward:/mvc/forward_page.jsp";
    }
    @RequestMapping(value = "/mvc_data_application")
    public String mvc_data_application(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        System.out.println(" mvc_data_application 请求转发中使用servletContext对象作为数据流转的载体 ");

        servletContext.setAttribute("servletContext","请求转发 -- servletContext对象的数据参数");

        return "forward:/mvc/forward_page.jsp";
    }

    /**
     * model
     *  请求转发
     *      model对象中存储的数据，相当于存储到request对象中
     *      我们在jsp中直接按照request对象作用域取值的方式可以获取数据即可
     *  重定向：
     *      在重定向中，会将第一次请求中的model对象的数据作为第二次请求的请求数据携带。只会携带基本类型的数据。第一次请求的model对象会被销毁
     * */

    @RequestMapping(value = "/mvc_data_model1")
    public String mvc_data_model1(Model model){
        System.out.println(" mvc_data_model 请求转发中使用Model对象作为数据流转的载体 ");

        model.addAttribute("mode_attribute","请求转发 -- model对象的数据参数");

        return "forward:/mvc/forward_page.jsp";
    }

    @RequestMapping(value = "/mvc_data_model2")
    public String mvc_data_model2(Model model){
        System.out.println(" mvc_data_model 重定向中使用Model对象作为数据流转的载体 ");

        model.addAttribute("mode_attribute","重定向 -- model对象的数据参数");

        return "redirect:/mvc/redirect_page.jsp";
    }
}
