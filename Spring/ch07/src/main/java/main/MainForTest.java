package main;

import chapter07.DBQuery;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DBQuery dbQuery = context.getBean("DBQuery", DBQuery.class);
        System.out.println(dbQuery.count());
    }
}