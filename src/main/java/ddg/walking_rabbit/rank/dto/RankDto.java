package ddg.walking_rabbit.rank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RankDto {
    private Integer rank;
    private Long userId;
    private String nickname;
    private Integer chatRecordNumber;
}
