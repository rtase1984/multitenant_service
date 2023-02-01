package com.seresco.multitenant.domain.port;

import org.keycloak.representations.idm.RealmRepresentation;

public interface keycloakAdminClientServicePort {

    RealmRepresentation createRealm(RealmRepresentation realmRepresentation);

}
