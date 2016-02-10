package scafe.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import scafe.web.account.form.UserForm;

@Data
@Entity
@Table (name = "user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;	

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToMany
	@JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id",nullable=false, updatable=false),
            inverseJoinColumns = @JoinColumn(name = "role_name", nullable=false, updatable=false))
	private List<Role> roles;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;
	
	public void SetUser(UserForm user)
	{
		this.email = user.getEmail();
		this.password = user.getPassword(); // try encrypt
		this.name = user.getName();
		if(this.createdAt == null)
			this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}	
	
}
