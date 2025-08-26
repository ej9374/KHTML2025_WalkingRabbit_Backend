package ddg.walking_rabbit.global.domain.repository;

import ddg.walking_rabbit.global.domain.entity.ChatRecordEntity;
import ddg.walking_rabbit.global.domain.entity.ConversationEntity;
import ddg.walking_rabbit.global.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConversationRepository extends JpaRepository<ConversationEntity, Long> {
    ConversationEntity findByConversationId(Long conversationId);

    List<ConversationEntity> findAllByUser(UserEntity user);

    Integer countByUserAndTitle(UserEntity user, String title);
}
