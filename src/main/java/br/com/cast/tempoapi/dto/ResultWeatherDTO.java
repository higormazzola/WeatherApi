package br.com.cast.tempoapi.dto;

import java.util.Date;

public class ResultWeatherDTO {
	
	private Integer id;
	private String cidade;
	private String temMin;
	private String temMax;
	private String pressure;
	private String humidity;
	private String main;
	private String icon;
	private String velocidadeVento;
	private Date dt;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getTemMin() {
		return temMin;
	}
	
	public void setTemMin(String temMin) {
		this.temMin = temMin;
	}
	
	public String getTemMax() {
		return temMax;
	}
	
	public void setTemMax(String temMax) {
		this.temMax = temMax;
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
	
	public String getMain() {
		return main;
	}
	
	public void setMain(String main) {
		this.main = main;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getVelocidadeVento() {
		return velocidadeVento;
	}
	
	public void setVelocidadeVento(String velocidadeVento) {
		this.velocidadeVento = velocidadeVento;
	}
	
	public Date getDt() {
		return dt;
	}
	
	public void setDt(Date dt) {
		this.dt = dt;
	}
	
}
