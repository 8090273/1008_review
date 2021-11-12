package com.teen.review.Configuration;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**SpringBoot整合AOP练习
 * @author teen
 * @create 2021/10/23 9:57
 */


@Component
@Aspect  //注明此类为切面类
public class log {

    //定义切入点，切入点为com.teen.review.Controller.AOPcontroller下的所有函数
    @Pointcut("execution(public * com.teen.review.Controller.AOPcontroller.*(..))")
//    @Pointcut("execution(public * com.teen.review.Controller..*(..))")
    public void webLog() {
    }

    /**
     * 前置通知，在连接点方法执行前执行的通知
     * @param joinPoint 并非必须的
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){

        //最常用 获取通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        System.out.println("代理的是哪一个方法:"+signature.getName());
        //AOP代理类的名字
        System.out.println("AOP代理类的名字:"+signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        System.out.println("AOP代理类的类:" + signature.getDeclaringType().getSimpleName());

        //通过SpringMVC中的RequestContextHolder 类的.getRequestAttributes()方法获取请求体
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println("============这是前置通知=========");
        System.out.println("URL : " + request.getRequestURL());
        System.out.println("IP : " + request.getRemoteAddr());

    }

    /**
     * 后置通知，切入点执行完毕后执行
     * @param msg 切入点返回体的内容
     *
     * returning 切入点返回值
     * pointcut 切入点
     */
    @AfterReturning(returning = "msg",pointcut="webLog()")
    public void doAfter(String msg){
        System.out.println("===========这是后置通知===========");
        System.out.println("return :" + msg);
    }



}
