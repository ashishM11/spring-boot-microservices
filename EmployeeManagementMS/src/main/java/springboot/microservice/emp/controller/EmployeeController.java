package springboot.microservice.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import springboot.microservice.emp.entity.Employee;
import springboot.microservice.emp.service.EmployeeService;
import springboot.microservice.emp.vo.EmployeeDepartmentResponseVO;
import springboot.microservice.emp.vo.EmployeeVO;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody EmployeeVO empReqVO) {
		log.info("I am inside Save Employee method.");
		Employee empObj = new Employee();
		empObj.setEmpFname(empReqVO.getEmpFname());
		empObj.setEmpLname(empReqVO.getEmpLname());
		empObj.setEmpEmail(empReqVO.getEmpEmail());
		empObj.setEmpMobile(empReqVO.getEmpMobile());
		empObj.setEmpDOB(empReqVO.getEmpDOB());
		empObj.setDeptID(empReqVO.getDeptID());
		return employeeService.saveEmployee(empObj);
	}

	@GetMapping("/employees")
	public List<EmployeeDepartmentResponseVO> getAllEmployeeWithDept() {
		return employeeService.getEmployeesWithDeptartment();
	}
	
	@GetMapping("/employee/{empId}")
	public EmployeeDepartmentResponseVO getEmployeeWithDept(@PathVariable(value = "empId") Long empId) {
		return employeeService.getEmployeeWithDeptartment(empId);
	}

}
