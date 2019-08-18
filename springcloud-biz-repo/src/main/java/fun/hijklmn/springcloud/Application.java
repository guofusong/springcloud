package fun.hijklmn.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import fun.hijklmn.springcloud.pack.SpringBootLoadingDefaultProperties;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		String propertyStr = new SpringBootLoadingDefaultProperties().setConfigLocation("spring.config.location").addProperties("file:./conf/application.yml").builder();
		
		logger.info("------------> 默认配置文件：" + propertyStr);

		new SpringApplicationBuilder(Application.class).properties(propertyStr).run(args);
		
	}
	
}
