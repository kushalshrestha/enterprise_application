package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ConfigurationProperties
@Component
@Validated
public class Properties {
    @Value("${app.name}")
    @NotBlank
    private String appName;
    @Value("${app.version}")
    @NotBlank
    private String appVersion;
    @Value("${app.server.url}")
    @NotBlank
    private String serverUrl;
    @Value("${app.server.name}")
    private String serverName;
    @Value("${app.user.firstname}")
    private String userFirstName;
    @Value("${app.user.lastname}")
    private String userLastName;

    @Value("${app.user.password}")
    @NotBlank
    @Size(min=8, max=15)
    private String password;
    @Value("${app.countries}")
    private String[] countries;

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



    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }
}
