package springboot.microservice.emp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.microservice.emp.entity.Employee;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDepartmentResponseVO {

	private Employee empReqVO;
	private DepartmentVO deptReqVO;

}
