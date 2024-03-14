package com.eazybites.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema to hold Error response information"
)
public class ErrorResponseDto {
    @Schema(description = "API path Invoked by Client")
    private String apiPath;
    @Schema(description = "error code representing error happened")
    private HttpStatus errorCode;
    @Schema(description = "error message representing error happened")
    private String errorMessage;
    @Schema(description = "error occured time when error happened")
    private LocalDateTime errorTime;

}
