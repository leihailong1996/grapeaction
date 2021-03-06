package www.grapeaction.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication
//@EnableTransactionManagement
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
/*
    启动方法
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("www.grapeaction.com.dao")
public class GrapeactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrapeactionApplication.class, args);
    }

}

