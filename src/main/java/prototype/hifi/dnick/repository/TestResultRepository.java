package prototype.hifi.dnick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.hifi.dnick.model.TestResult;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult,Long> {
}
