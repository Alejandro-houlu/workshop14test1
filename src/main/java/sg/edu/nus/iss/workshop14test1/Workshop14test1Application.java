package sg.edu.nus.iss.workshop14test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Workshop14test1Application {

	public static void main(String[] args) {
		SpringApplication.run(Workshop14test1Application.class, args);


	}

}
