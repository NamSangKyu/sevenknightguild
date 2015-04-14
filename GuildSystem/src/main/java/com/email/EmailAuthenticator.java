package com.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class EmailAuthenticator extends Authenticator {
	//메일 인증 클래스
	private String userId;
	private String userPass;
	public EmailAuthenticator(String userId, String userPass) {
		super();
		this.userId = userId;
		this.userPass = userPass;
	}
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication(userId, userPass);
	}
	
	
	
}
