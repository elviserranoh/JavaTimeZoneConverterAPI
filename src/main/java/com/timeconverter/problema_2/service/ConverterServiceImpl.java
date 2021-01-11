package com.timeconverter.problema_2.service;

import org.springframework.stereotype.Service;

import com.timeconverter.problema_2.dto.HourTimeZoneDTO;

@Service
public class ConverterServiceImpl implements ConverterService {
	
	private final static Integer TWENTY_FOUR_HOURS = 24;
	private final static Integer SIXTY_MINUTES = 60;

	@Override
	public String convertTimeToUTC(HourTimeZoneDTO hourTimeZoneDTO) {
		String time = hourTimeZoneDTO.getTime();
		String timezone = hourTimeZoneDTO.getTimezone();

		String[] timeSplit = time.split(":");
		String[] timezoneSplit = timezone.split(":");

		int minutes = 0;
		int seconds = 0;
		int hour = 0;

		if (timeSplit.length == 3) {
			seconds = Integer.parseInt(timeSplit[2]);
		}

		if (timezoneSplit.length > 1) {
			minutes = Integer.parseInt(timeSplit[1]) + Integer.parseInt(timezoneSplit[1]);
		} else {
			minutes = Integer.parseInt(timeSplit[1]);
		}

		if (minutes > SIXTY_MINUTES) {
			minutes -= SIXTY_MINUTES;
			hour += 1;
		}

		hour += Integer.parseInt(timeSplit[0]) + (Integer.parseInt(timezoneSplit[0]) * -1);

		if (hour > TWENTY_FOUR_HOURS) {
			hour -= TWENTY_FOUR_HOURS;
		}

		String timeUTC = String.format("%d:%d:%d", hour, minutes, seconds);

		return timeUTC;
	}

}
