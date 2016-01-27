package sk.hupcejova.tajj.films.dto;

/**
 * 
 * DTO pre Stav filmu
 *
 */

public class State {
	
	long id;
	String name;
	
	/**
	 * 
	 * Struktura Metody pre ziskanie identifikatora stavu
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * 
	 * Struktura Metody pre nastavenie identifikatora stavu
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * Struktura Metody pre ziskanie nazvu stavu
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * Struktura Metody pre nastavenie mena stavu
	 */
	public void setName(String name) {
		this.name = name;
	}

	
}
