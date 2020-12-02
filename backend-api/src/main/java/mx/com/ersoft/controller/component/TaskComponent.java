package mx.com.ersoft.controller.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskComponent {

	private static final Logger log = LoggerFactory.getLogger(TaskComponent.class);
	
	@Scheduled(fixedDelay = 5000)
	public void doTask() {
		log.info("Time is: " + new Date());
	}
}
