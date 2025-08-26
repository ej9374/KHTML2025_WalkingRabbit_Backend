package ddg.walking_rabbit.rank.dto;

import ddg.walking_rabbit.global.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserChatRecordRankDto {
    private UserEntity user;
    private Integer chatRecordNumber;
}
