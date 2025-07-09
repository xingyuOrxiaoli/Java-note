package springmvc.ModelView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping(value = "/mvc")
public class MyModelView {

    /**
     * 使用View接口完成请求转发|重定向
     * 解释：
     *      SpringMVC的官方，提供一个叫做View的接口。告诉开发人员
     *      DispatcherServlet底层会调用View接口的实例化对象中的逻辑方法来完成对应的请求转发和重定向
     *  使用：
     *      1. 单元方法的返回值为View接口类型
     *      2. 真实return的View接口的实例化对象(视图解析器)
     *          官方提供的实现了View接口的视图解析器
     *              InternalResourceView    ：请求转发
     *              RedirectView            ：重庆祥
     *
     * */
    @RequestMapping("/demoView")
    public View demoView(){

        // 请求转发
//        return new InternalResourceView("/mvc/modelAndViewPage.jsp");
        // 重定向
        return new RedirectView("/mvc/modelAndViewPage.jsp");
    }

    @RequestMapping("/demoModelAndView")
    /**
     * SpringMVC 视图解析器升级
     *  问题：
     *      在原有的View接口的视图解析器中需要自己在单元测试方法中根据响应式来创建对应的视图解析器对象返回给DispatcherServlet使用，过于麻烦
     *  解决：
     *      从根据响应式的不同创建不同的视图解析器对象，变为只创建一个视图解析器对象，该对象内部自动根据参数来实现请求转发或者重定向
     *  实现：
     *      ModelAndView
     *  注意：
     *      升级后也就意味着DispatcherServlet使用ModelAndView来接收
     *      单元方法的返回值,为了兼容早起的版本让ModelView可以接受View接口的实例化帝乡
     *  特点：
     *
     */
    public ModelAndView demoModelAndView(){
        // 处理请求
        System.out.println("ModelAndView  自定义视图解析器");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("modeAndView","我是modeAndView自定义视图下的数据");
        // 请求转发
        modelAndView.setViewName("forward:/mvc/modelAndViewPage.jsp");
        // 重定向
        modelAndView.setViewName("redirect:/mvc/modelAndViewPage.jsp");

        return modelAndView;
    }

    /**
     * SpringMVC 视图解析器再次升级:
     * 问题：
     *  在使用了ModelAndView对象后，已经很好了，但是在单元方法中我们还需要创建ModelAndView对象并将请求转发或者重定向的路径存储进去。
     *  返回给DispatcherServlet使用，而我们真正想写的是资源路径以及响应方式
     *
     * 解决：
     *  我们在单元方法中直接返回字符串资源路径，及其响应方式关键字。由DispatcherServlet底层帮我们创建ModelAndView来接受单元方法的返回值
     */
    public String demoString(){
        System.out.println("这里就是前面直接返回字符串的案例，这里就不多实现了");
        return "";
    }
}
