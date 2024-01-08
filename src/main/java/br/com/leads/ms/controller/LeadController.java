package br.com.leads.ms.controller;

import br.com.leads.ms.config.SwaggerConfig;
import br.com.leads.ms.domain.request.LeadRequest;
import br.com.leads.ms.domain.response.LeadListResponse;
import br.com.leads.ms.domain.response.LeadResponse;
import br.com.leads.ms.entity.Lead;
import br.com.leads.ms.service.LeadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@Api(tags = {SwaggerConfig.LEAD_CONTROLLER_TAG})
public class LeadController {

    private static final String API_VERSION = "/v1";
    private static final String BASE_PATH = API_VERSION + "/leads";

    @Autowired
    private LeadService leadService;

    @GetMapping(BASE_PATH)
    public LeadListResponse findAll() {
        return leadService.findAll();
    }

    @GetMapping(BASE_PATH + "/{phone}")
    public LeadResponse findByUniqueId(@PathVariable @NotEmpty String phone) {
        return leadService.findByPhoneNumber(phone);
    }

    @ApiOperation(value = "Create a new lead", response = Lead.class)
    @PostMapping(BASE_PATH)
    @ResponseStatus(value = HttpStatus.CREATED)
    public LeadResponse createLead(@RequestBody @Valid LeadRequest leadRequest) {
        return leadService.createLead(leadRequest);
    }

    @DeleteMapping(BASE_PATH + "/{phone}")
    public ResponseEntity<Object> deleteLead(@PathVariable @NotEmpty String phone) {

        leadService.deleteLead(phone);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(BASE_PATH)
    public LeadResponse updateLead(@RequestBody @Valid LeadRequest leadRequest) {
        return leadService.updateLead(leadRequest);
    }
}