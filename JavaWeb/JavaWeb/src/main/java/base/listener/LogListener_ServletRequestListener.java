package base.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LogListener_ServletRequestListener implements ServletRequestListener  {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        if ("/base/logListener".equals(request.getServletPath())) {
            // My_ServletRequestAttributeListener 模拟
            request.setAttribute("request_My_ServletRequestAttributeListener", "My_ServletRequestAttributeListener_Init");
            request.setAttribute("request_My_ServletRequestAttributeListener", "My_ServletRequestAttributeListener_Replace");
            request.removeAttribute("request_My_ServletRequestAttributeListener");

            HttpSession session = request.getSession();
            session.setAttribute("session_My_ServletRequestAttributeListener", "My_ServletRequestAttributeListener_Init");
            session.setAttribute("session_My_ServletRequestAttributeListener", "My_ServletRequestAttributeListener_Replace");
            session.removeAttribute("session_My_ServletRequestAttributeListener");


            // 记录用户日志的操作
            // 如何获得客户端的IP地址
            String remoteAddr = request.getRemoteAddr();
            // 获得当前的时间
            String localeString = new Date().toLocaleString();
            // 获得访问项目的位置
            String requestURI = request.getRequestURI();
            String queryString = request.getQueryString();

            try {
                PrintWriter out = new PrintWriter(
                        new FileWriter("D:\\note\\Java\\note_learn\\note_learn\\JavaWeb\\src\\main\\resources\\base\\log.txt", true));
                out.println("用户:" + remoteAddr + "在时间:" + localeString + "访问了:" + requestURI + "?" + queryString);
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
