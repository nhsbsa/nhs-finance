package com.nhsbsa;

import com.nhsbsa.config.AppConfig;
import com.nhsbsa.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jeffreya on 16/08/2016.
 *
 */

@SpringBootApplication
@EnableCircuitBreaker
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
                                    DataSourceTransactionManagerAutoConfiguration.class,
                                    HibernateJpaAutoConfiguration.class})
@Import({AppConfig.class, SwaggerConfig.class})
public class Application {

    public Application() {

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
