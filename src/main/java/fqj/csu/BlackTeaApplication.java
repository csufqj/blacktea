package fqj.csu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class BlackTeaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlackTeaApplication.class,args);
    }


}
