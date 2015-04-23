package seven.member.vo;

import java.util.Date;

public class GuildMemberVO {
	private int code;
	private String nick;
	private int level;
	private String joinDate;
	private String dropDate;
	
	

	public GuildMemberVO(String nick, int level, String joinDate) {
		super();
		this.nick = nick;
		this.level = level;
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

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "GuildMemberVO [code=" + code + ", nick=" + nick + ", level="
				+ level + ", joinDate=" + joinDate + ", dropDate=" + dropDate
				+ "]";
	}

	
	
	
}
