package br.com.cast.tempoapi.api;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.tempoapi.dto.ResultWeatherDTO;
import br.com.cast.tempoapi.services.WeatherBusiness;

@RestController
@RequestMapping(path="/tempo")
public class TempoAPI {

	@Autowired
	private WeatherBusiness weatherBusiness;
	
	@RequestMapping(path="/{cidade}")
	public List<ResultWeatherDTO> buscar(@PathVariable String cidade) throws ParseException{
		return weatherBusiness.BuscarLista(cidade);
	}

}
