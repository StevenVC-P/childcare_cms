package teksystems.casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import teksystems.casestudy.config.FileStorageProperties;

@EnableConfigurationProperties(FileStorageProperties.class)
@SpringBootApplication
public class CasestudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasestudyApplication.class, args);
	}

}
