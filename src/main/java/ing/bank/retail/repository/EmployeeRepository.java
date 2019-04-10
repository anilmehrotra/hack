package ing.bank.retail.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ing.bank.retail.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
