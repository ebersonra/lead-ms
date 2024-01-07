package br.com.leads.ms.domain.response;

import br.com.leads.ms.domain.dto.LeadDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LeadResponse", description = "Lead response body")
public record LeadResponse(
    @ApiModelProperty(value = "leadDto")
    LeadDto leadDto) {
}
