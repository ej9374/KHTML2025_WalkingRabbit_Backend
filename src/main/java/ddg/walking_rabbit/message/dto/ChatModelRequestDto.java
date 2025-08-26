package ddg.walking_rabbit.message.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChatModelRequestDto {
    private String title;
    private Integer recordNum;
    private List<String> messages;
    private String photo;
    private String mission;
}
