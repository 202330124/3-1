package survey;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDateTime;

public class Survey {
    private Long id;

    @NotBlank
    private String part;

    @NotBlank
    private String tool;

    @NotBlank
    @NotEmpty
    private String say;

    @NotBlank
    @NotEmpty
    private String name;

    private int age;

    private LocalDateTime regDate;

    public Survey(String part, String tool, String say, String name, int age, LocalDateTime regDate) {
        this.part = part;
        this.tool = tool;
        this.say = say;
        this.name = name;
        this.age = age;
        this.regDate = regDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }
}