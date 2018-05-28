package com.scit.erp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.scit.erp.dto.Employee;

/**
 * @author kangjy
 */
@Mapper
public interface EmployeeMapper {
	public List<Employee> getEmployeeList();
}
