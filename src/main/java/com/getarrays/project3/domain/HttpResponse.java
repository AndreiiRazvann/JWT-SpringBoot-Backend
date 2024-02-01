package com.getarrays.project3.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class HttpResponse {
    private int httpStatusCode; //ex:200, 201, 500, 400
    private HttpStatus httpStatus; //this contains the code error, the httpStatus
    private String reason; //this contains the code MESSAGE error, aka the reason
    private String message; //my message

}
