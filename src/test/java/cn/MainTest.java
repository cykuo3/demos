package cn;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;

import com.google.common.collect.Lists;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class MainTest {

    @Test
    public void test1(){
        ReentrantLock lock = new ReentrantLock();
    }

    @Test
    public void test2(){
        var list = Lists.newArrayList(1,2,3);
        System.out.println(list.get(2));
    }

    @Test
    public void test3(){
        // Calendar cal = Calendar.getInstance();
        // cal.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // System.out.println(cal.getTime().getTime());
        // cal.setTimeZone(TimeZone.getTimeZone("GMT+2"));;
        // System.out.println(cal.getTime().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT+11"));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long endcreatetime = cal.getTimeInMillis();
        long firstcreatetime = endcreatetime - 24 * 60 * 60 * 1000;
        System.out.println(firstcreatetime + "-" + endcreatetime);

    }

    @Test
    public void test4(){

        String tbpageMD5 = DigestUtils.md5Hex("yd_searchq_editsys_6626004");
        System.out.println(tbpageMD5);
    }

    @Test
    public void test5(){
        Consumer<String> consumer = str -> System.out.println(str);

        new Thread(() -> {
            while(true){
                consumer.accept("子线程");
            }
        }).start();

        System.out.println("主线程结束");
    }
}