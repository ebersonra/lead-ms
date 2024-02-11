package br.com.leads.ms.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(value = "AddressDto", description = "Address DTO")
public record AddressDto(
    @ApiModelProperty(value = "Address unique id", example = "123e4567-e89b-12d3-a456-426655440000")
    UUID uniqueId,
    @ApiModelProperty(value = "Address street", example = "Rua dos Bobos", required = true)
    String street,
    @ApiModelProperty(value = "Address number", example = "10", required = true)
    String number,
    @ApiModelProperty(value = "Address complement", example = "Apto 101")
    String complement,
    @ApiModelProperty(value = "Address district", example = "Vila dos Devs", required = true)
    String district,
    @ApiModelProperty(value = "Address city", example = "São Paulo", required = true)
    String city,
    @ApiModelProperty(value = "Address state", example = "SP", required = true)
    String state,
    @ApiModelProperty(value = "Address country", example = "Brazil", required = true)
    String country,
    @ApiModelProperty(value = "Address zip code", example = "00000-000", required = true)
    String zipCode,
    @ApiModelProperty(value = "Address type", example = "1-COMMERCIAL, 2-RESIDENTIAL, 3-BILLING e 4-OTHERS", required = true)
    Long addressTypeValue) {
}
