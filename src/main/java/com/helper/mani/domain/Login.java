package com.helper.mani.domain;

public class Login {
	private String userName;
	private String passwordSalt;
	private String passwordHash;
	public static LoginBuilder newinstance(){
		return new LoginBuilder();
	}
	private Login(LoginBuilder builder){
		this.userName = builder.userName;
		this.passwordSalt = builder.passwordSalt;
		this.passwordHash = builder.passwordHash;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public static class LoginBuilder{
		private String userName;
		private String passwordSalt;
		private String passwordHash;
		public Login build(){
			return new Login(this);
		}
		
		public LoginBuilder withUserName(String usrNm) {
			this.userName = usrNm;
			return this;
		}
		
		public LoginBuilder withPasswordSalt(String passwordSalt) {
			this.passwordSalt = passwordSalt;
			return this;
		}
		
		public LoginBuilder withPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
			return this;
		}
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Login [");
		if (userName != null) {
			builder.append("userName=");
			builder.append(userName);
			builder.append(", ");
		}
		if (passwordSalt != null) {
			builder.append("passwordSalt=");
			builder.append(passwordSalt);
			builder.append(", ");
		}
		if (passwordHash != null) {
			builder.append("passwordHash=");
			builder.append(passwordHash);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}