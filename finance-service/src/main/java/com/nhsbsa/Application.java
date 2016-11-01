package com.nhsbsa;

import com.nhsbsa.config.AppConfig;
import com.nhsbsa.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by jeffreya on 16/08/2016.
 *
 */

@SpringBootApplication
@Import({AppConfig.class, SwaggerConfig.class})
public class Application {

    Application() {
        //Needed for spring boot
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
