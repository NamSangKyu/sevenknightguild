package com.seven.guild;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import seven.date.DateCustom;
import seven.member.service.GuildService;
import seven.spring.DIFactory;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*System.out.println(GuildService.getInstance().selectMonthWarfaceScore(1, "2015-04"));
			System.out.println(GuildService.getInstance().selectMemberMonthWarfaceAverageScore(1, "2015-04"));
			System.out.println(GuildService.getInstance().selectAllMemberMonthWarfaceAverageScore("2015-04"));*/
			//System.out.println(GuildService.getInstance().selectAllMemberMonthWarfaceScore("2015-04"));
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIFactory.class);
			GuildService service = (GuildService) context.getBean("getGuildService");
			System.out.println(service.selectAllMemberMonthWarfaceAverageScore("2015-04"));
			System.out.println(service.selectAllMemberMonthWarfaceScore(((DateCustom) context.getBean("getDateCustom")).currentDate()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
