package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Api(value = "Client Api", tags = {"Client Service"})
@RequestMapping(value = "/client", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClientController {
    private IClientService clientService;

    //Get all
    @GetMapping(value = "/getAllClient")
    @ApiOperation(
            value = "List of all client",
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
            //@ApiResponse(code = 400 , message = "Bad request/Invalid field")
    })
    public ResponseEntity<?> findAllDetail() throws NotFoundException, InternalException {
        List<ClientResponse> clientResponse = clientService.findAllClient();
        return ResponseEntity.ok(clientResponse);
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
            @PathVariable("id") Long id
    )  throws BadRequestException, InternalException, NotFoundException {
            return ResponseEntity.ok(clientService.findClientById(id));
    }

    //Create client, address and client detail
    @PostMapping(
            value = "/createClient",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Create client, address and client detail created",
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
            @RequestBody ClientCreateRequest request
    ) {
        ClientResponse clientResponse = clientService.createClient(request);
        return new ResponseEntity<>(clientResponse, HttpStatus.CREATED);
    }

    //Update data in client
    @PatchMapping(value = "/updateClient/{id}")
    @ApiOperation(
            value = "Show an client updated",
            httpMethod = "PATCH",
            response = ClientDetailResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with all information about an client updated",
                    response = ClientDetailResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form"),
            @ApiResponse(code = 404, message = "Client not found"),
    })
    public ResponseEntity<?> updateClient(
            @ApiParam(value = "id of client to update", required = true, example = "1")
            @PathVariable(name = "id") Long idClient,
            @ApiParam(value = "data of client", required = true)
            @RequestBody ClientUpdateRequest request
    ) throws NotFoundException, BadRequestException, InternalException {
            return ResponseEntity.ok(clientService.updateClient(idClient, request));
    }

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
    ) throws BadRequestException, NotFoundException, InternalException {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
