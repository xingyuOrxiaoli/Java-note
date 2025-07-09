package springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    /**
     * preHandle方法：
     *  执行时机：在DispatcherServlet之后，单元方法之前。
     *  作用  ： 拦截单元方法的执行，如果返回值为true表示执行，为false表示拦截
     *  注意：
     *      在preHandler方法中对象请求拦截后，需要在该方法中表示拦截后的响应那内容。
     *      因为DispatcherServlet在调用preHandler方法并根据其返回值来决定是否继续
     *      执行单元方法时，加入是拦截不执行，DispatcherServlet并不会自动对此请求
     *      做出响应，所以我们在preHandler方法中做出对应的响应
     * 形参：
     *      方法谁调用谁传参，preHandler方法时DispatcherServlet调用的，也就是说DispatcherServlet会将此次请求的request对象response对象作为实参传递给preHandler方法
     *
     *
     * @param request   ： 存储此次请求的请求数据  作用：在preHandler方法中使用该对象获取此次请求参数信息
     * @param response  ： 此次请求的响应对象     作用：在preHandler方法中对此次请求作为响应
     * @param handler   ： 实参的类型是HandlerMethod  作用 接受存储了此次请求的单元方法对象的HandlerMethod的实例化对象
     *                      HandlerMethod作用： 存储了此次请求的单元方法对象
     *                                   目的： 可以让我们在preHandler方法中调用一次此次请求的单元方法
     *                      说明：
     *                          如果preHandler方法中放行去执行此次请求的单元方法，单元方法是由DispatcherServlet来调用执行的，我们只是声明了单元方法，是不能参与到单元方法的调用的。
     *                          但是如果我们在preHandler方法中拦截了此次请求，并在其中反射调用此次请求的单元方法，这样的调用方式我们是可控的。
     *                      总结：
     *                        preHandler方法是由DispatcherServlet调用，在单元方法之前执行，可以决定是否拦截单元方法的方法
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor  preHandle");
        return true;
    }

    /**
     * postHandle方法：
     *  执行时机：拦截放行，在单元方法执行后执行，在单元方法请求转发的jsp页面之前执行。
     *  作用：在单元方法执行后，可以在该方法中对单元方法请求转发流转的数据进行修改，还可以对单元方法要相应的资源进行重新定义
     *  调用者： DispatcherServlet
     * @param request       封装了此次请求数据的request对象
     * @param response      此次请求的响应对象
     * @param handler       HandlerMethod类型，存储了单元方法对象
     * @param modelAndView  目的：
     *                          在postHandle方法中DispatcherServlet将其创建的ModelAndView对象传递进来这样我们就可以在该方法对ModelAndView中的资源做出一定的操作。
     *                      Model对象的介绍：
     *                          在以前学习的Servlet的时候，在请求转发的过程中，会使用request对象作为请求转发的数据载体。而在SpringMVC中给我们提供一个新的对象，Model对象，该对象和request对象的作用是一样的，都可以用来作为请求转发数据的载体
     *                      View对象的介绍：
     *                          View是早期SpringMVC的一个接口，在单元方法中使用其实现类来完成请求来响应
     *                      ModelAndView的介绍：
     *                          是当前SpringMVC版本提供用来响应请求的对象，该对象由DispatcherServlet来创建。其中存储了要进行响应的资源以及Model对象存储的要流转的数据
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor  postHandle");
    }

    /**
     * afterCompletion方法
     *  作用：监测请求过程是否正常执行
     *      1. 处理在请求过程中，出现的异常信息
     *      2. 请求日志信息
     *      3. 资源流的关闭
     *      执行时机：在本次请求的最后执行，在jsp之后
     *      调用者DispatcherServlet
     * @param request       封装了此次请求数据的request对象
     * @param response      此次请求的响应对象
     * @param handler       HandlerMethod类型，存储了单元方法对象
     * @param ex            接收此次请求处理过程的异常信息
     *                      注意：当preHandler方法正常执行后，afterCompletion方法才会执行
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor  afterCompletion");
    }

}
