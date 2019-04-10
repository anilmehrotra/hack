package ing.bank.retail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ing.bank.retail.model.User;
import ing.bank.retail.repository.UserRepository;
import ing.bank.retail.repository.UserRepository2;

@Service
@Transactional
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRepository2 userRepository2;

	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
		//return userRepository2.findAll();
	}

	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public User update(User user, long l) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	public User updatePartially(User user, long id) {
		// TODO Auto-generated method stub
		User usr = findById(id);
		usr.setCountry(user.getCountry());
		return userRepository.save(usr);
	}

	@Override
	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}



}
