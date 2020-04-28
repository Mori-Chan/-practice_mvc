package examples.component.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import examples.entity.EmployeeModel;
import examples.orm.mapper.EmployeeMapper;

@Repository
public class EmployeeDAO {

	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeDAO() {
		super();
	}

	@Transactional(readOnly=true)
	public EmployeeModel getEmployee(String employeeId){
		return this.employeeMapper.getEmployee(employeeId);
	}

	@Transactional(readOnly=true)
	public List<EmployeeModel> findAll(EmployeeModel employeeModel){
		return this.employeeMapper.findAll(employeeModel);
	}

	@Transactional(readOnly=true)
	public EmployeeModel findDetail(EmployeeModel employeeModel){
		return this.employeeMapper.findDetail(employeeModel);
	}


	@Transactional
	public void entryEmployee(EmployeeModel employeeModel){
		this.employeeMapper.entryEmployee(employeeModel);
	}

	public void deleteEmployee(EmployeeModel employeeModel) {
		this.employeeMapper.deleteEmployee(employeeModel);
	}
	public void updateEmployee(EmployeeModel employeeModel) {
		this.employeeMapper.updateEmployee(employeeModel);
	}

}
