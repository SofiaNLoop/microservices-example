package Microservicios.ExampMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ExampMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampMicroApplication.class, args);
	}

}
