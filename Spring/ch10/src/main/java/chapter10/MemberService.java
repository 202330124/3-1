package chapter10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public List<Member> selectByRegDate(ListCommand listCommand) {
        return memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
    }

    public Member selectById(Long id) {
        return memberDao.selectById(id);
    }
}