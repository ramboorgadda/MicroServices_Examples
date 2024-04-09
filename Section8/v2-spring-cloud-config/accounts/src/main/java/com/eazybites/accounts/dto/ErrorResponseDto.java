package com.eazybites.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data@AllArgsConstructor
@Schema(name ="ErrorResponse",
description = "Schema to hold Error response Information")
public class ErrorResponseDto {

    @Schema(description = "API path Invoked By Client")
    private String apiPath;

    @Schema(description = "Error code representing the error happened")
    private HttpStatus errorCode;

    @Schema(description = "Error Message representing the error happened")
    private String errorMsg;

    @Schema(description = "Time when the  error happened")
    private LocalDateTime errorTime;
}
