package prototype.hifi.dnick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.hifi.dnick.model.Question;
import prototype.hifi.dnick.model.User;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}