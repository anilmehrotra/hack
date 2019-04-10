package ing.bank.retail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ing.bank.retail.model.User;

//@Transactional
public interface UserRepository2 extends JpaRepository<User, Long>{
	
	@Query("SELECT usr FROM User usr  WHERE usr.name=(:name)")
	List<User> findByName(@Param("name") String name);
	
	/*
	 * @Query("SELECT con FROM Contact con  WHERE con.phoneType=(:pType) AND con.lastName= (:lName)"
	 * ) List<Contact> findByLastNameAndPhoneType(@Param("pType") PhoneType
	 * pType, @Param("lName") String lName);
	 */
}
