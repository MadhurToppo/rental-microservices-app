package com.madhurtoppo.rentalapp.rentalui.config;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/***
 * @author Madhur Toppo
 * @since 28 March 2020
 */
public class AccessToken {

    /**
     * Method to get OAuth2 Access Token
     *
     * @return access token after concatenating the token-type and token-value
     */
    public static String getAccessToken() {
        OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getDetails();

        return authenticationDetails
                .getTokenType()
                .concat(" ")
                .concat(authenticationDetails.getTokenValue());
    }

    /**
     * Method to get Http header with Authorization Access Code
     * @return
     */
    public static HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", getAccessToken());
        return httpHeaders;
    }

}
