package br.com.cast.tempoapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataDTO {
	
	private WeatherMainDTO main;
	private List<WeatherDescriptionDTO> weather;
	private WeatherWindDTO wind;
	
	@JsonProperty("dt_txt")
	private String data;

	public WeatherMainDTO getMain() {
		return main;
	}

	public void setMain(WeatherMainDTO main) {
		this.main = main;
	}

	public List<WeatherDescriptionDTO> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherDescriptionDTO> weather) {
		this.weather = weather;
	}

	public WeatherWindDTO getWind() {
		return wind;
	}

	public void setWind(WeatherWindDTO wind) {
		this.wind = wind;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	

}
