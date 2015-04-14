package seven.member.vo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import seven.member.service.GuildService;
import seven.spring.DIFactory;

public class InstancePackage {
	//AnnotationConfig
	public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIFactory.class);
	
	//길드원 닉네임 리스트
	public final static List<String> nickMemberList = ((GuildService)context.getBean("getGuildService")).selectAllMemberNick();
	
	//Test
	String str;
	
}
