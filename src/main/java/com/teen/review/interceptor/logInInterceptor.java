package com.teen.review.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author teen
 * @create 2021/10/15 8:32
 *
 *  1、编写一个拦截器实现HandlerInterceptor接口 Y
 *  2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 *  3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 */
public class logInInterceptor implements HandlerInterceptor {

    //寻找目标方法前执行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle拦截住了" + request.getRequestURL()+"嗷");
        //获取session
        HttpSession session = request.getSession();
        //获取session域中的用户信息
        Object logInUser = session.getAttribute("username");
        //如果已登录，则放行
        if (logInUser != null)
        {
            System.out.println("登陆成功，通过！");
            return true;
        }
        //否则拦截
//        session.setAttribute("msg","请先登录！");
        //session的信息只能在后端或JSP页面查看。。。我无语。老老实实发AJAX吧
//        request.getRequestDispatcher("/ierror.html").forward(request,response);
        response.sendRedirect("/ierror.html");
        System.out.println("请先登录");
        return false;

    }

    //目标方法处理完成后，到达指定页面前拦截
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //页面渲染完成后拦截
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
