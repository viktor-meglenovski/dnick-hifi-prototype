package prototype.hifi.dnick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.hifi.dnick.model.TestResult;
import prototype.hifi.dnick.model.User;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult,Long> {
    List<TestResult> findAllByUser(User user);
}
