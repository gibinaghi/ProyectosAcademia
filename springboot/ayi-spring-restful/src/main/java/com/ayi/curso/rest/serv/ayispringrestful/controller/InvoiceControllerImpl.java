package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.InvoiceResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.IInvoiceService;
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
@Api(value = "Invoice Api", tags = {"Invoice Service"})
@RequestMapping(value = "/invoice", produces = {MediaType.APPLICATION_JSON_VALUE})
public class InvoiceControllerImpl {
    private IInvoiceService invoiceService;

    //Get all invoice, client, detail cliente and address
    @GetMapping(value = "/getAllInvoice")
    @ApiOperation(
            value = "Retrieves List of all Invoice",
            httpMethod = "GET",
            response = InvoiceResponse[].class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Shows the list of invoices with client, client detail and address",
                    response = InvoiceResponse[].class
            ),
            @ApiResponse(code = 404, message = "Invoice not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<?> getAllInvoice() throws NotFoundException, InternalException {
        List<InvoiceResponse> invoiceReponse = invoiceService.findAllInvoice();

        return ResponseEntity.ok(invoiceReponse);
    }

    //Get by id
    @GetMapping(value = "/invoiceById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Show invoice by Id",
            httpMethod = "GET",
            response = InvoiceResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success. Invoice detail found by ID."),
            @ApiResponse(code = 404, message = "Invoice detail not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<?> findInvoiceById (
            @ApiParam(name = "id", required = true, value = "Invoice detail Id", example = "1")
            @PathVariable("id") Long id
    ) throws BadRequestException, InternalException {

            return ResponseEntity.ok(invoiceService.findInvoiceById(id));

    }

    //Create invoice, client, detail client, address
    @PostMapping(
            value = "/createInvoice",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Retrieves a invoice created",
            httpMethod = "POST",
            response = AddressResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about invoce",
                    response = AddressResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<InvoiceResponse> createInvoice(
            @ApiParam(value = "data of invoice", required = true)
            @RequestBody InvoiceRequest request
    ) {
        InvoiceResponse invoiceResponse = invoiceService.createInvoice(request);
        return new ResponseEntity<>(invoiceResponse, HttpStatus.CREATED);
    }

    //Update
    @PatchMapping(value = "/updateInvoice/{id}")
    @ApiOperation(
            value = "Retrieves an invoice updated",
            httpMethod = "PATCH",
            response = InvoiceResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with all information about an invoice updated",
                    response = InvoiceResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<?> updateInvoice(
            @ApiParam(value = "id of invoice to update", required = true, example = "1")
            @PathVariable(name = "id") Long idInvoice,
            @ApiParam(value = "data of invoice", required = true)
            @RequestBody InvoiceUpdateRequest request
    ) throws NotFoundException, BadRequestException, InternalException {
            return ResponseEntity.ok(invoiceService.updateInvoice(idInvoice, request));
    }

    //Delete
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Delete a invoice by id",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success. Invoice deleted by id"),
            @ApiResponse(code = 404, message = "Invoice not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deleteInvoice(
            @ApiParam(name = "id", required = true, value = "Invoice Id", example = "1")
            @PathVariable Long id
    ){
        invoiceService.deleteInvoice(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
