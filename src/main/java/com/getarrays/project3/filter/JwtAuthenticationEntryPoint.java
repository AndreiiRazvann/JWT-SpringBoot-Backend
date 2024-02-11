package com.getarrays.project3.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getarrays.project3.constant.SecurityConstant;
import com.getarrays.project3.domain.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class JwtAuthenticationEntryPoint extends Http403ForbiddenEntryPoint { //whenever a user fails to provide auth and try to access application, 403 gets fired. Uses the custom commence method
    //Check the HttpResponse class
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        HttpResponse httpResponse = new HttpResponse(
                //HttpStatus is used to obtain information about the HTTP status code
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN,
                HttpStatus.FORBIDDEN.getReasonPhrase().toUpperCase(),
                SecurityConstant.FORBIDDEN_MESSAGE);
        response.setContentType(APPLICATION_JSON_VALUE); //the response will be in json format
        response.setStatus(HttpStatus.FORBIDDEN.value()); //The HTTP status of the response is set to 403 Forbidden
        OutputStream outputStream = response.getOutputStream();  //The response object's output stream is obtained
        ObjectMapper mapper = new ObjectMapper(); //this is used to serialize the HttpResponse object into JSON format.
        mapper.writeValue(outputStream, httpResponse); //  The JSON representation object is written to the output stream, which will be sent back to the client.
        outputStream.flush();
    }

}
