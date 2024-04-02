package com.eazybites.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Schema(name = "Customer",
        description = "Schema to hold Customer & Account Information omf EazyBank")
public class CustomerDto {
    @NotEmpty(message = "Name can't be null or empty")
    @Size(min = 5,max = 30,message = "Lenght of the customer name should be between 5 and 30")
    @Schema(description = "Name of the customer in EazyBank",
    example = "Eazy Bank1")
    private String name;
    @NotEmpty(message = "email can't be null or empty")
    @Email(message = "email Address should be valid value")
    @Schema(description = "Email of the Customer in EazyBank",
    example = "abc@eazyBank")
    private String email;
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10digits")
    @Schema(name = "Mobile Number of the Customer in Eazy Bank")
    private String mobileNumber;
    @Schema(description = "Reference to Account Schema of a Customer")
    private AccountsDto accountsDto;
}
