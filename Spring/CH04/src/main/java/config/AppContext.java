package config;

import chapter04.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"chapter04"})
/*
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "chapter04\\..*Dao")
    }
*/
public class AppContext {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    /*
    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService(memberDao());
    }
    */

    /*
    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService changePasswordService = new ChangePasswordService();
        // changePasswordService.setMemberDao(memberDao());
        return changePasswordService;
    }
    */

    /*
    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }
    */

    /*
    @Bean
    public MemberListPrinter memberListPrinter() {
        return new MemberListPrinter(memberDao(), memberPrinter());
    }
    */

    /*
    @Bean
    public MemberInfoPrinter memberInfoPrinter() {
        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
        memberInfoPrinter.setMemberPrinter(memberPrinter2());
        // memberInfoPrinter.setMemberDao(memberDao());
        // memberInfoPrinter.setMemberPrinter(memberPrinter());
        return memberInfoPrinter;
    }
    */

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(2);
        versionPrinter.setMinorVersion(1);
        return versionPrinter;
    }

    @Bean
    @Qualifier("memberPrinter")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }
}