package springboot.microservice.emp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import springboot.microservice.emp.entity.Employee;
import springboot.microservice.emp.repository.EmployeeRepository;
import springboot.microservice.emp.vo.DepartmentVO;
import springboot.microservice.emp.vo.EmployeeDepartmentResponseVO;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Transactional
	public Employee saveEmployee(Employee empObj) {
		return employeeRepository.save(empObj);
	}

	@Transactional
	public List<EmployeeDepartmentResponseVO> getEmployeesWithDeptartment() {
		List<EmployeeDepartmentResponseVO> voList = new ArrayList<EmployeeDepartmentResponseVO>();
		List<Employee> empList = employeeRepository.findAll();
		if (!empList.isEmpty()) {
			for (Employee empObj : empList) {
				DepartmentVO deptVO = restTemplate
						.getForObject("http://DEPARTMENTMANAGEMENT/api/department/" + empObj.getDeptID(), DepartmentVO.class);
				voList.add(new EmployeeDepartmentResponseVO(empObj, deptVO));
			}
		}
		return voList;
	}

	@Transactional
	public EmployeeDepartmentResponseVO getEmployeeWithDeptartment(Long empId) {
		Employee empObj = employeeRepository.findById(empId).get();
		return (null != empObj)
				? new EmployeeDepartmentResponseVO(empObj,
						restTemplate.getForObject("http://DEPARTMENTMANAGEMENT/api/department/" + empObj.getDeptID(),
								DepartmentVO.class))
				: null;
	}

}
