package survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SurveyRegisterService {
    @Autowired
    private SurveyDao surveyDao;

    public Long registerSurvey(Survey survey) {
        Survey newSurvey = new Survey(survey.getPart(), survey.getTool(), survey.getSay(), survey.getName(), survey.getAge(), LocalDateTime.now());

        return surveyDao.insert(newSurvey);
    }
}