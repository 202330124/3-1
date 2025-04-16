package chapter05.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public int signUpConfirm(MemberVo memberVo) {
        System.out.println("MemberService::signUpConfirm()");
        // insert 처리
        memberDao.insertMember(memberVo);
        memberDao.printAllMembers();

        return 0;
    }
}