package com.timeconverter.problema_2.service;

import com.timeconverter.problema_2.dto.HourTimeZoneDTO;

public interface ConverterService {
	public String convertTimeToUTC(HourTimeZoneDTO hourTimeZoneDTO);
}
