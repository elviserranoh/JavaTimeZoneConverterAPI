package com.timeconverter.problema_2.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timeconverter.problema_2.dto.HourTimeZoneDTO;
import com.timeconverter.problema_2.service.ConverterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConverterController {

	private final ConverterService converterService;

	@PostMapping
	public ResponseEntity<?> converter(@Valid @RequestBody HourTimeZoneDTO hourTimeZoneDTO, BindingResult result) {

		Map<String, Object> response = new HashMap<>();
		Map<String, Object> body = new HashMap<>();
		List<String> errors = new ArrayList<>();
		
		if (result.hasErrors()) {
			errors = result.getFieldErrors().stream()
					.map(error -> String.format("The field %s: %s", error.getField(), error.getDefaultMessage()))
					.collect(Collectors.toList());
			
			body.put("status", false);
			body.put("errors", errors);

			response.put("response", body);
			
			return ResponseEntity.ok(response);
		}

		try {
			String timeUTC = converterService.convertTimeToUTC(hourTimeZoneDTO);

			body.put("status", true);
			body.put("time", timeUTC);
			body.put("timezone", "utc");

			response.put("response", body);
		} catch(Exception e) {
			errors.add("Time and TimeZone or incorrect, please try again");
			body.put("status", false);
			body.put("errors", errors);

			response.put("response", body);
		}

		return ResponseEntity.ok(response);
	}

}
