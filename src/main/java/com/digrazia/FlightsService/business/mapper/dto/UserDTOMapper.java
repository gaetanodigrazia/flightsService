package com.digrazia.FlightsService.business.mapper.dto;

import com.digrazia.FlightsService.business.model.domain.UserDomain;
import com.digrazia.FlightsService.business.model.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
    UserDTO froUserDomainToUserDTO(UserDomain userDomain);
}
