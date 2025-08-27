package ddg.walking_rabbit.global.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class ParkEntity {

    @Id
    private String mngNo;

    private String parkNm;

    private Double lat;

    @JsonProperty("lot")
    private Double lon;
}
