package com.entrevista.controller;

import com.entrevista.model.Client;
import com.entrevista.model.ClientRequestBody;
import com.entrevista.model.Product;
import com.entrevista.model.ResponseBody;
import com.entrevista.service.ClientService;
import com.entrevista.service.LogService;
import com.entrevista.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Client> getClientList() {
        List<Client> clientList = new ArrayList<>();
        clientList.addAll(clientService.getAllClients());
        return clientList;
    }

    @GetMapping("id/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("name/{name}")
    public Client getClientByName(@PathVariable String name) {
        return clientService.getClientByName(name);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<?> saveClient(@RequestBody ClientRequestBody clientRequestBody) {
        ResponseBody response = new ResponseBody();

        try {
            Client client = new Client();
            client.setName(clientRequestBody.getClient().getName());

            Product product = new Product();
            product.setCodigo(clientRequestBody.getProduct().getCodigo());
            product.setDescription(clientRequestBody.getProduct().getDescription());

            response.setClient(clientService.saveClient(client));
            response.setProduct(productService.saveProduct(product));

            logService.saveLog("Cliente [" + client.getName() + "] registrado.");
            logService.saveLog("Produto [" + product.getDescription() + "] registrado.");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar cliente ou produto");
        }
    }
}
