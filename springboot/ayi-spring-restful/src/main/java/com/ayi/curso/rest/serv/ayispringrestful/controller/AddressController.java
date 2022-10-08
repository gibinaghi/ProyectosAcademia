package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressWithoutClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.service.IAddressService;
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
@Api(value = "Address Api", tags = {"Address Service"})
@RequestMapping(value = "/address", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AddressController {

    private IAddressService addressService;

    //Get all
    @GetMapping(value = "/getAllAddress")
    @ApiOperation(
            value = "Retrieves List of all address",
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
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<?> findAllAddress(){

        List<AddressResponse> addressReponse = null;
        Map<String, Object> response = new HashMap<>();

        try {
            addressReponse  = addressService.findAllAddress();
        } catch (ReadAccessException e) {
            response.put("Mensaje", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }catch (Exception ex) {
            response.put("Código de error", 400);
            response.put("Mensaje", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(addressReponse);
    }

    //Get by id
    @GetMapping(value = "/addressById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "SHow address by Id",
            httpMethod = "GET",
            response = AddressResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success. Address found by ID."),
            @ApiResponse(code = 404, message = "Address not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<?> findAddressById(
            @ApiParam(name = "id", required = true, value = "Address Id", example = "1")
            @PathVariable("id") Long id){

        Map<String, Object> response = new HashMap<>();

        try {
            return ResponseEntity.ok(addressService.findAddressById(id));
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

    //Create address and set client
    @PostMapping(
            value = "/createAddress",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Retrieves a address created",
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
            @RequestBody AddressWithoutClientRequest request, Long idClient
    ) {
        AddressResponse addressResponse = addressService.createAddress(request, idClient);
        return new ResponseEntity<>(addressResponse, HttpStatus.CREATED);
    }

    //Create address and client
    @PostMapping(
            value = "/createAddressAndClient",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Retrieves a address created",
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
            @RequestBody AddressRequest request
    ) {
        AddressResponse addressResponse = addressService.createAddressAndClient(request);
        return new ResponseEntity<>(addressResponse, HttpStatus.CREATED);
    }

    //Update
    @PatchMapping(value = "/updateAddress/{id}")
    @ApiOperation(
            value = "Retrieves an address updated",
            httpMethod = "PATCH",
            response = AddressResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with all information about an address updated",
                    response = AddressResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<?> updateAddress(
            @ApiParam(value = "id of address to update", required = true, example = "1")
            @PathVariable(name = "id") Long idAddress,
            @ApiParam(value = "data of address", required = true)
            @RequestBody AddressUpdateRequest request
    ) {
        Map<String, Object> response = new HashMap<>();

        try {
            return ResponseEntity.ok(addressService.updateAddress(idAddress, request));
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
    ){
        addressService.deleteAddress(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
