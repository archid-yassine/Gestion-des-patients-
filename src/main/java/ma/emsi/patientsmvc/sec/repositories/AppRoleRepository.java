package ma.emsi.patientsmvc.sec.repositories;

import ma.emsi.patientsmvc.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRolename(String rolename);
}
