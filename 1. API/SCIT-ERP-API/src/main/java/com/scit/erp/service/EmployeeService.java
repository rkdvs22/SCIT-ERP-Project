package com.scit.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scit.erp.dto.Employee;
import com.scit.erp.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> getRoomList(){
		List<Employee> result = null;
		result = employeeMapper.getEmployeeList();
		
		return result;
	}


}
