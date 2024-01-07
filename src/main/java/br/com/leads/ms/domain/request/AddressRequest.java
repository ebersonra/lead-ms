package br.com.leads.ms.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AddressRequest", description = "Address request body")
public record AddressRequest(

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
    String zipCode) {
}
