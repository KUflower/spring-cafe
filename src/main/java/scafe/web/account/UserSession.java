package scafe.web.account;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scafe.domain.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {
	Integer id;
	String email;
	String name;
	List <Role> roles;
}
