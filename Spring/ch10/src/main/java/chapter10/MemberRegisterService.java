package chapter10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberRegisterService {
    @Autowired
    private MemberDao memberDao;

    public Long registerMember(RegisterRequest registerRequest) {
        Member member = memberDao.selectByEmail(registerRequest.getEmail());
        if(member != null) {
            throw new DuplicationMemberException("Duplication member: " + member.getEmail());
        }

        Member newMember = new Member(registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getName(), LocalDateTime.now());

        return memberDao.insert(newMember);
    }
}