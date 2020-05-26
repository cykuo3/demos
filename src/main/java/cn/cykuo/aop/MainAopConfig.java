package cn.cykuo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 1)开启aop开关的注解EnableAspectJAutoProxy，所以从这个注解入手
 * 2)注解只做了一件事情，就是注册了一个bean(AnnotationAwareAspectJAutoProxyCreator)，分析到这个bean的继承关系
 *   AnnotationAwareAspectJAutoProxyCreator
 *   -> AspectJAwareAdvisorAutoProxyCreator
 *   -> AbstractAdvisorAutoProxyCreator
 *   -> AbstractAutoProxyCreator
 *   -> SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 * 3)
 * @author chengyuankuo
 * @date 2020/05/24
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan({"cn.cykuo.aop"})
public class MainAopConfig {

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }

    @Bean
    public MyService mySerrvice(){
        return new MyService();
    }
}
