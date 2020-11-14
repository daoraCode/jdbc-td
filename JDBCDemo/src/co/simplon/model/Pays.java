package co.simplon.model;

public class Pays {
	
	private int id;
	private String nom;
	/**
	 * @param id
	 * @param nom
	 */
	public Pays(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	/**
	 * 
	 */
	public Pays() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
    public String toString() {
        return super.toString();
    }	
	
}
