package com.digrazia.FlightsService.api.controller;

import com.digrazia.FlightsService.api.UserAPI;
import com.digrazia.FlightsService.business.mapper.dto.UserDTOMapper;
import com.digrazia.FlightsService.business.model.domain.UserDomain;
import com.digrazia.FlightsService.business.model.dto.UserDTO;
import com.digrazia.FlightsService.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController implements UserAPI {

    private final UserService userService;
    private final UserDTOMapper userDTOMapper;

    @Autowired
    public UserController(UserService userService, UserDTOMapper userDTOMapper) {
        this.userService = userService;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    @GetMapping("/details")
    public UserDTO userDetails() {
        String userId = extractUserIdFromToken();
        UserDomain userDomain = userService.userDetails(userId);
        return userDTOMapper.froUserDomainToUserDTO(userDomain);
    }

    private String extractUserIdFromToken(){
        JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String databaseId = (String) token.getDetails();
        return databaseId;
    }


}


