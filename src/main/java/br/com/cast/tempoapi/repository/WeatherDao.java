package br.com.cast.tempoapi.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.tempoapi.entidades.Weather;

@Repository
public class WeatherDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Weather weather) {
		em.persist(weather);
	}
	
	@SuppressWarnings("unchecked")
	public List<Weather> buscaPorCidade(String cidade){
		
		Date date = new Date();
		
		Query query = em.createQuery("from " + Weather.class.getName() + " where cidade = :cidade and dt >= :data");
		query.setParameter("cidade", cidade);
		query.setParameter("data", date);
		return query.getResultList();
	}
	
	public void remover(String cidade) {
		Query query = em.createQuery("delete from " + Weather.class.getName() + " where cidade = :cidade");
		query.setParameter("cidade", cidade);
		query.executeUpdate();
	}
	
	public void close() {
		em.close();
	}
	
}
