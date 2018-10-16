package br.com.cast.tempoapi.dto;

import java.util.List;

public class WeatherDTO {
	
	private List<WeatherDataDTO> list;
	private String cidade;
	
	public List<WeatherDataDTO> getList() {
		return list;
	}

	public void setList(List<WeatherDataDTO> list) {
		this.list = list;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
