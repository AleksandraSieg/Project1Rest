package pl.b2bnetworks.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.b2bnetworks.domain.Client;
import pl.b2bnetworks.services.IClientServices;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantControllerTest {

    @InjectMocks
    private RestaurantController restaurantController;

    @Mock
    private IClientServices iClientServices;

    private MockMvc mockMvc;

    @Before
    public void init(){mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();}

    @Test
    public void showClients() throws Exception {
        List<Client> clients = Arrays.asList(Client.builder().surname("Nowak").build());

        when(iClientServices.findAll()).thenReturn(clients);

        mockMvc.perform(get("/showClients")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].surname").value("Nowak"));
    }

    @Test
    public void addClient() throws Exception {
        List<Client> clients = Arrays.asList(Client.builder().surname("Nowak").build());
        Client client1 = Client.builder().surname("Kowalski").positionFromMenu(30).build();

        when(iClientServices.save(client1)).thenReturn(Client.builder().id(2L).build());

        mockMvc.perform(put("/addClient").param("surname", "Kowalski")
                .param("positionFromMenu", "30"))
                .andExpect(MockMvcResultMatchers.content().string("completed"));
    }

    @Test
    public void findById() throws Exception {
        Client client1 = Client.builder().id(1L).surname("Kowalski").build();
        List<Client> clients = Arrays.asList(client1);

        when(iClientServices.findOne(1L)).thenReturn(client1);

        mockMvc.perform(get("/findById").param("id", "1"))
                .andExpect(MockMvcResultMatchers.content().json("{id:1,surname:Kowalski,positionFromMenu:0.0}"));
    }

    @Test
    public void updateClient() throws Exception {
    }

    @Test
    public void deleteClient() throws Exception {
    }

    @Test
    public void dailyIncomeShow() throws Exception {
    }

}