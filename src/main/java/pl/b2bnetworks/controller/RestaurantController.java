package pl.b2bnetworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnetworks.domain.Client;
import pl.b2bnetworks.services.IClientServices;
import pl.b2bnetworks.util.ClientUtils;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private IClientServices iClientServices;

    @RequestMapping(value = "/showClients", method = RequestMethod.GET)
    public List<Client> showClients() {
        return (List<Client>) iClientServices.findAll();
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.PUT)
    public String addClient(@RequestParam("surname") String surname, @RequestParam("order") double order) {
        Client client = new Client();
        client.builder().surname(surname).order(order).build();

        iClientServices.save(client);
        return "completed";
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Client findById(@RequestParam("id") Long id) {
        return iClientServices.findOne(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateClient(@RequestParam("id") Long id, @RequestParam("surname") String surname,
                               @RequestParam("order") double order) {
        Client client = iClientServices.findOne(id);
        client.setSurname(surname);
        client.setOrder(order);
        iClientServices.save(client);
        return "completed";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteClient(@RequestParam("id") Long id) {
        iClientServices.delete(id);
        return "completed";
    }

    private ClientUtils clientUtils = new ClientUtils();
    @RequestMapping(value = "/dailyIncome", method = RequestMethod.GET)
    public String dailyIncomeShow() {
        return "daily income: " + clientUtils.dailyIncome((List<Client>)iClientServices);
    }


}
