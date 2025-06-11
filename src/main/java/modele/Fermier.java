package modele;


public class Fermier {
	private int id;
	private String nom;
	private String email;




public Fermier(int id, String nom, String email) {
     this.id = id;
     this.nom = nom;
     this.email = email;
 }


 // Getters
	public int getId() {
		return id;
		}

	public String getNom() {
		return nom;
		}

	public String getEmail() {
		return email;
		}

 // Setters
	public void setId(int id) {
		this.id = id;
		}

	public void setNom(String nom) {
		this.nom = nom;
		}

	public void setEmail(String email) {
		this.email = email;
		}

 // toString
	@Override
	public String toString() {
		return "Fermier{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", email='" + email + '\'' +
				'}';
			}

	}




