package com.digrazia.FlightsService.business.service.impl;

import com.digrazia.FlightsService.business.exception.NotFoundException;
import com.digrazia.FlightsService.business.mapper.domain.UserDomainMapper;
import com.digrazia.FlightsService.business.model.domain.UserDomain;
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
    private final UserDomainMapper userDomainMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDomainMapper userDomainMapper){
        this.userRepository = userRepository;
        this.userDomainMapper = userDomainMapper;
    }

    @Override
    public UserDomain userDetails(String userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        return userDomainMapper.fromUserEntityToUserDomain(userEntity);
    }
}
