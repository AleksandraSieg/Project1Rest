package pl.b2bnetworks.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.b2bnetworks.domain.Client;
import pl.b2bnetworks.services.IClientServices;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    }

    @Test
    public void findById() throws Exception {
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