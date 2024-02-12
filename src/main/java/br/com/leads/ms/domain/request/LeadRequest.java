package br.com.leads.ms.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "LeadRequest", description = "Lead request body")
public record LeadRequest(
    @ApiModelProperty(value = "Lead phone number", example = "5511999999999", required = true)
    @NotEmpty(message = "{error.field.cannot.be.empty}")
    String phone,
    @ApiModelProperty(value = "Lead first name", example = "John", required = true)
    @NotEmpty(message = "{error.field.cannot.be.empty}")
    String firstname,
    @ApiModelProperty(value = "Lead email", example = "john@example.com")
    String email,
    @ApiModelProperty(value = "Lead last name", example = "Doe", required = true)
    @NotEmpty(message = "{error.field.cannot.be.empty}")
    String lastname,
    @NotNull(message = "{error.field.is.required}")
    @ApiModelProperty(value = "Lead type", example = "1-CLIENT, 2-PROSPECT, 3-PARTNER, 4-SUPPLIER e 5-OTHERS", required = true)
    Long leadTypeValue) {
}
