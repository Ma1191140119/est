package cn.est;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@MapperScan("cn.est.mapper")
@SpringBootApplication
public class EstWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstWebApplication.class, args);
    }

}
