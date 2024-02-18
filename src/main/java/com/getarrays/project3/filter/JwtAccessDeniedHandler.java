package com.getarrays.project3.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getarrays.project3.constant.SecurityConstant;
import com.getarrays.project3.domain.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException, ServletException {
        HttpResponse httpResponse = new HttpResponse(
                //HttpStatus is used to obtain information about the HTTP status code
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED,
                HttpStatus.UNAUTHORIZED.getReasonPhrase().toUpperCase(),
                SecurityConstant.ACCESS_DENIED_MESSAGE);
        response.setContentType(APPLICATION_JSON_VALUE); //the response will be in json format
        response.setStatus(HttpStatus.UNAUTHORIZED.value()); //The HTTP status of the response is set to 403 Forbidden
        OutputStream outputStream = response.getOutputStream();  //The response object's output stream is obtained
        ObjectMapper mapper = new ObjectMapper(); //this is used to serialize the HttpResponse object into JSON format.
        mapper.writeValue(outputStream, httpResponse); //  The JSON representation object is written to the output stream, which will be sent back to the client.
        outputStream.flush();
    }
}
