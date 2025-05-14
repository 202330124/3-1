package chapter10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private MemberDao memberDao;

    public AuthInfo authenticate(String email, String password) {
        // 1. email로 Member있는지 검색
        Member member = memberDao.selectByEmail(email);

        // 2. Member가 없으면 에러 리턴
        if(member == null) {
            throw new MemberNotFoundException();
        }

        // 3. Member가 있으면 - 패스워드 검증
        // 4. 패스워드 일치하면 AuthInfo 리턴, 아니면 에러
        if(!member.matchPassword(password)) {
            throw new WrongPasswordException();
        }

        return new AuthInfo(member.getId(), member.getEmail(), member.getName());
    }
}