package ddg.walking_rabbit.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatModelRequestDto {
    private String title;
    private Integer recordNum;
    private String mission;
}
