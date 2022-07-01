package prototype.hifi.dnick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DnickApplication {

    public static void main(String[] args) {
        SpringApplication.run(DnickApplication.class, args);
    }

}
