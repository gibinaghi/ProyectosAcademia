package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetaiUpdatelRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetailRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.InvoiceResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientDetailService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Api(value = "Client detail Api", tags = {"Client detail Service"})
@RequestMapping(value = "/client-detail", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClientDetailControllerImpl {
    private IClientDetailService clientDetailService;

    //Get all
    @GetMapping(value = "/getAllClientDetail")
    @ApiOperation(
            value = "Retrieves List of all detail client",
            httpMethod = "GET",
            response = ClientDetailResponse[].class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Shows the list of client detail",
                    response = ClientDetailResponse[].class
            ),
            @ApiResponse(code = 404, message = "Detail client not found"),
            //@ApiResponse(code = 400 , message = "Bad request/Invalid field")
    })
    public ResponseEntity<?> findAllClientDetail() throws NotFoundException, InternalException {
        List<ClientDetailResponse> clientResponse = clientDetailService.findAllClientDetail();
        return ResponseEntity.ok(clientResponse);
    }

    //Get by id
    @GetMapping(value = "/clientDetailById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Show detail client by id",
            httpMethod = "GET",
            response = ClientDetailResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success. Client detail found by ID."),
            //@ApiResponse(code = 404, message = "Client detail not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<?> findClientDetailById(
            @ApiParam(name = "id", required = true, value = "Client detail Id", example = "1")
            @PathVariable("id") Long id
    ) throws BadRequestException, InternalException {
            return ResponseEntity.ok(clientDetailService.findClientDetailById(id));
    }

    //Create client detail and client
    @PostMapping(
            value = "/createClientDetail",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Retrieves a client detail created",
            httpMethod = "POST",
            response = AddressResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about detail client",
                    response = AddressResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<ClientDetailResponse> createClientDetail(
            @ApiParam(value = "data of client detail", required = true)
            @RequestBody ClientDetailRequest request
    ) {
        ClientDetailResponse clientDetailResponse = clientDetailService.createClientDetail(request);
        return new ResponseEntity<>(clientDetailResponse, HttpStatus.CREATED);
    }

    //Update
    @PatchMapping(value = "/updateClientDetail/{id}")
    @ApiOperation(
            value = "Retrieves an client detail updated",
            httpMethod = "PATCH",
            response = InvoiceResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with all information about an client detail updated",
                    response = InvoiceResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form"),
            @ApiResponse(code = 404, message = "Client detail not found"),
    })
    public ResponseEntity<?> updateClientDetail(
            @ApiParam(value = "id of client detail to update", required = true, example = "1")
            @PathVariable(name = "id") Long idClientDetail,
            @ApiParam(value = "data of client detail", required = true)
            @RequestBody ClientDetaiUpdatelRequest request
    ) throws NotFoundException, BadRequestException, InternalException {
            return ResponseEntity.ok(clientDetailService.updateClientDetail(idClientDetail, request));
    }

    //Delete
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Delete a client detail by id",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success. Client detail deleted by id"),
            @ApiResponse(code = 404, message = "Client detail not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deleteClientDetail(
            @ApiParam(name = "id", required = true, value = "Client detail Id", example = "1")
            @PathVariable Long id
    ) throws BadRequestException, NotFoundException, InternalException {
        clientDetailService.deleteClientDetail(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
