package chapter10.controller;

import chapter10.RegisterRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterRequestValidator implements Validator {
    public static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;

    public RegisterRequestValidator() {
        this.pattern = Pattern.compile(emailRegExp);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // 1. 이메일 필드 검증
        RegisterRequest registerRequest = (RegisterRequest) target;
        if(registerRequest.getEmail() == null || registerRequest.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "required");
        }

        else {
            // 올바른 이메일 형식인지 검증
            Matcher matcher = pattern.matcher(registerRequest.getEmail());
            if(!matcher.matches()) {
                errors.rejectValue("email", "bad");
            }
        }

        // 2. 이름, 비밀번호, 비밀번호 확인은 필수 입력
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");

        // 3. 비밀번호와 비밀번호 확인이 일치하는지 검증
        if(!registerRequest.getPassword().isEmpty()) {
            if(!registerRequest.isPasswordEqualsToConfirmPassword()) {
                errors.rejectValue("confirmPassword", "password.nomatch");
            }
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterRequest.class.isAssignableFrom(clazz);
    }
}