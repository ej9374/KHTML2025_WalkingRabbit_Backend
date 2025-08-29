package ddg.walking_rabbit.global.domain.repository;

import ddg.walking_rabbit.global.domain.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<SurveyEntity, Long> {
}
