package br.com.leads.ms.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LeadRequest", description = "Lead request body")
public record LeadRequest(
    @ApiModelProperty(value = "Lead phone number", example = "5511999999999", required = true)
    String phone,
    @ApiModelProperty(value = "Lead first name", example = "John", required = true)
    String firstname,
    @ApiModelProperty(value = "Lead email", example = "john@example.com")
    String email,
    @ApiModelProperty(value = "Lead last name", example = "Doe", required = true)
    String lastname) {
}
