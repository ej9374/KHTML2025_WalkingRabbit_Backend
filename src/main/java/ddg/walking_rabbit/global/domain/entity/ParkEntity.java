package ddg.walking_rabbit.global.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.awt.*;

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

    private Double area;

}
