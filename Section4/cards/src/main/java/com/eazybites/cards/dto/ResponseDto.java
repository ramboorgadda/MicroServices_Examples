package com.eazybites.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold Successful response information"
)
public class ResponseDto {
    @Schema(description = "Status code in the response")
    private String statusCode;
    @Schema(description = "Status Msg in the response")
    private String statusMsg;
}
