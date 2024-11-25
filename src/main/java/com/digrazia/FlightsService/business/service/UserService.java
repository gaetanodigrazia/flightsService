package com.digrazia.FlightsService.business.service;

import com.digrazia.FlightsService.business.model.domain.BookingDomain;
import com.digrazia.FlightsService.business.model.domain.UserDomain;

public interface UserService {
    UserDomain userDetails(String userId);
}
