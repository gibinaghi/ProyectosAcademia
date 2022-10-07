package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@Api(value = "Client Api", tags = {"Client Service"})
@RequestMapping(value = "/client", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClientControllerImpl {
    private IClientService clientService;

    //Get all
    @GetMapping(value = "/getAllClient")
    @ApiOperation(
            value = "Retrieves List of all client",
            httpMethod = "GET",
            response = ClientResponse[].class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Shows the list of detail",
                    response = ClientResponse[].class
            ),
            @ApiResponse(code = 404, message = "Client not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<?> findAllDetail(){

        List<ClientResponse> clientReponse = null;
        Map<String, Object> response = new HashMap<>();

        try {
            clientReponse  = clientService.findAllClient();
        } catch (ReadAccessException e) {
            response.put("Mensaje", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }catch (Exception ex) {
            response.put("Código de error", 400);
            response.put("Mensaje", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(clientReponse);
    }

    //Get by id
    @GetMapping(value = "/clientById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Show client by Id",
            httpMethod = "GET",
            response = ClientResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success. Client found by ID."),
            @ApiResponse(code = 404, message = "Client not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<?> findClientById(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable("id") Long id){

        Map<String, Object> response = new HashMap<>();

        try {
            return ResponseEntity.ok(clientService.findClientById(id));
        } catch (ReadAccessException e) {
            response.put("Código de error", 404);
            response.put("Mensaje", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }catch (Exception ex) {
            response.put("Código de error", 400);
            response.put("Mensaje", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //Create client, address and client detail
    @PostMapping(
            value = "/createClient",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Retrieves a client created",
            httpMethod = "POST",
            response = AddressResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about client",
                    response = AddressResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<ClientResponse> createClient(
            @ApiParam(value = "data of client", required = true)
            @RequestBody ClientRequest request
    ) {
        ClientResponse clientResponse = clientService.createClient(request);
        return new ResponseEntity<>(clientResponse, HttpStatus.CREATED);
    }

    //Update

    //Delete
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Delete a client by id",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success. Client deleted by id"),
            @ApiResponse(code = 404, message = "Client not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deleteClient(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable Long id
    ){
        clientService.deleteClient(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
