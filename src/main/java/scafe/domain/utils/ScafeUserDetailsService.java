package scafe.domain.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import scafe.domain.User;
import scafe.service.UserService;

public class ScafeUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScafeUserDetailsService.class);
	
	@Autowired
	UserService userService;

//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		User user = userDao.findByEmail(email);
//		if (user == null) {
//			return null;
//		}
//		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
//		if (email.equals("admin")) {
//			auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
//		}
//		String password = user.getPassword();
//		return new org.springframework.security.core.userdetails.User(email, password, auth);
//	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LOGGER.debug("Loading user by username: {}", email);

		User user = userService.getUserByEmail(email);
		LOGGER.debug("Found user: {}", user);

		if (user == null) {
			throw new UsernameNotFoundException("No user found with email: " + email);
		}
		ScafeUserDetails principal = new ScafeUserDetails(user);

		LOGGER.debug("Returning user details: {}", principal);

		return (UserDetails) principal;
	}

}
