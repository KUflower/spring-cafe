package scafe.domain.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import scafe.domain.Role;
import scafe.domain.User;

public class ScafeUserDetails implements UserDetails, Serializable {
	private User user;
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public ScafeUserDetails(User user){
		this.user = user;
		for(Role role : user.getRoles()){
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
