package br.com.leads.ms.domain.response;

import br.com.leads.ms.domain.dto.LeadDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "LeadListResponse", description = "Lead response body")
public record LeadListResponse(
    @ApiModelProperty(value = "leadDtoList")
    List<LeadDto> leadDtoList) {
}
