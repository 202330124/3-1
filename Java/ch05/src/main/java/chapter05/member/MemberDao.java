package chapter05.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Component
public class MemberDao {
    private Map<String, MemberVo> memberVoMap = new HashMap<>();

    public void insertMember(MemberVo memberVo) {
        System.out.println("MemberDao::insertMember()");

        memberVoMap.put(memberVo.getId(), memberVo);
    }

    public void printAllMembers() {
        System.out.println("MemberDao::printAllMembers()");

        Set<String> keys = memberVoMap.keySet();
        Iterator<String> iterator = keys.iterator();

        while(iterator.hasNext()) {
            String key = iterator.next();
            MemberVo memberVo = memberVoMap.get(key);
            System.out.println("id: " + memberVo.getId());
            System.out.println("name: " + memberVo.getName());
            System.out.println("email: " + memberVo.getEmail());
        }
    }
}