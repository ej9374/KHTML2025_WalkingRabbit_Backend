package ddg.walking_rabbit.calendar.service;

import ddg.walking_rabbit.calendar.dto.CalendarResponseDto;
import ddg.walking_rabbit.calendar.dto.ChatRecordDto;
import ddg.walking_rabbit.global.domain.entity.ChatRecordEntity;
import ddg.walking_rabbit.global.domain.entity.UserEntity;
import ddg.walking_rabbit.global.domain.repository.ChatRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final ChatRecordRepository chatRecordRepository;

    public List<CalendarResponseDto> getCalendarChatRecords(UserEntity user, Integer year, Integer month) {
        if (year == null || month == null) {
            throw new IllegalArgumentException("year과 month는 필수입니다.");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month는 1에서 12 사이의 수 입니다.");
        }

        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDateTime start = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime end = start.plusMonths(1);

        List<ChatRecordEntity> all = chatRecordRepository
                .findAllByUserAndBetweenDateOrderByChatRecordIdAsc(user, start, end);

        // key가 Integer인  day, value가 그날의 ChatRecordEntity 리스트
        Map<Integer, List<ChatRecordEntity>> byDay = all.stream()
                .collect(Collectors.groupingBy(
                        rec -> rec.getCreatedAt()
                                .toLocalDate()
                                .getDayOfMonth()));
        // { 9 : [rec1, rec2], 10 : [rec3, rec4] } 구조

        List<CalendarResponseDto> result = byDay.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> {
                    int day = e.getKey();
                    List<ChatRecordEntity> records = e.getValue();

                    List<ChatRecordDto> chatRecords = records.stream()
                            .sorted(Comparator.comparingLong(ChatRecordEntity::getChatRecordId).reversed())
                            .map(r -> {
                                ChatRecordDto dto = new ChatRecordDto();
                                dto.setChatRecordId(r.getChatRecordId());
                                dto.setPhoto(r.getCoverPhoto());
                                dto.setTitle(r.getTitle());

                                Long missionId = null;
                                if (r.getConversation() != null && r.getConversation().getMission() != null) {
                                    missionId = r.getConversation().getMission().getMissionId();
                                }
                                dto.setMissionId(missionId);
                                return dto;
                            })
                            .collect(Collectors.toCollection(ArrayList::new));

                    CalendarResponseDto dayDto = new CalendarResponseDto();
                    dayDto.setDay(day);
                    dayDto.setRecordSum(chatRecords.size());
                    dayDto.setChatRecords(chatRecords);
                    return dayDto;
                })
                .toList();

        return result;
    }
}
