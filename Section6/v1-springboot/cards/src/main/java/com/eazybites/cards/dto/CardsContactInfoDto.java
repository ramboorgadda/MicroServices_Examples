package com.eazybites.cards.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.HashMap;
import java.util.List;
@ConfigurationProperties(prefix = "cards")
public record CardsContactInfoDto(String message, HashMap<String,String> contactDetails, List<String> onCallSupport) {
}
