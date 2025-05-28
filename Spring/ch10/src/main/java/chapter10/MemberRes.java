package chapter10;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemberRes {
    private Long id;
    private String email;
    private String name;

    private String registerDateTimeFormatted;

    public MemberRes(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.registerDateTimeFormatted = format(member.getRegisterDate());
    }

    private String format(LocalDateTime dt) {
        if(dt == null) {
            return "";
        }

        return dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterDateTimeFormatted() {
        return registerDateTimeFormatted;
    }

    public void setRegisterDateTimeFormatted(String registerDateTimeFormatted) {
        this.registerDateTimeFormatted = registerDateTimeFormatted;
    }
}