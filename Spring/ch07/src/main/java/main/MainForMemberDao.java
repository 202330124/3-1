package main;

import chapter07.Member;
import chapter07.MemberDao;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainForMemberDao {
    private static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        memberDao = context.getBean("memberDao", MemberDao.class);

        selectAll();
        updateMember();
        insertMember();
    }

    public static void selectAll() {
        System.out.println("------ Select All ------");
        int count = memberDao.count();
        System.out.println("total count: " + count);

        List<Member> members = memberDao.selectAll();
        for(Member member : members) {
            System.out.println(member.getId() + ": " + member.getEmail() + ": " + member.getName());
        }
    }

    public static void updateMember() {
        System.out.println("------ Update Member ------");
        Member member = memberDao.selectByEmail("aaa@test.com");
        String oldPassword = member.getPassword();
        String newPassword = Double.toString(Math.random());
        member.changePassword(oldPassword, newPassword);
        memberDao.update(member);
        System.out.println("------ Member Updated ------" + oldPassword + newPassword);
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");
    public static void insertMember() {
        System.out.println("------ Insert Member ------");
        String prefix = formatter.format(LocalDateTime.now());
        Member member = new Member (
                prefix + "@test.com", prefix, prefix, LocalDateTime.now()
        );

        memberDao.insert(member);
        System.out.println("------ Insert Member ------" + member.getId());
    }
}