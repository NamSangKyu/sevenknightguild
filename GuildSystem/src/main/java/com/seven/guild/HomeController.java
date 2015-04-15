package com.seven.guild;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
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
	public String masterLogin(HttpServletRequest request,@RequestParam("password") String pass){
		if(pass.equals("역시역시!@#") || pass.equals("durtldurtl!@#")){
			HttpSession session= request.getSession();
			session.setAttribute("login", "access");
			return "master/masterMain";
		}else{
			return "master/masterLogin";
		}
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
		String str[] = request.getParameterValues("code");
		for(int i=0;i<str.length;i++)
			System.out.println(str[i]);
		
		return guildMemberList(request);
	}
}
