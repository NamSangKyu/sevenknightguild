package com.seven.guild;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import seven.date.DateCustom;
import seven.member.service.GuildService;
import seven.member.vo.GuildMemberVO;
import seven.member.vo.InstancePackage;
import seven.spring.DIFactory;

import com.email.EMail;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	AnnotationConfigApplicationContext context = InstancePackage.context;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value="/guildInfo.do", method=RequestMethod.GET)
	public String guildInfo(HttpServletRequest request){
		System.out.println("guildInfo");
		//request.setAttribute("info", arg1);
		request.setAttribute("memberCount", "30");
		return "guildInfo";
	}
	
	@RequestMapping(value="/warfaceView.do", method=RequestMethod.GET)
	public String warfaceView(HttpServletRequest request){
		System.out.println("warfaceView");
		String date = ((DateCustom) context.getBean("getDateCustom")).currentDate();
		System.out.println(date);
		request.setAttribute("date", date);
		return "warface/warfaceInfo";
	}
	
	
	
	@RequestMapping(value="/warfaceInfo.do", method=RequestMethod.GET)
	public String warfaceInfo(HttpServletRequest request,@RequestParam("date") String date){
		System.out.println("warfaceInfo");
		if(date == null)
			date = ((DateCustom) context.getBean("getDateCustom")).currentDate();
		System.out.println(date);
		try {
			List<HashMap<String, Object>> list = getGuildService().selectAllMemberDateWarface(date);
			System.out.println("warfaceInfo : "+list);
			
			request.setAttribute("list", list);
			request.setAttribute("date", date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "warface/warface_detail";
	}
	@RequestMapping(value="/warfaceResult.do", method=RequestMethod.GET)
	public String warfaceResult(HttpServletRequest request,@RequestParam("date") String date){
		System.out.println("warfaceResult");
		if(date == null)
			date = ((DateCustom) context.getBean("getDateCustom")).currentDate();
		System.out.println(date);
		try {
			 List<String> list = getGuildService().selectDateNotWarfaceMember(date);
			System.out.println("warfaceResult : "+list);
			request.setAttribute("mlist", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "warface/warface_result";
	}
	
	@RequestMapping(value="/guildwarinfo.do")
	public String guildwarInfoView(HttpServletRequest request){
		String date = ((DateCustom)context.getBean("getDateCustom")).currentDate();
		request.setAttribute("date", date);
		return "guildwar/guildwarInfo";		
	}
	
	@RequestMapping(value="/guildwardetail.do", method=RequestMethod.GET)
	public String guildwarDetail(HttpServletRequest request, @RequestParam("date") String date){
		System.out.println("guildwarDetail");
		try {
			List<HashMap<String, Object>> list = getGuildService().selectGuildWarInfo(date);
			System.out.println("guildwarDetail : "+list);
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "guildwar/guildwar_detail";		
	}
	
	@RequestMapping(value="/guildwarresult.do")
	public String guildwarResult(HttpServletRequest request, @RequestParam("date") String date){
		System.out.println("guildwarResult");
		if(date == null)
			date = ((DateCustom) context.getBean("getDateCustom")).currentDate();
		System.out.println(date);
		try {
			List<String> list = getGuildService().selectDateNotGuildWar(date);
			System.out.println("guildwarResult : "+list);
			request.setAttribute("mlist", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "guildwar/guildwar_result";		
	}
	
	@RequestMapping(value="/guildInsertMessage.do", method=RequestMethod.POST)
	public String guildInsertMessage(@RequestParam("nick") String nick, @RequestParam("kakao") String kakao, @RequestParam("message") String message ){
		System.out.println("email");
		
		EMail e = new EMail();
		e.settingProperties(3);
		e.send("nam2626@naver.com", "nam2626@gmail.com", "sky9881@naver.com", nick+" 가입신청", message +"\n카카오톡 : "+kakao, "nam2626@naver.com");
		System.out.println("메일 전송 완료");
		return "index";
	}
	
	@RequestMapping(value="/memberInsertView.do")
	public String memberInsertView(){
		return "memberInsert";
	}
	
	private GuildService getGuildService(){
		return (GuildService) context.getBean("getGuildService");	
	}
	
	
	@RequestMapping(value="/master")
	public String masterLoginView(){
		System.out.println("masterLoginView");
		return "master/masterLogin";
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST )
	public String masterLogin(HttpServletRequest request){
		HttpSession session= request.getSession();
		String str = (String) session.getAttribute("login");
		if(str != null){
			if(str.equals("access"))
				return "master/masterMain";
		}else{
			try{
			String pass = request.getParameter("password");
			if(pass .equals("역시역시!@#") || pass.equals("durtldurtl!@#")){
				session.setAttribute("login", "access");
				return "master/masterMain";
			}
			}catch(NullPointerException e){
				System.out.println(e.getMessage());
				return "master/masterLogin";
			}
		}
		return "master/masterLogin";
	}
	
	
	
	@RequestMapping(value="/guildmemberView.do")
	public String guildMemberView(){
		return "master/guildmemberView";
	}
	@RequestMapping(value="/guildmemberlist.do")
	public String guildMemberList(HttpServletRequest request){
		try {
			List<GuildMemberVO> list = getGuildService().selectAllMember();
			System.out.println("전체 길드원 정보 : "+list);
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "master/guildmemberdetail";
	}
	
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(HttpServletRequest request){
		String code[] = request.getParameterValues("code");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<code.length;i++){
			System.out.println(code[i]);
			list.add(Integer.parseInt(code[i]));
		}
		
		try {
			getGuildService().dropMember(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return guildMemberList(request);
	}
	
	@RequestMapping(value="logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("로그아웃");
		return "index";
	}
	@RequestMapping(value="guildmemberInsert.do")
	public String guildmemberInsertView(){
		return "master/guildmemberInsert";
	}
	
	@RequestMapping(value="memberInsert.do", method=RequestMethod.POST)
	public String guildmemberInsert(HttpServletRequest request){
		String nick = request.getParameter("nick") ;
		int level = Integer.parseInt(request.getParameter("level"));
		System.out.println("nick : "+nick);
		System.out.println("level : "+level);
		String date = ((DateCustom)context.getBean("getDateCustom")).currentDate();
		try {
			getGuildService().insertMember(new GuildMemberVO(nick, level, date));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return masterLogin(request);
	}
	
	@RequestMapping(value="/masterWarfaceView.do", method=RequestMethod.GET)
	public String masterWarfaceView(HttpServletRequest request){
		System.out.println("masterWarfaceView");
		String date = ((DateCustom) context.getBean("getDateCustom")).currentDate();
		System.out.println(date);
		request.setAttribute("date", date);
		return "master/warfaceView";
	}
	
	@RequestMapping(value="/warfaceInput.do", method=RequestMethod.GET)
	public String masterWarfaceInfo(HttpServletRequest request){
		System.out.println("warfaceInput");
		String date = ((DateCustom) context.getBean("getDateCustom")).currentDate();
		System.out.println(date);
		request.setAttribute("date", date);
		
		HttpSession session = request.getSession();
		try {
			List<GuildMemberVO> list = getGuildService().selectAllMember();
			session.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "master/warfaceInput";
	}
	
	@RequestMapping(value="insertWarfaceScore.do")
	public void insertWarfaceScore(HttpServletRequest request,HttpServletResponse response){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", Integer.parseInt(request.getParameter("code")));
		map.put("score", Integer.parseInt(request.getParameter("score")));
		map.put("date", request.getParameter("date"));
		
		System.out.println(map);
		PrintWriter pw = null;
		try {
			getGuildService().insertWarfaceScore(map);
			pw = response.getWriter();
			pw.println(map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pw!=null)
				pw.close();
		}
		
		
	}

	@RequestMapping(value="/masterGuildwarView.do", method=RequestMethod.GET)
	public String masterGuildwarView(HttpServletRequest request){
		System.out.println("masterGuildwarView");
		String date = ((DateCustom) context.getBean("getDateCustom")).currentDate();
		System.out.println(date);
		request.setAttribute("date", date);
		return "master/guildwarView";
	}
	
	@RequestMapping(value="/guildwarInput.do", method=RequestMethod.GET)
	public String guildwarInput(HttpServletRequest request){
		System.out.println("guildwarInput");
		String date = ((DateCustom) context.getBean("getDateCustom")).currentDate();
		System.out.println(date);
		request.setAttribute("date", date);
		HttpSession session = request.getSession();
		try {
			List<GuildMemberVO> list = getGuildService().selectAllMember();
			session.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "master/guildwarInput";
	}
	
	
	@RequestMapping(value="guildwarInsert.do")
	public void guildwarInsert(HttpServletRequest request, HttpServletResponse response){
		System.out.println("guildwarInsert");
		String date = request.getParameter("date");
		String code[] = request.getParameterValues("code");
		System.out.println(date);
		System.out.println(Arrays.toString(code));
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("date", date);
		for(int i=0;i<code.length;i++){
			list.add(new HashMap<String, Object>(map));
			list.get(i).put("code", Integer.parseInt(code[i]));
			list.get(i).put("takepart", 1);
		}
		System.out.println(list);
		
		try {
			getGuildService().guildwarInsert(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
