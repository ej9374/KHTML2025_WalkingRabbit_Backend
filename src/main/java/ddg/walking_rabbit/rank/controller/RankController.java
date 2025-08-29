package ddg.walking_rabbit.rank.controller;

import ddg.walking_rabbit.global.domain.entity.UserEntity;
import ddg.walking_rabbit.global.response.SuccessResponse;
import ddg.walking_rabbit.rank.dto.RankDto;
import ddg.walking_rabbit.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ranks")
@RequiredArgsConstructor
public class RankController {

    private final RankService rankService;

    @GetMapping("/total")
    public ResponseEntity<SuccessResponse<List<RankDto>>> getRankTotalList(){
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<RankDto> responseDto = rankService.getRankList();
        return SuccessResponse.onSuccess("전체 랭킹을 조회했습니다.", HttpStatus.OK, responseDto);
    }

    @GetMapping("/me")
    public ResponseEntity<SuccessResponse<RankDto>> getMyRank(){
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RankDto responseDto = rankService.getRank(user);
        return SuccessResponse.onSuccess("유저의 랭킹을 조회했습니다.", HttpStatus.OK, responseDto);
    }
}
