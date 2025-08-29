package ddg.walking_rabbit.survey.service;

import ddg.walking_rabbit.global.domain.entity.SurveyEntity;
import ddg.walking_rabbit.global.domain.entity.UserEntity;
import ddg.walking_rabbit.global.domain.repository.SurveyRepository;
import ddg.walking_rabbit.survey.dto.SurveyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public void saveSurvey(SurveyRequestDto surveyRequestDto, UserEntity user) {
        SurveyEntity survey = new SurveyEntity();
        survey.setLatitude(surveyRequestDto.getLatitude());
        survey.setLongitude(surveyRequestDto.getLongitude());
        survey.setUser(user);
        survey.setContent(surveyRequestDto.getContent());
        surveyRepository.save(survey);
    }

}
