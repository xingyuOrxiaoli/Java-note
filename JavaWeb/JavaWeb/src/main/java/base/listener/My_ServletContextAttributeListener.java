package base.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.http.HttpServletRequest;

public class My_ServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        HttpServletRequest servletContext = (HttpServletRequest) servletContextAttributeEvent.getServletContext();
        System.out.println(servletContext.getServletPath()+"==================");
        System.out.println("My_ServletContextAttributeListener  : attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("My_ServletContextAttributeListener  : attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("My_ServletContextAttributeListener  : attributeReplaced");
    }
}
