package com.epam.sprdata.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component("restClient")
public class RESTClientGoods {

    private static final Logger log = LoggerFactory.getLogger(RESTClientGoods.class);

    @Autowired
    private RestTemplate restTemplate;

     public String getAllGoods() {
        return restTemplate.getForObject("http://localhost:8080/goods", String.class);
    }

    public String getGoods(String tag) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host("localhost").port(8080)
                .path("/goods/").path(tag).build();
        log.info("uriComponents: {}", uriComponents.toUriString());
        return restTemplate.getForObject(uriComponents.toUriString(), String.class);
    }

    public String getTranslate(String key, String text, String lang) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host("translate.yandex.net/api/v1.5/tr.json/translate")
                .query("key={key}&text={text}&lang={lang}").buildAndExpand(key, text, lang);
        log.info("uriComponents: {}", uriComponents.toUriString());
        return restTemplate.getForObject(uriComponents.toUriString(), String.class);
    }
}
