package base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ParamServlet extends HttpServlet {
    String charset;
    String charset2;
    @Override
    public void init() throws ServletException {

        // 读取web.xml配置文件的属性

        // 方法一
        this.charset = this.getInitParameter("charset");
        // 方法二
        this.charset = this.getServletConfig().getInitParameter("charset");

        // 读取全局参数
        this.charset2 = this.getServletContext().getInitParameter("charset");

        System.out.println("初始化参数:" + charset);
        System.out.println("全局参数 :" + charset2);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset="+charset);
        System.out.println(charset);

    }
}
