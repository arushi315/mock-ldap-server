package com.airwatch.ldapserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by arushir on 7/26/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class MockLdapServerTest {
    @InjectMocks
    private  MockLdapServer mockLdapServer;

    @Test
    public void testApacheDSContainer(){
      mockLdapServer.apacheDSContainerSetup();
    }
}
