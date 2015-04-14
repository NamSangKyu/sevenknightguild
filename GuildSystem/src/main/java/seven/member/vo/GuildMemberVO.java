package seven.member.vo;

import java.util.Date;

public class GuildMemberVO {
	private int code;
	private String nick;
	private String password;
	private String joinDate;
	private String dropDate;
	
	

	public GuildMemberVO(String nick, String password, String joinDate) {
		super();
		this.nick = nick;
		this.password = password;
		this.joinDate = joinDate;
	}

	public GuildMemberVO(String nick, String joinDate) {
		super();
		this.nick = nick;
		this.joinDate = joinDate;
	}

	public GuildMemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getDropDate() {
		return dropDate;
	}

	public void setDropDate(String dropDate) {
		this.dropDate = dropDate;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "GuildMemberVO [code=" + code + ", nick=" + nick + ", password="
				+ password + ", joinDate=" + joinDate + ", dropDate="
				+ dropDate + "]";
	}

	
	
	
}
