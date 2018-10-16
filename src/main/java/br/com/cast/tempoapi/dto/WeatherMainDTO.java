package br.com.cast.tempoapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherMainDTO {
	
	@JsonProperty("temp_min")
	private String tempMin;
	
	@JsonProperty("temp_max")
	private String tempMax;
	
	private String pressure;
	private String humidity;
	
	public String getTempMin() {
		return tempMin;
	}
	
	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}
	
	public String getTempMax() {
		return tempMax;
	}
	
	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}
	
	public String getPressure() {
		return pressure;
	}
	
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	
	public String getHumidity() {
		return humidity;
	}
	
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	
}
