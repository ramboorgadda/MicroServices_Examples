package com.eazybites.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Response",
description = "Schema to hold Successful Response Information")
public class ResponseDto {
    @Schema(description = "Response status code of the Account")
    private String statusCode;
    @Schema(description = "Response status Message of the Account")
    private String statusMsg;


}
