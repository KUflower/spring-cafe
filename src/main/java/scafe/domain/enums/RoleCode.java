package scafe.domain.enums;

public enum RoleCode {

	ROLE_USER("USER"),
	ROLE_MGER("MANAGER"),
	ROLE_ADMIN("ADMIN");
	
	private String name;
	
	private RoleCode(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
