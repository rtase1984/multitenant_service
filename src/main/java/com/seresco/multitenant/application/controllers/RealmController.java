package com.seresco.multitenant.application.controllers;

import com.seresco.multitenant.domain.port.keycloakAdminClientServicePort;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/keycloak/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class RealmController {

    @Autowired
    private keycloakAdminClientServicePort servicePort;

    @PostMapping("/realm")
    public RealmRepresentation createRealm(@RequestBody RealmRepresentation realmRepresentation){
        return servicePort.createRealm(realmRepresentation);
    }

}
