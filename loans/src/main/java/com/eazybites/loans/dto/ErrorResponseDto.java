package com.eazybites.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Error Response",description = "Schema holds error response")

public class ErrorResponseDto {

    private String apiPath;
    private HttpStatus errorcode;
    private String errorMessage;
    private LocalDateTime errorTime;
}
