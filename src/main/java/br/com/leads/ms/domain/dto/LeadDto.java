package br.com.leads.ms.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(value = "LeadDto", description = "Lead DTO")
public record LeadDto(
    @ApiModelProperty(value = "Lead unique id", example = "123e4567-e89b-12d3-a456-426655440000")
    UUID uniqueId,
    @ApiModelProperty(value = "Lead firstname", example = "John")
    String firstname,
    @ApiModelProperty(value = "Lead email", example = "john@email")
    String email,
    @ApiModelProperty(value = "Lead phone", example = "123456789")
    String phone,
    @ApiModelProperty(value = "Lead lastname", example = "Doe")
    String lastname,
    @ApiModelProperty(value = "Lead type", example = "1-CLIENT, 2-PROSPECT, 3-PARTNER, 4-SUPPLIER e 5-OTHERS")
    Long leadTypeValue){
}
