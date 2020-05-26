package cn.cykuo.aop;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chengyuankuo
 * @date 2020/05/24
 */
public class MainAopConfigTest {

    @Test
    public void test1(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainAopConfig.class);

        MyService myService = (MyService)context.getBean("myService");

        myService.div(6, 2);
    }

}