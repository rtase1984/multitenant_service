package com.seresco.multitenant.infrastructure.config.keycloak;

import com.seresco.multitenant.infrastructure.config.yaml.YAMLConfig;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeycloakInstanceImpl implements KeycloakInstance {

    @Autowired
    private YAMLConfig yamlConfig;

    @Override
    public Keycloak getKeycloakInstance() {

        return KeycloakBuilder.builder()
                .serverUrl(yamlConfig.getProperty("keycloak.auth-server-url"))
                .grantType(OAuth2Constants.PASSWORD)
                .realm(yamlConfig.getProperty("keycloak.realm"))
                .clientId(yamlConfig.getProperty("keycloak.resource"))
                .username(yamlConfig.getProperty("keycloak.credential.username"))
                .password(yamlConfig.getProperty("keycloak.credential.password"))
                .resteasyClient(
                        new ResteasyClientBuilder()
                                .connectionPoolSize(10).build()
                ).build();
    }
}
