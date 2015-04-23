package seven.member.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Update;

import seven.member.db.SQLClass;
import seven.member.vo.GuildMemberVO;
import seven.member.vo.MemberWarfaceScoreVO;

public interface GuildDAO {
	public List<GuildMemberVO> selectAllMember() throws Exception;
	public GuildMemberVO selectMemberNick(String nick) throws Exception;
	public GuildMemberVO selectMemberCode(int code) throws Exception;
	public int insertMember(GuildMemberVO vo) throws Exception;
	public int dropMember(HashMap<String, Object> map) throws Exception;
	
	public void createWarface() throws Exception;
	public List<HashMap<String, Object>> selectMemberMonthWarfaceScore(HashMap<String, Object> map) throws Exception;
	public HashMap<String, Object> selectAllMemberMonthWarfaceScore(HashMap<String, Object> map) throws Exception;
	public List<HashMap<String, Object>> selectAllMemberMonthWarfaceAverageScore(String date) throws Exception;
	public List<Integer> selectCurrentMember() throws Exception;
	public List<HashMap<String, Object>> selectAllMemberDateWarface(String date);
	public List<String> selectAllMemberNick() throws Exception;
	public List<HashMap<String, Object>> selectGuildWarInfo(String date) throws Exception;
}
