package com.esanchezd.urlsln.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(StartupApplicationListener.class);
	
    @Autowired(required = true)
    private KafkaComponent kafkaComponent;
    
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("Ready to go kafka listener");
		kafkaComponent.consume();
	}

}
