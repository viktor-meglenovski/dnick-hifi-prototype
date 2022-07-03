package prototype.hifi.dnick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.hifi.dnick.model.Badge;
import prototype.hifi.dnick.model.enumerations.Badges;


@Repository
public interface BadgeRepository extends JpaRepository<Badge, Badges> {
}
