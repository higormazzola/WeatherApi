package br.com.cast.tempoapi.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="previsao", schema="api")
public class Weather {
	
	@Id
	@SequenceGenerator(name="seqGenWeather", sequenceName="api.previsao_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqGenWeather")
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
	
	public Date getData() {
		return dt;
	}
	
	public void setData(Date data) {
		this.dt = data;
	}

}
