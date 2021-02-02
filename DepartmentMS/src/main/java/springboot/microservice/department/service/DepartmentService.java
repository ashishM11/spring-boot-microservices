package springboot.microservice.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.microservice.department.entity.Department;
import springboot.microservice.department.repository.DepartmentRepoistory;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepoistory departmentRepoistory;

	@Transactional
	public Long saveDepartment(Department deptObj) {
		return departmentRepoistory.save(deptObj).getDeptId();
	}

	@Transactional
	public Department getDepartmentById(Long deptId) {
		return departmentRepoistory.findById(deptId).get();
	}

	@Transactional
	public List<Department> getAllDepartments() {
		return departmentRepoistory.findAll();
	}

}
