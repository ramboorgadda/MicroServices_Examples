package com.eazybites.loans.controller;

import com.eazybites.loans.constants.LoanConstants;
import com.eazybites.loans.dto.ErrorResponseDto;
import com.eazybites.loans.dto.LoansContactInfoDto;
import com.eazybites.loans.dto.LoansDto;
import com.eazybites.loans.dto.ResponseDto;
import com.eazybites.loans.service.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "CRUD REST APIs for Loans in EazyBank",
        description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE loan details"
)
@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})

@Valid
public class LoansController {

private final ILoansService iLoansService;
    public LoansController(ILoansService iLoansService) {
        this.iLoansService = iLoansService;
    }
//@Value("${build.version}")
//private String buildVersion;
@Autowired
private Environment environment;
@Autowired
private LoansContactInfoDto loansContactInfoDto;



    @Operation(summary = "Create Loan REST API",
description = "REST API to create new loan inside EazyBank")
@ApiResponses({
        @ApiResponse(  responseCode = "201",
                description = "HTTP Status CREATED" ),
        @ApiResponse(
                responseCode = "500",
                description = "HTTP Status Internal Server Error",
                content = @Content(
                        schema = @Schema(implementation = ErrorResponseDto.class)
                )
        )
})
@PostMapping("/create")
public ResponseEntity<ResponseDto> createLoan(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number must be 10 digits") String mobileNumber){
    iLoansService.createLoan(mobileNumber);
    return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(LoanConstants.STATUS_201,LoanConstants.MESSAGE_201));

}
    @Operation(
            summary = "Fetch Loan Details REST API",
            description = "REST API to Fetch Loan details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(  responseCode = "201",
                    description = "HTTP Status Ok" ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoan(@RequestParam
                                                  @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number must be 10 digits")
                                                  String mobileNumber){
       LoansDto loansDto= iLoansService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loansDto);

    }
    @Operation(
            summary = "update Loan Details REST API",
            description = "REST API to update Loan details based on a loan number"
    )
    @ApiResponses({
            @ApiResponse(  responseCode = "201",
                    description = "HTTP Status Ok" ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoansDto loansDto){
          boolean isUpdated = iLoansService.updateLoan(loansDto);
          if(isUpdated) {
              return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoanConstants.STATUS_200,LoanConstants.MESSAGE_200));
          }
          else{
              return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(LoanConstants.STATUS_417,LoanConstants.MESSAGE_417_UPDATE));
          }
    }
    @Operation(
            summary = "Delete Loan Details REST API",
            description = "REST API to delete Loan details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam  @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile must be 10 digits") String mobileNumber){
        boolean isDeleted = iLoansService.deleteLoan(mobileNumber);
        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoanConstants.STATUS_200,LoanConstants.MESSAGE_200));
        }
        else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(LoanConstants.STATUS_417,LoanConstants.MESSAGE_417_DELETE));
        }
    }
//    @Operation(summary = "Rest API for GetBuildInfo",
//            description = "Rest Get API to getBuildInfo of Loans MicroService")
//    @ApiResponses({
//            @ApiResponse(
//                    responseCode = "201",
//                    description = "HTTP Status CREATED"
//            ),
//            @ApiResponse(
//                    responseCode = "500",
//                    description = "HTTP Status Internal Server Error",
//                    content = @Content(
//                            schema = @Schema(implementation = ErrorResponseDto.class)
//                    )
//            )
//    }
//    )
//    @GetMapping("/build-info")
//    public ResponseEntity<String> getBuildInfo(){
//
//        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
//    }
    @Operation(summary = "Rest API for GetJavaVersion",
            description = "Rest Get API to getJavaVersion of Loans MicroService")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion(){
        return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("JAVA_HOME"));
    }
    @Operation(summary = "Rest API for GetLoansContactInfo",
            description = "Rest Get API to getLoansContact of cards MicroService")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/contact-info")
    public ResponseEntity<LoansContactInfoDto> getContactInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(loansContactInfoDto);
    }
}
