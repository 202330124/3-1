package controller;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import survey.Survey;
import survey.SurveyRegisterService;

import javax.validation.Valid;

@Controller
public class SurveyController {
    private final SurveyRegisterService surveyRegisterService;

    public SurveyController(SurveyRegisterService surveyRegisterService) {
        this.surveyRegisterService = surveyRegisterService;
    }

    @PostMapping("/surveyComplete")
    public String step(@ModelAttribute("survey") @Valid Survey survey, Errors errors) {
        if(errors.hasErrors()) {
            return "/surveyForm";
        }

        try {
            surveyRegisterService.registerSurvey(survey);
            return "/surveyComplete";
        } catch(DuplicateKeyException e) {
            return "/surveyForm";
        }
    }
}