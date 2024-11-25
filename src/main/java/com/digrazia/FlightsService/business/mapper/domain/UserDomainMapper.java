package com.digrazia.FlightsService.business.mapper.domain;

import com.digrazia.FlightsService.business.model.domain.UserDomain;
import com.digrazia.FlightsService.integration.database.entity.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDomainMapper {
       UserDomain fromUserEntityToUserDomain(UserEntity userEntity);
}
