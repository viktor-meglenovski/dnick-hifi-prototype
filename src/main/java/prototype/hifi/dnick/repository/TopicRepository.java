package prototype.hifi.dnick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.hifi.dnick.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic,String> {
}
