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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankService {

    private final UserRepository userRepository;
    private final ChatRecordRepository chatRecordRepository;

    public List<RankDto> getRankList(){
//        List<UserEntity> users = userRepository.findAll();
//        List<UserChatRecordRankDto> rows = users.stream()
//                .map(u -> new UserChatRecordRankDto(u, chatRecordRepository.findCountByUser(u)))
//                .toList();
//
//        rows.sort(Comparator
//                .comparingLong(UserChatRecordRankDto::getChatRecordNumber).reversed()
//                .thenComparing(dto -> dto.getUser().getUserId()));
//
//        List<RankDto> result = rows.stream()
//                .map(r -> new RankDto(
//
//                ))
    }

    public RankDto getRank(UserEntity user){
        RankDto result = new RankDto();


    }
}
