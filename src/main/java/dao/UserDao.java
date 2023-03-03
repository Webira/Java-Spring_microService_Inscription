package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Users;


public class UserDao {
	
	private static UserDao instance;
		
		List<Users>userList = new ArrayList<>();
		
		private UserDao() {
			userList.add(new Users(1L, "Don", "Dadon", "password", "passwordBis"));
		}
		public static UserDao getinstance() {
			if(instance == null) {
				instance = new UserDao();
			}
			return instance;
		}
		//CRUD
		public List<Users>getAllUsers(){
			return userList;
		}
		
		public Users getUserById(Long id) {
			for(Users userId: userList) {
				
				if(userId.getId().equals(id)){
					return userId;
				}
			}
			return null;
		}
		
		public void addUser(Users userAdd) {
			userList.add(userAdd);
		}
		
		public void updateUser(Users user) {
			Users realUser = getUserById(user.getId());
			if(realUser!=null) {
				realUser.setName(user.getName());
				realUser.setPseudo(user.getPseudo());
				realUser.setPassword(user.getPassword());
				realUser.setPasswordBis(user.getPasswordBis());
			}
		}
		public void deleteUser(Long id) {
			userList.removeIf(user -> user.getId().equals(id));
		}
		

	

}
