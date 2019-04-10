package ing.bank.retail.service;

import java.util.List;

import ing.bank.retail.model.User;

public interface UserService {
	public User createUser(User user);
	public List<User> getUser();
	public User findById(long id);
	public User update(User user, long l);
	public void deleteUserById(long id);
	public User updatePartially(User user, long id);
	public List<User> findByName(String name);
}
