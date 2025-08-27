package ddg.walking_rabbit.mission.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParkDto {
    private String mngNo;
    private String parkNm;
    private Double lat;

    @JsonProperty("lot")
    private Double lon;
}
