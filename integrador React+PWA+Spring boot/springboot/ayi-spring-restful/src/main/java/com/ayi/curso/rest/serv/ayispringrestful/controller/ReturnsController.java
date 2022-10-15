package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.service.ReturnService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Return Api", tags = {"Return Service"})
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@RestController
public class ReturnsController {

    private ReturnService returnService;

    // Delete for name user and title book
    @DeleteMapping("/return/{id}")
    public String deleteLendingById(@PathVariable("id") Long id)
    {
        try {
            returnService.deleteLendingById(id);
            return "Deleted Successfully";
        }catch(Exception e){
            return "ERROR: No deleted";
        }
    }

}
