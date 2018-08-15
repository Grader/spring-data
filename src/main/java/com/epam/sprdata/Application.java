package com.epam.sprdata;

import com.epam.sprdata.rest.RESTClientGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableCaching
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        log.info("response 1: {}", ((RESTClientGoods) context.getBean("restClient")).getAllGoods());
        log.info("response 2: {}", ((RESTClientGoods) context.getBean("restClient")).getGoods("3"));
        log.info("response 3: {}", ((RESTClientGoods) context.getBean("restClient")).getTranslate
                ("trnsl.1.1.20180814T170902Z.00ef54543e0b6b00.ea30e19c253c364884595bfd3f4d5e9554a40f9d",
                        "Hello world", "en-ru"));
    }

    @Bean
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }

}
