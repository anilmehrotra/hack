package ing.bank.retail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ing.bank.retail.model.User;
public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query("SELECT usr FROM User usr  WHERE usr.name=(:name)")
	List<User> findByName(@Param("name") String name);
}
