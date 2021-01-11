package com.timeconverter.problema_2.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class HourTimeZoneDTO {
	@NotEmpty
	private String time;
	@NotEmpty
	private String timezone;

}
