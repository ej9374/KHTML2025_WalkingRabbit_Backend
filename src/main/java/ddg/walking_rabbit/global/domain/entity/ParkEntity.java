package ddg.walking_rabbit.global.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkEntity {

    @Id
    private String mngNo;

    private String parkNm;

    private Double lat;

    @JsonProperty("lot")
    private Double lon;
}
