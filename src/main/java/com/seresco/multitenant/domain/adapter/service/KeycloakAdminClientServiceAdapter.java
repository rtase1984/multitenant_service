package com.seresco.multitenant.domain.adapter.service;

import com.seresco.multitenant.domain.port.keycloakAdminClientServicePort;
import com.seresco.multitenant.infrastructure.config.keycloak.KeycloakInstance;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeycloakAdminClientServiceAdapter implements keycloakAdminClientServicePort {

    @Autowired
    private KeycloakInstance keycloakInstance;

    @Override
    public RealmRepresentation createRealm(RealmRepresentation realmRepresentation) {
        Keycloak keycloak = keycloakInstance.getKeycloakInstance();
        keycloak.tokenManager().getAccessToken();
        keycloak.realms().create(realmRepresentation);
        return realmRepresentation;
    }
}
