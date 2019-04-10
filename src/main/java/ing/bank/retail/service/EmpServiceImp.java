package ing.bank.retail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ing.bank.retail.model.Employee;
import ing.bank.retail.repository.EmployeeRepository;

@Service
@Transactional
public class EmpServiceImp implements EmpService {
	
	@Autowired
    private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmp(Employee emp) {
		return employeeRepository.save(emp);
	}

}
