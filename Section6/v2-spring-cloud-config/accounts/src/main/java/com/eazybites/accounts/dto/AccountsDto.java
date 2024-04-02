package com.eazybites.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Schema(name = "Accounts",
        description = "Schema to hold Account Information")
public class AccountsDto {
    @NotEmpty(message = "AccountNumber can't be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "AccountNumber must be 10digits")
    @Schema(description = "Account Number of the Eazybank", example = "1234321111")
    private Long accountNumber;
    @NotEmpty(message = "Account Type can't be null or empty")
    @Schema(description = "AccountType of the Eazybank",
    example = "Savings")
    private String accountType;
    @NotEmpty(message = "BranchAddress can't be null or empty")
    @Schema(description = "BranchAddress of the Eazybank",example = "123 NewYork")
    private String branchAddress;
}
