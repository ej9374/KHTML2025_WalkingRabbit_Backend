package ddg.walking_rabbit.survey.dto;

import lombok.Getter;

@Getter
public class SurveyRequestDto {
    private Double latitude;
    private Double longitude;
    private String content;
}
