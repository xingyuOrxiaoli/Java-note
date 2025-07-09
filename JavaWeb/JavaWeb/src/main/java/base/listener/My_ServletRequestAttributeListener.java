package base.listener;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

public class My_ServletRequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestAttributeEvent.getServletRequest();
        if ("/base/ServletRequestAttributeListener".equals(request.getServletPath())) {
            System.out.println("My_ServletRequestAttributeListener  : attributeAdded");
        }
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestAttributeEvent.getServletRequest();
        if ("/base/ServletRequestAttributeListener".equals(request.getServletPath())) {
            System.out.println("My_ServletRequestAttributeListener  : attributeRemoved");
        }
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestAttributeEvent.getServletRequest();
        if ("/base/ServletRequestAttributeListener".equals(request.getServletPath())) {
            System.out.println("My_ServletRequestAttributeListener  : attributeReplaced");
        }
    }
}
