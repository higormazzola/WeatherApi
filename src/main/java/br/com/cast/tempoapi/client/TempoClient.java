package br.com.cast.tempoapi.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.tempoapi.dto.WeatherDTO;

@Component
public class TempoClient {
	
	private final RestTemplate restTemplate;
	
	private static final String EVENTO_TEMPO_URL = "http://api.openweathermap.org/data/2.5/forecast?q={cidade},br&appid=4d13ccfe03f4be53488ee7a0f3e49c57&units=metric&lang=pt";
	
	
	public TempoClient(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	public WeatherDTO fetchEvents(String cidade) {
		return this.restTemplate.getForObject(EVENTO_TEMPO_URL, WeatherDTO.class, cidade);
	}
	
}
