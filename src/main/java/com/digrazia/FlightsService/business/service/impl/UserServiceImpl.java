package com.digrazia.FlightsService.business.service.impl;

import com.digrazia.FlightsService.business.exception.NotFoundException;
import com.digrazia.FlightsService.business.service.UserService;
import com.digrazia.FlightsService.integration.database.entity.model.UserEntity;
import com.digrazia.FlightsService.integration.database.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    @Override
    public String userDetails(String userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        return userEntity.toString();
    }
}
