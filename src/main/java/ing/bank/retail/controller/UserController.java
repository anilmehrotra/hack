package ing.bank.retail.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ing.bank.retail.exception.RecordNotFoundException;
import ing.bank.retail.model.User;
import ing.bank.retail.model.UserVO;
import ing.bank.retail.service.UserService;
import ing.bank.retail.token.Singleton;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@EnableSwagger2
@RestController
//@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String healthCheck() {
		return "10.10.10";
	}
	
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getUserById(@PathVariable("id") long id) throws Exception {
        User user = userService.findById(id);
        if("inguser".equals(Singleton.getInstance().token)){
        	System.out.println("asajshd");
        }
        if (null == user) {
        	throw new RecordNotFoundException("Record Not Found For User Id "+id);
        }
        List<User> listOfUsers = userService.findByName(user.getName());
        return new ResponseEntity<List>(listOfUsers, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<User> createUser(@Valid @RequestBody UserVO userVo) throws Exception{
	     System.out.println("Creating User "+userVo.getName());
	     User user = new User();
	     user.setCountry(userVo.getCountry());
	     user.setName(userVo.getName());
	     User savedUser = userService.createUser(user);
	     //user1 = null;
	     if(null == savedUser) {
	    	 throw new Exception("server error");
	     }
	     HttpHeaders headers = new HttpHeaders();
	     return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<User> getAllUser() throws Exception {	 
	  List<User> tasks = userService.getUser();
	  if(null == tasks || tasks.isEmpty()) {
		  throw new RecordNotFoundException("No Record Found");
	  }
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody User currentUser)
	{
		System.out.println("sd");
	User user = userService.findById(currentUser.getId());
	if (user==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	userService.update(currentUser, currentUser.getId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id){
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<User> updateUserPartially(@PathVariable("id") long id, @RequestBody User currentUser){
		User user = userService.findById(id);
		if(user ==null){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		User usr =	userService.updatePartially(currentUser, id);
		return new ResponseEntity<User>(usr, HttpStatus.OK);
	}
}
