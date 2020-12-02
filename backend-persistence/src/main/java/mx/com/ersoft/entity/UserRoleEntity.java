package mx.com.ersoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "userRole", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "userName"}))
public class UserRoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRole", nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="userName", nullable = false)
	private UserEntity user;
	
	@Column(name = "role", nullable = false, length = 45)
	private String role;
	
	public UserRoleEntity() {}	
	public UserRoleEntity(UserEntity user, String role) { this.user = user; this.role = role; }
	public UserRoleEntity(int id, UserEntity user, String role) { this.id = id; this.user = user; this.role = role; }
	
	public int getId() { return id; }
	public UserEntity getUser() { return user; }
	public String getRole() { return role; }
	
	public void setId(int id) { this.id = id; }
	public void setUser(UserEntity user) { this.user = user; }
	public void setRole(String role) { this.role = role; }

	@Override
	public String toString() {
		return "UserRoleEntity [id=" + id + ", user=" + user + ", role=" + role + "]";
	}

}
