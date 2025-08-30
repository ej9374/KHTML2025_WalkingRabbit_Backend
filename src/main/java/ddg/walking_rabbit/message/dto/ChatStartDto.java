package ddg.walking_rabbit.message.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class ChatStartDto {
    private Long missionId;
    private Double latitude;
    private Double longitude;
}
