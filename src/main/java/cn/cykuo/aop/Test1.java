package cn.cykuo.aop;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class Test1 {

    class Inner{

    }

    static class StaticInner{

    }

    private class PrivateInner{

    }

    public static void main(String[] args) {
        float basesalary = new BigDecimal(Float.toString(0.2f)).multiply(BigDecimal.valueOf(5))
                        .setScale(2, BigDecimal.ROUND_UP).floatValue();

        System.out.println(basesalary);
    }


}
