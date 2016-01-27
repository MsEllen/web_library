package sk.hupcejova.tajj.films.dto;

/**
 * 
 * DTO pre Zaner filmu
 *
 */

public class Genre {
	long id;
	String name;
	
	/**
	 * 
	 * Struktura Metody pre ziskanie identifikatora zanru
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * 
	 * Struktura Metody pre nastavenie identifikatora zanru
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * Struktura Metody pre ziskanie nazvu zanru
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * Struktura Metody pre nastavenie nazvu zanru
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
