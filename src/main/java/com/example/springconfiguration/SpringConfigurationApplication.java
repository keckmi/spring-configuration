package com.example.springconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringConfigurationApplication {


	public interface SaySomethingService {
		public String saySomething();
	}

	//Dieser Teil war in Projekt spring-dependency-injection noch einkommentiert
	/*@Component
	public class SayHelloService implements SaySomethingService {

		@Override
		public String saySomething() {
			return "Hello World!";
		}
	}*/

	@Configuration
	public class SaySomethingConfiguration {
		@Bean
		public SaySomethingConfigurableService saySomethingConfigurableService() {
			SaySomethingConfigurableService saySomethingConfigurableService = new SaySomethingConfigurableService();
			saySomethingConfigurableService.setWhatToSay("Goodbye");
			return saySomethingConfigurableService;
		}
	}

	public class SaySomethingConfigurableService implements SaySomethingService {
		private String whatToSay = "";

		@Override
		public String saySomething() {
			return whatToSay;
		}

		public String getWhatToSay() {
			return whatToSay;
		}
		public void setWhatToSay(String whatToSay) {
			this.whatToSay = whatToSay;
		}


	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringConfigurationApplication.class, args);
		SaySomethingService saySomethingService = applicationContext.getBean(SaySomethingService.class);
		System.out.println(saySomethingService.saySomething());
	}

}
