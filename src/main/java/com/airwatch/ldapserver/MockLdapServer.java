package com.airwatch.ldapserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.ldap.server.ApacheDSContainer;

/**
 * Created by arushir on 7/26/17.
 */

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan({"com.airwatch.ldapserver"})
public class MockLdapServer {

    public static final String LDAP_PORT = "ldap.port";
    public static final String LDAP_BASE = "ldap.base";
    public static final String LDAP_LDIF_PATH = "/Users/arushir/Desktop/Development/ldap_server/mock-ldap-server/src/test/resources/ldapServer.ldif";
    @Autowired
    private Environment env;

    @Bean
    public ApacheDSContainer apacheDSContainerSetup() {
        ApacheDSContainer apacheDSContainer = null;
        try {
            apacheDSContainer = new ApacheDSContainer("dc=memldap,dc=org", LDAP_LDIF_PATH);
            apacheDSContainer.setPort(389);
            apacheDSContainer.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apacheDSContainer;
    }
}
