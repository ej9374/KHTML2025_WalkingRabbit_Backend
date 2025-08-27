package ddg.walking_rabbit.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {
    private String nickname;
    private String profileImageUrl;
    private Integer totalDate;
    private Integer totalTitle;
    private Integer totalChatRecords;
    private Integer totalMissionSuccess;
}
