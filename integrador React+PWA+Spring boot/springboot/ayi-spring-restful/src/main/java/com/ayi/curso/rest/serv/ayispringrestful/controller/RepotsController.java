package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.ReportsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Report Api", tags = {"Report Service"})
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@RestController
public class RepotsController {

    private ReportsService reportService;


    // Get all
    @GetMapping("/reports")
    @ApiOperation(
            value = "List all report lendings",
            httpMethod = "GET",
            response = LendingDTOResponse[].class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Shows the list of lendings",
                    response = LendingDTOResponse[].class
            ),
            @ApiResponse(code = 404, message = "Report not found"),
    })
    public ResponseEntity<?> getAllReports() throws NotFoundException, InternalException
    {
        List<LendingDTOResponse> lendResponse = reportService.getAllReports();
        return ResponseEntity.ok(lendResponse );
    }


    //Export excel
    @GetMapping("/downloadReports")
    public ResponseEntity<Resource> getFile() {
        String filename = "reportes.xlsx";
        InputStreamResource file = new InputStreamResource(reportService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

}
