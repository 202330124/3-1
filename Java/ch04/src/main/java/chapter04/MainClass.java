package chapter04;

import chapter04.service.ContactRegisterService;
import chapter04.service.ContactSearchService;
import chapter04.utils.InitSampleData;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        InitSampleData initSampleData = context.getBean("initSampleData", InitSampleData.class);
        String[] names = initSampleData.getNames();
        String[] phoneNumbers = initSampleData.getPhoneNumbers();

        ContactRegisterService contactRegisterService = context.getBean("registerService", ContactRegisterService.class);
        for(int i = 0; i < names.length; i++) {
            ContactSet contactSet = new ContactSet(names[i], phoneNumbers[i]);
            contactRegisterService.register(contactSet);
        }

        ContactSearchService contactSearchService = context.getBean("searchService", ContactSearchService.class);
        ContactSet searchContactSet = contactSearchService.search("류현진");
        System.out.println("name: " + searchContactSet.getName());
        System.out.println("phoneNumbers: " + searchContactSet.getPhoneNumber());

        context.close();
    }
}