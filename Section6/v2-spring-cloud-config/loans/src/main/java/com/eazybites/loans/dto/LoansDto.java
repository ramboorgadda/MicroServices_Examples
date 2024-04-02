package com.eazybites.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoansDto {
    @NotEmpty(message = "Mobile number can't be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNumber;
    @Pattern(regexp = "(^$|[0-9]{12})",message = "Loan number must be 12 digits")
    @NotEmpty(message = "Loan Number can't be null or empty")
    private String loanNumber;
    @NotEmpty(message = "Loan type can't be null or empty")
    private String loanType;
    @Positive(message = "Total loan should be greater than zero")
    private int totalLoan;
    @PositiveOrZero(message = "Total amount paid should be equal or greater than zero")
    private int amountPaid;
    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private int outstandingAmount;

}
