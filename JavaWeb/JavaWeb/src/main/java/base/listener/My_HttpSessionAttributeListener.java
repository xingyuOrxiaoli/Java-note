package base.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class My_HttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("---1"+httpSessionBindingEvent.getSession().getServletContext().getContextPath());
        System.out.println("My_HttpSessionAttributeListener  :  attributeAdded ");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("My_HttpSessionAttributeListener  :  attributeRemoved ");

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("My_HttpSessionAttributeListener  :  attributeReplaced ");

    }
}
