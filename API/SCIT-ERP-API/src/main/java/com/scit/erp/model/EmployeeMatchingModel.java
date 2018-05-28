package com.scit.erp.model;

import com.scit.erp.dto.Employee;
import lombok.Data;

@Data
public class EmployeeMatchingModel extends Employee{
	private String MatchingType;
}
