package cn.cykuo.spring.aop;

import org.aspectj.lang.annotation.*;

/**
 * 通知方法 5种通知
 *
 * @author chengyuankuo
 * @date 2020/05/24
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public int cn.cykuo.spring.aop.MyService.*(..))")
    public void pointCut(){}

    /**
     * 前置通知
     */
    @Before("pointCut()")
    public void start(){
        System.out.println("div start");
    }

    /**
     * 后置通知
     */
    @After("pointCut()")
    public void end(){
        System.out.println("div end");
    }

    /**
     * 返回通知
     */
    @AfterReturning(value = "pointCut()",returning = "res")
    public void res(Object res){
        System.out.println("div res:" + res.toString());
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "pointCut()",throwing = "exc")
    public void exc(Exception exc){
        System.out.println("div error:" + exc.getMessage());
    }
}
