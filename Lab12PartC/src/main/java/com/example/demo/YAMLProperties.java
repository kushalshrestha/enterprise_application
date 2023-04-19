package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ConfigurationProperties
@Component
public class YAMLProperties {
    @Value("${appYML.name}")
    @NotBlank
    private String appName;
    @Value("${appYML.version}")
    @NotBlank
    private String appVersion;
    @Value("${appYML.server.url}")
    @NotBlank
    private String serverUrl;
    @Value("${appYML.server.name}")
    private String serverName;
    @Value("${userYML.firstname}")
    private String userFirstName;
    @Value("${userYML.lastname}")
    private String userLastName;
    @Value("${userYML.username}")
    private String username;
    @Value("${userYML.password}")
    @NotBlank
    private String password;
    @Value("${countriesYML}")
    private String[] countries;
//    private List<String> countries = new ArrayList<String>();

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }
}
