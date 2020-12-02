package mx.com.ersoft.model;

public class UserCredentialModel {

	private String userName;
	private String password;
	
	public UserCredentialModel() {}
	public UserCredentialModel(String userName, String password) { this.userName = userName; this.password = password; }
	
	public String getUserName() { return userName; }
	public String getPassword() { return password; }
	
	public void setUserName(String userName) { this.userName = userName; }
	public void setPassword(String password) { this.password = password; }
	
	@Override
	public String toString() {
		return "UserCredentialModel [userName=" + userName + ", password=" + password + "]";
	}
		
}
