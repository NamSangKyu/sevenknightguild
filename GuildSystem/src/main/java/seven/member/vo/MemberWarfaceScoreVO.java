package seven.member.vo;

import java.util.HashMap;
import java.util.List;

public class MemberWarfaceScoreVO {
	private int code;
	private String date;
	private String nick;
	private List<HashMap<String, Object>> list;
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public List<HashMap<String, Object>> getList() {
		return list;
	}
	public void setList(List<HashMap<String, Object>> list) {
		this.list = list;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MemberWarfaceScoreVO [code=" + code + ", date=" + date
				+ ", nick=" + nick + ", list=" + list + "]";
	}

	
	
	
}
