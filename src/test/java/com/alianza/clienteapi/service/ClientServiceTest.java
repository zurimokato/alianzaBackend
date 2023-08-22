package com.alianza.clienteapi.service;

import com.alianza.clienteapi.dao.ClientDAO;
import com.alianza.clienteapi.json.ClientRequest;
import com.alianza.clienteapi.json.ClientSearchCriteria;
import com.alianza.clienteapi.model.ClientModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.TransactionSystemException;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientDAO clientDAO;


    @Test
    public  void testCreateClient(){
        ClientRequest clientRequest=new ClientRequest();

        clientRequest.setName("test testA test");
        clientRequest.setUserName("testUser");
        clientRequest.setDocument("123456789");
        clientRequest.setPhone("12546977");
        clientRequest.setEmail("test@test.com");

        clientService.createClient(clientRequest);

        ClientModel clientSaved=clientDAO.getClientModelByClientId_Document("123456789").orElse(null);
        Assertions.assertNotNull(clientSaved);
        Assertions.assertEquals("testUser",
                clientSaved.getClientId().getUserName());
    }

    @Test
    public  void testCreateClientEmail(){
        ClientRequest clientRequest=new ClientRequest();

        clientRequest.setName("test testA test");
        clientRequest.setUserName("testUser");
        clientRequest.setDocument("123456789");
        clientRequest.setPhone("12546977");
        clientRequest.setEmail("test@test.com");

        clientService.createClient(clientRequest);

        ClientModel clientSaved=clientDAO.getClientModelByClientId_Document("123456789").orElse(null);
        Assertions.assertNotNull(clientSaved);
        Assertions.assertEquals("test@test.com",clientSaved.getEmail());

    }



    @Test
    public  void testCreateClientError(){

        ClientRequest clientRequest=new ClientRequest();

        clientRequest.setName("test testA test");
        clientRequest.setUserName("testUser");
        clientRequest.setDocument("123456789");
        Exception exception = Assertions.assertThrows(TransactionSystemException.class, () -> clientService.createClient(clientRequest));


        Assertions.assertTrue(exception instanceof TransactionSystemException);
    }


    @Test
    public void testAdvancedSearch(){
        ClientRequest clientRequest=new ClientRequest();

        clientRequest.setName("test testA test");
        clientRequest.setUserName("testUser");
        clientRequest.setDocument("123456789");
        clientRequest.setPhone("12546977");
        clientRequest.setEmail("test@test.com");


        ClientRequest clientRequest2=new ClientRequest();

        clientRequest2.setName("test testB test");
        clientRequest2.setUserName("testUserB");
        clientRequest2.setDocument("1234567893");
        clientRequest2.setPhone("125469772");
        clientRequest2.setEmail("testB@test.com");

        ClientRequest clientRequest3=new ClientRequest();
        clientRequest3.setName("test testC test");
        clientRequest3.setUserName("testUserC");
        clientRequest3.setDocument("1234567895");
        clientRequest3.setPhone("125469778");
        clientRequest3.setEmail("testC@test.com");

        clientService.createClient(clientRequest);
        clientService.createClient(clientRequest2);
        clientService.createClient(clientRequest3);

        ClientSearchCriteria criteria=new ClientSearchCriteria();
        criteria.setName("test testC test");
        criteria.setPhone("125469778");
        criteria.setEmail("testC@test.com");
        Pageable pageable = PageRequest.of(0, 10);
        Page<ClientModel>result=clientService.advancedSearch(criteria, pageable);

        Assertions.assertEquals(result.getTotalElements(),1);
    }

}
