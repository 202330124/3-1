package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {
    private DateTimeFormatter formatter;

    public void print(Member member) {
        if(formatter == null) {
            System.out.printf("회원 정보: 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n", member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        }

        else {
            System.out.printf("회원 정보: 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n", member.getId(), member.getEmail(), member.getName(), formatter.format(member.getRegisterDateTime()));
        }
    }

    @Autowired
    public void setFormatter(@Nullable DateTimeFormatter formatter) {
        this.formatter = formatter;
    }
}