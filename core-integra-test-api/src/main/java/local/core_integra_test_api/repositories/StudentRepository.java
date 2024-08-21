package local.core_integra_test_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import local.core_integra_test_api.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
