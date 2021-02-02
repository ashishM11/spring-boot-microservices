package springboot.microservice.emp.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {

	private Long empID;
	private String empFname;
	private String empLname;
	private LocalDate empDOB;
	private String empMobile;
	private String empEmail;
	private Long deptID;
	
}