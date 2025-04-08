package chapter04;

import chapter04.service.FirstBean;
import chapter04.service.SecondBean;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutowiredEx {
    public AutowiredEx(@Qualifier("usedBean") FirstBean firstBean, SecondBean secondBean) {
        System.out.println("FirstBean: " + firstBean);
        System.out.println("SecondBean: " + secondBean);
    }
}