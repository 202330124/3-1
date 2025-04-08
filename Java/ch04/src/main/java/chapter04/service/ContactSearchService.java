package chapter04.service;

import chapter04.ContactSet;
import chapter04.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ContactSearchService {
    @Autowired(required=false)
    @Qualifier("useDao")
    private ContactDao contactDao;

    /*
    public ContactSearchService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
    */

    public ContactSet search(String name) {
        ContactSet contactSet = contactDao.select(name);

        if(contactSet != null) {
            return contactSet;
        }

        else {
            System.out.println("Contact not found");
        }

        return null;
    }
}