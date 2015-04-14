package seven.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import seven.date.DateCustom;
import seven.member.service.GuildService;

@Configuration
public class DIFactory {
	@Bean
	public GuildService getGuildService(){
		return new GuildService();
	}
	
	@Bean
	public DateCustom getDateCustom(){
		return new DateCustom();
	}
}
