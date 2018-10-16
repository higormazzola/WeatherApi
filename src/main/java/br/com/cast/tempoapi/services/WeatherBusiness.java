package br.com.cast.tempoapi.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.tempoapi.client.TempoClient;
import br.com.cast.tempoapi.dto.ResultWeatherDTO;
import br.com.cast.tempoapi.dto.WeatherDTO;
import br.com.cast.tempoapi.dto.WeatherDataDTO;
import br.com.cast.tempoapi.dto.WeatherDescriptionDTO;
import br.com.cast.tempoapi.entidades.Weather;
import br.com.cast.tempoapi.repository.WeatherDao;

@Service
public class WeatherBusiness {
	
	@Autowired
	WeatherDao weatherDao;
	
	@Autowired
	private TempoClient tempoClient;
	
	@Transactional
	public List<ResultWeatherDTO> BuscarLista(String cidade) throws ParseException {
		
		List<ResultWeatherDTO> resultados = buscarPorCidade(cidade);
		
		if(resultados.size() < 5) {
			remover(cidade.toLowerCase());
			WeatherDTO weatherDTO = tempoClient.fetchEvents(cidade);
			weatherDTO.setCidade(cidade.toLowerCase());
			inserir(weatherDTO);
			
			resultados = buscarPorCidade(cidade);
		}
		
		weatherDao.close();
		return resultados;
	}

	
	public void inserir(WeatherDTO weatherDTO) throws ParseException {
		
		Map<String, Weather> map = new HashMap<>();
		
		for(WeatherDataDTO wdDto : weatherDTO.getList()) {
			
			String data = wdDto.getData().substring(0, 10);

			if(map.containsKey(data)) {
				continue;
			}
			
			Weather weather = new Weather();
			weather.setCidade(weatherDTO.getCidade().toLowerCase());
			weather.setTemMin(wdDto.getMain().getTempMin());
			weather.setTemMax(wdDto.getMain().getTempMax());
			weather.setPressure(wdDto.getMain().getPressure());
			weather.setHumidity(wdDto.getMain().getHumidity());
			
			for(WeatherDescriptionDTO wDescripiton : wdDto.getWeather()) {
				weather.setMain(wDescripiton.getMain());
				weather.setIcon(wDescripiton.getIcon());
			}
			
			weather.setVelocidadeVento(wdDto.getWind().getSpeed());
			weather.setData(convertStringFromDate(wdDto.getData()));
			
			map.put(data, weather);
			weatherDao.inserir(weather);
		}	
		
		weatherDao.close();
	}
	
	public List<ResultWeatherDTO> buscarPorCidade(String cidade){
		
		List<Weather> weathers = weatherDao.buscaPorCidade(cidade.toLowerCase());
		List<ResultWeatherDTO> resultados = new ArrayList<>();
		
		if(weathers != null && weathers.size() >= 1) {
			for(Weather weather : weathers) {
				ResultWeatherDTO resultWeatherDTO = new ResultWeatherDTO();
				resultWeatherDTO.setCidade(weather.getCidade());
				resultWeatherDTO.setDt(weather.getData());
				resultWeatherDTO.setHumidity(weather.getHumidity());
				resultWeatherDTO.setIcon(weather.getIcon());
				resultWeatherDTO.setId(weather.getId());
				resultWeatherDTO.setMain(weather.getMain());
				resultWeatherDTO.setPressure(weather.getPressure());
				resultWeatherDTO.setTemMax(weather.getTemMax());
				resultWeatherDTO.setTemMin(weather.getTemMin());
				resultWeatherDTO.setVelocidadeVento(weather.getVelocidadeVento());
				
				resultados.add(resultWeatherDTO);
			}
		}
		
		weatherDao.close();
		
		return resultados;
	}
	
	public void remover(String cidade) {
		weatherDao.remover(cidade);
		weatherDao.close();
	}
	
	public Date convertStringFromDate(String data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formato.parse(data);
		
		return date;
	}
	
}
