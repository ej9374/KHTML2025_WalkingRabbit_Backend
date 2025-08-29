package ddg.walking_rabbit.rank.service;

import ddg.walking_rabbit.global.domain.entity.UserEntity;
import ddg.walking_rabbit.global.domain.repository.ChatRecordRepository;
import ddg.walking_rabbit.global.domain.repository.UserRepository;
import ddg.walking_rabbit.rank.dto.RankDto;
import ddg.walking_rabbit.rank.dto.UserChatRecordRankDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankService {

    private final UserRepository userRepository;
    private final ChatRecordRepository chatRecordRepository;

    public List<RankDto> getRankList(){
        List<UserEntity> users = userRepository.findAll();


        List<UserChatRecordRankDto> rows = users.stream()
                .map(u -> new UserChatRecordRankDto(u, chatRecordRepository.countByUser(u)))
                .collect(Collectors.toList());


        rows.sort(Comparator
                .comparingLong(UserChatRecordRankDto::getChatRecordNumber)
                .reversed()
                .thenComparing(dto -> dto.getUser().getUserId()));

        long prev = Long.MIN_VALUE;
        List<RankDto> result = new ArrayList<>();
        int rank = 0;
        for (int i = 0; i < rows.size(); i++) {
            long cnt = rows.get(i).getChatRecordNumber();
            if ( i == 0 || cnt != prev){
                rank = i + 1;
                prev = cnt;
            }
            RankDto dto = new RankDto();
            dto.setRank(rank);
            dto.setChatRecordNumber(rows.get(i).getChatRecordNumber());
            dto.setUserId(rows.get(i).getUser().getUserId());
            dto.setNickname(rows.get(i).getUser().getNickname());
            result.add(dto);
        }

        return result;
    }

    public RankDto getRank(UserEntity user){

        List<RankDto> userList = getRankList();

        RankDto result = new RankDto();
        for (RankDto dto : userList){
            if (Objects.equals(dto.getUserId(), user.getUserId())){
                result = dto;
            }
        }
        return result;
    }
}
