package mx.com.ersoft.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@Column(name = "userName", unique = true, nullable = false, length = 20)
	private String userName;
	
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<UserRoleEntity> userRole = new ArrayList<>();

	public UserEntity() {}

	public UserEntity(String userName, String password, boolean enabled, List<UserRoleEntity> userRole) {
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public String getUserName() { return userName; }
	public String getPassword() { return password; }
	public boolean isEnabled() { return enabled; }
	public List<UserRoleEntity> getUserRole() { return userRole; }
	
	public void setUserName(String userName) { this.userName = userName; }
	public void setPassword(String password) { this.password = password; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }
	public void setUserRole(List<UserRoleEntity> userRole) { this.userRole = userRole; }

	@Override
	public String toString() {
		return "UserEntity [userName=" + userName + ", password=" + password + ", enabled=" + enabled + ", userRole=" + userRole + "]";
	}
	
}
