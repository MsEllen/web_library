package sk.hupcejova.tajj.films.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * DTO pre Film
 *
 */

public class Film {
	
	private Long id;
	private String name;
	private Date year;
	private State state;
	private Genre genre;
	
	/**
	 * 
	 * Struktura Metody pre ziskanie identifikatora filmu
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * Struktura Metody pre nastavenie identifikatora filmu
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * Struktura Metody pre ziskanie nazvu filmu
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * Struktura Metody pre nastavenie nazvu filmu
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * Struktura Metody pre ziskanie datumu filmu
	 */
	public Date getYear() {
		return year;
	}
	
	/**
	 * 
	 * Struktura Metody pre nastavenie datumu filmu
	 */
	public void setYear(Date year) {
		this.year = year;
	}
	
	/**
	 * 
	 * Struktura Metody pre ziskanie stavu filmu
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * 
	 * Struktura Metody pre nastavenie stavu filmu
	 */
	public void setState(State state) {
		this.state = state;
	}
	
	/**
	 * 
	 * Struktura Metody pre ziskanie zanru filmu
	 */
	public Genre getGenre() {
		return genre;
	}
	
	/**
	 * 
	 * Struktura Metody pre nastavenie zanru filmu
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	/**
	 * 
	 * Struktura Metody pre ziskanie identifikatora zanru filmu
	 */
	public Long getGenreId(){
		return genre.getId();
	}
	
	/**
	 * 
	 * Struktura Metody pre ziskanie identifikatora filmu
	 */
	public Long getStateId(){
		return state.getId();
	}
	
	/**
	 * 
	 * Struktura Metody pre ziskanie hodnoty datumu filmu
	 */
	public String getYearValue(){
		 SimpleDateFormat ft = new SimpleDateFormat ("yyyy");
		 return ft.format(year);
	}
}
