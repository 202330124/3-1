package chapter10;

import java.time.LocalDateTime;

public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime registerDate;

    public Member(String email, String password, String name, LocalDateTime registerDate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDate = registerDate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if(!password.equals(oldPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        this.password = newPassword;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }
}