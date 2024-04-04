package com.eazybites.cards.controller;

import com.eazybites.cards.constants.CardsConstants;
import com.eazybites.cards.dto.CardsContactInfoDto;
import com.eazybites.cards.dto.CardsDto;
import com.eazybites.cards.dto.ErrorResponseDto;
import com.eazybites.cards.dto.ResponseDto;
import com.eazybites.cards.service.ICardsService;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated

@Tag(
        name ="Cards CRUD Operations",
        description = "cards CRUD Operations like Create,Fetch,Update and Delete operations"
)
public class CardsController {

private final ICardsService iCardsService;


    public CardsController(ICardsService iCardsService) {
        this.iCardsService = iCardsService;
    }
//    @Value("${build.version}")
//private String buildVersion;
@Autowired
private Environment environment;
@Autowired
private CardsContactInfoDto cardsContactInfoDto;

    @Operation(summary = "Rest API for Create",
description = "Rest API for Creating Card in EazyBank")
@ApiResponses({
        @ApiResponse(responseCode = "201",
        description = "HTTP Status Created"),
@ApiResponse(responseCode = "500",
description = "HTTP Status Internal Server Error",
        content = @Content(
                schema = @Schema(implementation = ErrorResponseDto.class)
        ))
})
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam @Valid  @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number must be 10 digits")
                                                      String mobileNumber){
      iCardsService.createCard(mobileNumber);
       return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(CardsConstants.STATUS_201,CardsConstants.MESSAGE_201));
    }

    @Operation(summary = "Rest API for Fetch",
            description = "Rest API for Fetching Card in EazyBank")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "HTTP Status Created"),
            @ApiResponse(responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    ))
    })
    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam @Valid  @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number must be 10 digits")
                                                         String mobileNumber
    ){
        CardsDto cardsDto=iCardsService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }

    @Operation(summary = "Rest API for Update",
            description = "Rest API for Updating Card in EazyBank")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "HTTP Status Created"),
            @ApiResponse(responseCode = "417",
                    description = "Expectation Failed"),
            @ApiResponse(responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    ))
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCardDetails(@Valid @RequestBody CardsDto cardsDto){
        boolean isUpdated=iCardsService.updateCard(cardsDto);
        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(CardsConstants.STATUS_417,CardsConstants.MESSAGE_417_UPDATE));
        }
    }
    @Operation(summary = "Rest API for Delete",
            description = "Rest API for Deleting Card in EazyBank")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "HTTP Status Created"),
            @ApiResponse(responseCode = "417",
                    description = "Expectation Failed"),
            @ApiResponse(responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    ))
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCardDetails(@RequestParam
                                                             @Valid  @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number must be 10 digits") String mobileNumber){
        boolean isUpdated=iCardsService.deleteCard(mobileNumber);
        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(CardsConstants.STATUS_417,CardsConstants.MESSAGE_417_UPDATE));
        }
    }

//    @Operation(summary = "Rest API for GetBuildInfo",
//            description = "Rest Get API to getBuildInfo of Cards MicroService")
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
            description = "Rest Get API to getJavaVersion of Cards MicroService")
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
    @Operation(summary = "Rest API for GetCardsContactInfo",
            description = "Rest Get API to getCardContact of cards MicroService")
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
    public ResponseEntity<CardsContactInfoDto> getContactInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(cardsContactInfoDto);
    }
}
