package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.IAddressService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Api(value = "Address Api", tags = {"Address Service"})
@RequestMapping(value = "/address", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AddressController {

    private IAddressService addressService;

    //Get all
    @GetMapping(value = "/getAllAddress")
    @ApiOperation(
            value = "List all address.",
            httpMethod = "GET",
            response = AddressResponse[].class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Shows the list of address",
                    response = AddressResponse[].class
            ),
            @ApiResponse(code = 404, message = "Detail address not found"),
            //@ApiResponse(code = 400 , message = "Bad request/Invalid field")
    })
    public ResponseEntity<?> findAllAddress() throws NotFoundException, InternalException {
        List<AddressResponse> addressResponse = addressService.findAllAddress();
        return ResponseEntity.ok(addressResponse);
    }

    //Get by id
    @GetMapping(value = "/addressById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Show address by Id.",
            httpMethod = "GET",
            response = AddressResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success. Address found by ID."),
            @ApiResponse(code = 404, message = "Address not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")
    })
    public ResponseEntity<?> findAddressById(
            @ApiParam(name = "id", required = true, value = "Address Id", example = "1")
            @PathVariable("id") Long id
    ) throws BadRequestException, InternalException, NotFoundException {
            return ResponseEntity.ok(addressService.findAddressById(id));
    }

    //Create address and set client
    @PostMapping(
            value = "/createAddress",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Create address and set client",
            httpMethod = "POST",
            response = AddressResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about address",
                    response = AddressResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<AddressResponse> createAddress(
            @ApiParam(value = "data of address", required = true)
            @RequestBody AddressRequest request, Long idClient
    ) throws BadRequestException, InternalException {
        AddressResponse addressResponse = addressService.createAddress(request, idClient);
        return new ResponseEntity<>(addressResponse, HttpStatus.CREATED);
    }

    //Create address and client
    @PostMapping(
            value = "/createAddressAndClient",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Create address and client",
            httpMethod = "POST",
            response = AddressResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about address",
                    response = AddressResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<AddressResponse> createAddressAndClient(
            @ApiParam(value = "data of address", required = true)
            @RequestBody AddressCreateRequest request
    ) {
        AddressResponse addressResponse = addressService.createAddressAndClient(request);
        return new ResponseEntity<>(addressResponse, HttpStatus.CREATED);
    }

    //Update
    @PatchMapping(value = "/updateAddress/{id}")
    @ApiOperation(
            value = "Show an address updated.",
            httpMethod = "PATCH",
            response = AddressResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with all information about an address updated",
                    response = AddressResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form"),
            @ApiResponse(code = 404, message = "Address not found"),
    })
    public ResponseEntity<?> updateAddress(
            @ApiParam(value = "id of address to update", required = true, example = "1")
            @PathVariable(name = "id") Long idAddress,
            @ApiParam(value = "data of address", required = true)
            @RequestBody AddressUpdateRequest request
    ) throws NotFoundException, BadRequestException, InternalException {
            return ResponseEntity.ok(addressService.updateAddress(idAddress, request));
    }

    //Delete
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Delete a address by id",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success. Address deleted by id"),
            @ApiResponse(code = 404, message = "Address not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deleteAddress(
            @ApiParam(name = "id", required = true, value = "Address Id", example = "1")
            @PathVariable Long id
    ) throws BadRequestException, NotFoundException, InternalException {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
