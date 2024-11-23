package com.digrazia.FlightsService.utils;

import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedAirportDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AirportAssert {

    public static void fromAirportDomainToAirportDTOAssertions(AirportDTO expected, AirportDTO actual) {
        assertEquals(expected.getAirportId(), actual.getAirportId());
        assertEquals(expected.getIata(), actual.getIata());
        assertEquals(expected.getIcao(), actual.getIcao());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getCountry(), actual.getCountry());
        assertEquals(expected.getRegion(), actual.getRegion());
        assertEquals(expected.getElevationFt(), actual.getElevationFt());
        assertTrue(expected.getLatitude() == actual.getLatitude());
        assertTrue(expected.getLongitude() == actual.getLongitude());
        assertEquals(expected.getTimezone(), actual.getTimezone());
    }
    public static void fromAirportDomainToReducedAirportDTOAssertions(AirportDTO expected, AirportDTO actual) {
        assertNull(expected.getAirportId());
        assertNull(expected.getIcao());
        assertNull(expected.getIata());
        assertTrue(expected.getElevationFt() == 0);
        assertTrue(expected.getElevationFt() == 0.0);
        assertTrue(expected.getElevationFt() == 0.0);
        assertNull(expected.getTimezone());

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getCountry(), actual.getCountry());
        assertEquals(expected.getRegion(), actual.getRegion());
    }
}
