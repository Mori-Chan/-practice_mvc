package examples.orm.mapper;

	import java.util.List;

import org.apache.ibatis.annotations.Param;

import examples.entity.EmployeeModel;

	public interface EmployeeMapper {
		public EmployeeModel getEmployee(@Param("employeeModel") String employeeModel);
		public List<EmployeeModel> findAll(EmployeeModel employeeModel);
		public EmployeeModel findDetail(EmployeeModel employeeModel);
		public void entryEmployee(EmployeeModel employeeModel);
		public void deleteEmployee(EmployeeModel employeeModel);
		public void updateEmployee(EmployeeModel employeeModel);

	}
