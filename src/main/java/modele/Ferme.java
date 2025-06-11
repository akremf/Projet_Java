package modele;




public class Ferme {
	private int id;
	private String nom;
	private String localisation;
	private int idFermier;

 // Constructeur


public Ferme(int id, String nom, String localisation, int idFermier) {
		this.id = id;
		this.nom = nom;
		this.localisation = localisation;
		this.idFermier = idFermier;
 }

 // Getters
	public int getId() {
		return id;
		}

	public String getNom() {
		return nom;
		}

	public String getLocalisation() {
		return localisation;
		}

	public int getIdFermier() {
		return idFermier;
		}

 // Setters
	public void setId(int id) {
		this.id = id;
		}

	public void setNom(String nom) {
		this.nom = nom;
		}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
		}

	public void setIdFermier(int idFermier) {
		this.idFermier = idFermier;
		}

 // toString
	@Override
		public String toString() {
		return "Ferme{" +
             "id=" + id +
             ", nom='" + nom + '\'' +
             ", localisation='" + localisation + '\'' +
             ", idFermier=" + idFermier +
             '}';
		}
}

