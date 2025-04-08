package chapter04.service;

import chapter04.ContactSet;
import chapter04.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class ContactRegisterService {
    @Autowired(required=false)
    @Qualifier("useDao")
    // @Resource
    private ContactDao contactDao;

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void register(ContactSet contactSet) {
        // key 값을 통해 중복 여부 체크
        String name = contactSet.getName();
        if(validate(name)) {
            // 기존에 등록이 되어있지 않으면 등록 처리
            contactDao.insert(contactSet);
        }

        else {
            // 기존에 등록이 되어있으면 메시지 출력
            System.out.println("This name is already in use");
        }
        // 기존에 등록이 되어있지 않으면 등록 처리
        // 기존에 등록이 되어있으면 메시지 출력
    }

    public boolean validate(String name) {
        ContactSet contactSet = contactDao.select(name);
        return contactSet == null ? true : false;
    }
}