package ddg.walking_rabbit.survey.controller;

import ddg.walking_rabbit.global.domain.entity.UserEntity;
import ddg.walking_rabbit.global.response.SuccessResponse;
import ddg.walking_rabbit.survey.dto.SurveyRequestDto;
import ddg.walking_rabbit.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/surveys")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping
    public ResponseEntity<SuccessResponse<Void>> saveUserSurvey(@RequestBody SurveyRequestDto surveyRequestDto) {
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        surveyService.saveSurvey(surveyRequestDto, user);
        return SuccessResponse.ok("해당길에 대한 평가를 저장하였습니다.");
    }
}
