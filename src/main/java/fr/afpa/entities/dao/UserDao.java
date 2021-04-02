package fr.afpa.entities.dao;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * @author Chris
 */
@Data
@AllArgsConstructor 
@NoArgsConstructor 
@Entity(name="utilisateur")
public class UserDao {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long idUser;
	private String nom;
	private String prenom;
	
	@Column(unique = true)
	private String mail;
	private String password;
	private String telephone;
	/*
	 * cascdade pour creer l'utilisateur et les listes en même temps 
	 * orphanRemoval si adresse supprimer ou user adresse sera supprimer partout
	 */

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AdresseDao> adresse;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LibrairieDao> librairie;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AnnonceDao> annonce;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CommandeDao> commande;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LivreDao> livre;
	
	@Enumerated(EnumType.STRING)
	private RoleDao role;
	
	private boolean actif;
	
	
	public UserDao(String nom, String prenom, String mail, String password, String telephone, List<AdresseDao> adresse,
			RoleDao role, boolean actif) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.telephone = telephone;
		this.adresse = adresse;
		this.role = role;
		this.actif = actif;
	}


	public UserDao(String nom, String prenom, String mail, String password, String telephone, List<AdresseDao> adresse,
			List<LibrairieDao> librairie, RoleDao role, boolean actif) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.telephone = telephone;
		this.adresse = adresse;
		this.librairie = librairie;
		this.role = role;
		this.actif = actif;
	}


	public UserDao(String nom, String prenom, String mail, String password, String telephone, List<AdresseDao> adresse,
			boolean actif) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.telephone = telephone;
		this.adresse = adresse;
		this.actif = actif;
	}
	
	public String toString() {
		return mail;
	}
	
	
}
