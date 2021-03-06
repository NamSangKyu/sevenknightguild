package seven.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import seven.date.DateCustom;
import seven.member.dao.GuildDAO;
import seven.member.db.ConnectionFactory;
import seven.member.vo.GuildMemberVO;
import seven.member.vo.InstancePackage;
import seven.member.vo.MemberWarfaceScoreVO;

public class GuildService {
	
	public GuildService() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	/**
	 * create sqlSession
	 */
	public SqlSession getSqlSession(){
		return ConnectionFactory.getSession().openSession();
	}
	
	
	/**
	 * 전체회원 조회
	 * @return 전체회원 리스트
	 * @throws Exception
	 */
	public List<GuildMemberVO> selectAllMember() throws Exception{
		SqlSession session = getSqlSession();
		List<GuildMemberVO> list = session.getMapper(GuildDAO.class).selectAllMember();
		if(list.size() == 0){
			throw new Exception("회원이 아무도 없습니다.");
		}
		session.close();
		return list;
	}
	/**
	 * 회원조회
	 * @param nick 닉네임
	 * @return 해당 회원 정보
	 * @throws Exception
	 */
	public GuildMemberVO selectMember(String nick) throws Exception{
		SqlSession sqlSession = getSqlSession();
		GuildMemberVO vo = sqlSession .getMapper(GuildDAO.class).selectMemberNick(nick);
		if(vo == null)
			throw new Exception("찾는 회원이 아무도 없습니다.");
		sqlSession.close();
		return vo;
	}
	public GuildMemberVO selectMember(int code) throws Exception{
		SqlSession sqlSession = getSqlSession();
		GuildMemberVO vo = sqlSession .getMapper(GuildDAO.class).selectMemberCode(code);
		if(vo == null)
			throw new Exception("찾는 회원이 아무도 없습니다.");
		sqlSession.close();
		return vo;
	}
	
	
	/**
	 * 회원 등록
	 * @param vo 회원정보
	 * @return 결과 1이면 성공 0이면 실패
	 * @throws Exception
	 */
	public int insertMember(GuildMemberVO vo) throws Exception{
		SqlSession sqlSession = getSqlSession();
		int count =sqlSession .getMapper(GuildDAO.class).insertMember(vo);
		if(count == 0)
			throw new Exception("삽입 실패");
		else{
			System.out.println("정상 등록");
		}
		sqlSession.commit();
		sqlSession.close();
		return count;
	}
	/**
	 * 회원 탈퇴
	 * @param list 해당 회원정보
	 * @return 결과 1이면 성공 1이외면 이면 실패 및 오류
	 * @throws Exception
	 */
	public int dropMember(ArrayList<Integer> list) throws Exception{
		SqlSession sqlSession = getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		AnnotationConfigApplicationContext context = InstancePackage.context;
		DateCustom date = (DateCustom) context.getBean("getDateCustom");
		map.put("list", list);
		map.put("date", date.currentDate());
		System.out.println("map 정보 : "+map);
		int count =sqlSession .getMapper(GuildDAO.class).dropMember(map);
		if(count == 0)
			throw new Exception("삭제할 회원이 없습니다");
		else{
			System.out.println("삭제결과 : "+count);
			InstancePackage.nickMemberList = selectAllMemberNick();
		}
		sqlSession.commit();
		sqlSession.close();
		return count;
	}
/**
 * 해당 회원의 date에 해당하는 월의 평균 공성 정보
 * @param code 회원번호
 * @param date 날짜정보
 * @return 공성 정보(회원명, 회원코드, 평균)
 * @throws Exception
 */
	public HashMap<String, Object> selectMemberMonthWarfaceAverageScore(int code, String date) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("date", date+"-%");
		SqlSession sqlSession = getSqlSession();
		map = sqlSession .getMapper(GuildDAO.class).selectAllMemberMonthWarfaceScore(map);
		sqlSession.close();
		return map;
	}
	/**
	 * 해당 회원의 월 공성점수 조회
	 * @param code 회원코드
	 * @param date 조회할 월
	 * @return 회원공성정보VO
	 * @throws Exception
	 */
	public MemberWarfaceScoreVO selectMonthWarfaceScore(int code, String date) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("date", date+"-%");
		SqlSession sqlSession = getSqlSession();
		List<HashMap<String, Object>> list = sqlSession .getMapper(GuildDAO.class).selectMemberMonthWarfaceScore(map);
		MemberWarfaceScoreVO vo = new MemberWarfaceScoreVO();
		vo.setCode(code);
		vo.setDate(date);
		vo.setList(list);
		vo.setNick(selectMember(code).getNick());
		sqlSession.close();
		return vo;
	}
	
	/**
	 * 전체 회원의 해당월 공성 점수 평균값 조회
	 * @param date 해당 월
	 * @return 전체 회원 공성 점수 평균값 리스트
	 * @throws Exception
	 */
	public List<HashMap<String, Object>> selectAllMemberMonthWarfaceAverageScore(String date) throws Exception {
		SqlSession sqlSession = getSqlSession();
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> list = sqlSession .getMapper(GuildDAO.class).selectAllMemberMonthWarfaceAverageScore(date+"-%");
		sqlSession.close();
		return list;
	}
	
	/**
	 * 전체회원 해당월 공성 점수 조회
	 * @param date 조회월 날짜
	 * @return 전체회원 공성점수VO list
	 * @throws Exception
	 */
	public ArrayList<MemberWarfaceScoreVO> selectAllMemberMonthWarfaceScore(String date) throws Exception{
		ArrayList<MemberWarfaceScoreVO> list = new ArrayList<MemberWarfaceScoreVO>();
		
		SqlSession sqlSession = getSqlSession();
		List<Integer> currentMemberCodeList = sqlSession .getMapper(GuildDAO.class).selectCurrentMember();
		
		for(int i=0;i<currentMemberCodeList.size();i++){
			list.add(selectMonthWarfaceScore(currentMemberCodeList.get(i), date));			
		}
		sqlSession.close();
		return list;
		
	}
	
	/**
	 * 전체 길드원 해당 날짜로 공성전 점수 조회
	 * @param date 조회할 날짜
	 * @return [{코드,닉네임,공성전점수}] 
	 */
	public List<HashMap<String, Object>> selectAllMemberDateWarface(String date){
		SqlSession sqlSession = getSqlSession();
		List<HashMap<String, Object>> list =sqlSession .getMapper(GuildDAO.class).selectAllMemberDateWarface(date);
		sqlSession.close();
		return list;
	}
	
	public ArrayList<String> selectDateNotWarfaceMember(String date) throws Exception{
		List<HashMap<String, Object>> warfaceList = selectAllMemberDateWarface(date);
		List<String> memberList = InstancePackage.nickMemberList;
		
		ArrayList<String> resultList = new ArrayList<String>(memberList); 
		System.out.println("회원 명단 : "+memberList+"인원수:"+memberList.size());
		System.out.println("공성참석 명단 : "+warfaceList);
		if(warfaceList.size()==0){
			System.out.println("공성 아무도 안함");
			return resultList;
		}
		for(int i=0;i<warfaceList.size();i++){
			if(resultList.contains(warfaceList.get(i).get("nick"))){
				resultList.remove(warfaceList.get(i).get("nick"));
			}
		}
		System.out.println("결과 : "+resultList);
		return resultList;
	}
	
	public List<String> selectAllMemberNick(){
		List<String> list = null;
		try {
			SqlSession sqlSession = getSqlSession();
			list = sqlSession .getMapper(GuildDAO.class).selectAllMemberNick();
			sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("selectAllMemberNick : "+list);
		return list;		
	}
	
	public List<HashMap<String, Object>> selectGuildWarInfo(String date) throws Exception{
		SqlSession sqlSession=getSqlSession();
		List<HashMap<String, Object>> list = sqlSession.getMapper(GuildDAO.class).selectGuildWarInfo(date);
		System.out.println("selectGuildWarInfo : "+list);
		sqlSession.close();
		return list;
	}

	public List<String> selectDateNotGuildWar(String date) throws Exception {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> guildwarList = selectGuildWarInfo(date);
		List<String> memberList = InstancePackage.nickMemberList;
		System.out.println("회원 리스트 : "+memberList);
		System.out.println("참여 리스트 : " + guildwarList);
		
		ArrayList<String> resultList = new ArrayList<String>(memberList);
		if(guildwarList.size()==0){
			return resultList;
		}
		for(int i=0;i<guildwarList.size();i++){
			if(resultList.contains(guildwarList.get(i).get("nick"))){
				resultList.remove(guildwarList.get(i).get("nick"));
			}
		}
		System.out.println("결과 : "+resultList);
		return resultList;
	}
	public void insertWarfaceScore(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		boolean temp = selectDateWarfaceMember(map);
		SqlSession session =getSqlSession();
		if(temp){
			session.getMapper(GuildDAO.class).updateDateWarfaceMember(map);
			System.out.println("업데이트 완료");
		}else{
			session.getMapper(GuildDAO.class).insertDateWarfaceMember(map);
			System.out.println("삽입 완료");
		}
		session.commit();
		session.close();
		
	}
	
	private boolean selectDateWarfaceMember(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSession();
		HashMap<String, Object> result = session.getMapper(GuildDAO.class).selectDateWarfaceMember(map);
		System.out.println("selectDateWarfaceMember 결과: "+result);
		session.close();
		if(result == null)
			return false;
		else
			return true;
	}
	public void guildwarInsert(ArrayList<HashMap<String, Object>> list) throws Exception {
		// TODO Auto-generated method stub
		List<GuildMemberVO> member = selectAllMember();
		String date = (String) list.get(0).get("date");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("date", date);
		map.put("takepart", 0);
		
		for(int i=0;i<list.size();i++){
			for(int j=0;j<member.size();j++){
				if(member.get(j).getCode()==(Integer) list.get(i).get("code")){
					member.remove(j);
					break;
				}
			}
		}
		for(int i=0;i<member.size();i++){
			HashMap<String, Object> temp =new HashMap<String, Object>(map);
			temp.put("code", member.get(i).getCode());
			list.add(temp);
		}
		System.out.println("통합 : " + list);
		
		SqlSession session = getSqlSession();
		List current = session.getMapper(GuildDAO.class).selectGuildWarInfo(date);
		if(current.size() > 0){
			for(int i=0;i<list.size();i++){
				session.getMapper(GuildDAO.class).updateDateGuildWar(list.get(i));
			}
			System.out.println("길드전 정보 갱신");
		}else{
			for(int i=0;i<list.size();i++){
				session.getMapper(GuildDAO.class).insertDateGuildWar(list.get(i));
			}
			System.out.println("길드전 정보 삽입");
		}
		session.commit();
		session.close();
	}
	
}
