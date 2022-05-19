package com.api.wealthwa.config;

import com.api.wealthwa.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author rohit
 * @Date 17/05/22
 **/
@Component("accessDeniedHandler")
public class WealthAccessDeniedHandler implements AccessDeniedHandler {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        Response<String> response = new Response<String>(HttpStatus.FORBIDDEN.value(),
                "Access denied for resource :" + httpServletRequest.getRequestURL(), null);
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write(OBJECT_MAPPER.writeValueAsString(response));
            writer.flush();
        }

    }
}
