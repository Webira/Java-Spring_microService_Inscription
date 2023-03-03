package web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.UserDao;
import entities.Users;

@RestController
@RequestMapping("/test")

public class UserRestCintraller {
	private UserDao userDao = UserDao.getinstance();
	
	@GetMapping ("/")
		public List<Users>getUsers(){
			return userDao.getAllUsers();
		}
	
	@PostMapping("/user")
		public void addUser(@RequestBody Users user) {
			userDao.addUser(user);
		
		}
	
	@GetMapping("/{id}")
		public ResponseEntity<Users>getUsers(@PathVariable Long id){
		
			Users user = userDao.getUserById(id);
			if(user != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	@PutMapping("/{id}")
		public ResponseEntity<Users>upUser(@PathVariable Long id, @RequestBody Users userUpdate){
			
			Users user = userDao.getUserById(id);
			if(user != null) {
				user.setName(userUpdate.getName());
				user.setPseudo(userUpdate.getPseudo()); 
				user.setPassword(userUpdate.getPassword()); 
				user.setPasswordBis(userUpdate.getPasswordBis());
				userDao.updateUser(user);
				
				return new ResponseEntity<>(user, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	
	@DeleteMapping("/{id}")
		public void supprimerUser(@PathVariable Long id){
			Users user = userDao.getUserById(id);
			if(user != null) {
				userDao.deleteUser(id);
			
			}
		}
	
}
