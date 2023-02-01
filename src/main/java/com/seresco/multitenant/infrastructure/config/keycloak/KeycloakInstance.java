package com.seresco.multitenant.infrastructure.config.keycloak;

import org.keycloak.admin.client.Keycloak;

public interface KeycloakInstance {

    Keycloak getKeycloakInstance();

}
