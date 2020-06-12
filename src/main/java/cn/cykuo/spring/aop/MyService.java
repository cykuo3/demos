package cn.cykuo.spring.aop;

import org.springframework.stereotype.Service;

/**
 * @author chengyuankuo
 * @date 2020/05/24
 */
@Service
public class MyService {

    public int div(int i,int j){
        return  i / j;
    }
}
