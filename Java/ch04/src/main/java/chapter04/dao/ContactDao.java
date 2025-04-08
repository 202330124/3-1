package chapter04.dao;

import chapter04.ContactSet;

import java.util.HashMap;
import java.util.Map;

public class ContactDao {
    private Map<String, ContactSet> contactSetMap = new HashMap<>();

    public void insert(ContactSet contactSet) {
        contactSetMap.put(contactSet.getName(), contactSet);
    }

    public ContactSet select(String name) {
        return contactSetMap.get(name);
    }

    public Map<String, ContactSet> getContactSetMap() {
        return contactSetMap;
    }
}