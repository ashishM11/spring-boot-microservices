package springboot.microservice.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.microservice.department.entity.Department;
import springboot.microservice.department.service.DepartmentService;
import springboot.microservice.department.vo.DepartmentRequestVO;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	@RequestMapping("/department")
	public Long createNewDepartment(@RequestBody DepartmentRequestVO deptReqVO) {
		Department deptObj = new Department();
		deptObj.setDeptName(deptReqVO.getDeptName());
		deptObj.setDeptCode(deptReqVO.getDeptCode());
		return departmentService.saveDepartment(deptObj);
	}

	@GetMapping("/department/{deptId}")
	public Department getDepartmentById(@PathVariable(value = "deptId") Long deptId) {
		return departmentService.getDepartmentById(deptId);
	}

	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

}
