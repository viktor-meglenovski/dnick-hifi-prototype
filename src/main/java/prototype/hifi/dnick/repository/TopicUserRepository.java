package prototype.hifi.dnick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.hifi.dnick.model.Topic;
import prototype.hifi.dnick.model.TopicUser;
import prototype.hifi.dnick.model.User;

@Repository
public interface TopicUserRepository extends JpaRepository<TopicUser,Long> {
    TopicUser findByTopicAndUser(Topic topic, User user);
}
