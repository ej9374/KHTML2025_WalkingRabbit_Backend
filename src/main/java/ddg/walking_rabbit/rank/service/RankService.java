package ddg.walking_rabbit.rank.service;

import ddg.walking_rabbit.global.domain.entity.UserEntity;
import ddg.walking_rabbit.rank.dto.RankDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankService {

    public List<RankDto> getRankList(){

    }

    public RankDto getRank(UserEntity user){
        RankDto result = new RankDto();


    }
}
