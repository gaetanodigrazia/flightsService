package com.digrazia.FlightsService.api.controller;

import com.digrazia.FlightsService.api.FlightsAPI;
import com.digrazia.FlightsService.api.UserAPI;
import com.digrazia.FlightsService.business.model.dto.BookingOutputDTO;
import com.digrazia.FlightsService.business.service.FlightService;
import com.digrazia.FlightsService.business.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController implements UserAPI {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/details")
    public ResponseEntity<String> userDetails() {
        String user = userService.userDetails(extractUserIdFromToken());
        return ResponseEntity.ok(user);
    }

    private String extractUserIdFromToken(){
        JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String databaseId = (String) token.getDetails();
        return databaseId;
    }


}


