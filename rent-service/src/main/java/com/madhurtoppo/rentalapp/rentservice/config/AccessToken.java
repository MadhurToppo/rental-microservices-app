package com.madhurtoppo.rentalapp.rentservice.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/***
 * @author Madhur Toppo
 * @since 28 March 2020
 */
public class AccessToken {

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
}
