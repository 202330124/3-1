package main;

import chapter07.ChangePasswordService;
import chapter07.Member;
import chapter07.MemberDao;
import chapter07.MemberNotFoundException;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainForChangePassword {
    private static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ChangePasswordService changePasswordService = context.getBean("changePasswordService", ChangePasswordService.class);
        memberDao = context.getBean("memberDao", MemberDao.class);

        try {
            changePasswordService.changePassword("aaa@test.com", "2345", "1234");
            System.out.println("암호를 변경했습니다.");
        }

        catch(MemberNotFoundException e) {
            System.out.println("암호 데이터가 존재하지 않습니다.");
        }

        catch(Exception e) {
            System.out.println("암호가 올바르지 않습니다.");
        }

        selectAll();
    }

    public static void selectAll() {
        System.out.println("------ Select All ------");
        int count = memberDao.count();
        System.out.println("total count: " + count);

        List<Member> members = memberDao.selectAll();
        for(Member member : members) {
            System.out.println(member.getEmail() + ": " + member.getPassword());
        }
    }
}