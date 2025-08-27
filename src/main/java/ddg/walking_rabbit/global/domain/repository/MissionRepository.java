package ddg.walking_rabbit.global.domain.repository;

import ddg.walking_rabbit.global.domain.entity.MissionEntity;
import ddg.walking_rabbit.global.domain.entity.MissionStatus;
import ddg.walking_rabbit.global.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MissionRepository extends JpaRepository<MissionEntity, Long> {
    MissionEntity findByMissionId(Long missionId);

    MissionEntity findTopByUser_UserIdAndMissionDateOrderByMissionIdDesc(Long userId, LocalDate date);

    Integer countByUserAndIsSuccess(UserEntity user, MissionStatus status);
}
