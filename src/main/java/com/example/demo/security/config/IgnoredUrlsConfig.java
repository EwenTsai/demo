package com.example.demo.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "ignored.url")
public class IgnoredUrlsConfig {

    private List<String> lists = new ArrayList<>();

}
