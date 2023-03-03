package entities;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Users {
	private Long id;
	private String name;
	private String pseudo;
	private String password;
	private String passwordBis;
	
}
