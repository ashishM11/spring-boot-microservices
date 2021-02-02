package springboot.microservice.emp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentVO {

	private Long deptId;
	private String deptName;
	private String deptCode;
	
}
