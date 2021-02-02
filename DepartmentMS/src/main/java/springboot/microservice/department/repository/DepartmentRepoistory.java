package springboot.microservice.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.microservice.department.entity.Department;

@Repository
public interface DepartmentRepoistory extends JpaRepository<Department, Long> {

}
