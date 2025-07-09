package base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeServlet extends HttpServlet {

    public LifeServlet() {
        System.out.println("-------------------------LifeServlet类的构造函数-------------------------");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("-------------------------service-------------------------");
    }

    @Override
    public void destroy() {

        System.out.println("-------------------------destroy-------------------------");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("-------------------------init-------------------------");

    }

}
