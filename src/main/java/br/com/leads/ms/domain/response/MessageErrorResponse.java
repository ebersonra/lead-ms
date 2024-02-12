package br.com.leads.ms.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "MessageErrorResponse", description = "Message error response body")
public record MessageErrorResponse(
        @ApiModelProperty(value = "messages")
        List<String> messages,
        @ApiModelProperty(value = "code")
        Integer code) {
}
