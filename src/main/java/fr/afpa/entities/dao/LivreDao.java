package fr.afpa.entities.dao;
import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @autor Elvis
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LivreDao {
	public LivreDao(String title, String niveau, String isbn, LocalDate dateEdition, String maisonEdition,
			double prixUnitaire, Blob photo) {

	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivre;
	@Column(name="titre",nullable = false)
	private String title;
	@Column(name="niveauScolaire",nullable = false)
	private String nivScolaire;
	@Column(name="ISBN",nullable = false,length = 13)
	private String isbn;
	@Column(name="dateEdition",nullable = false)
	private int dateEdition;
	@Column(name="maisonEdition",nullable = false)
	private String maisonEdition;
	@Column(name="prixUnitaire",nullable = false)
	private double prixUnitaire;
	private Blob image;
	
	@ManyToOne(
			cascade= {CascadeType.PERSIST}
			)
	@JoinColumn(name="idCategorie")
	private CategorieDao categorie;
	
	
	@ManyToOne(
			cascade= {CascadeType.PERSIST}
			)
	@JoinColumn(name="idLigneCommandeDao")
	private LigneCommandeDao ligneCommandeDao;
	
	@ManyToOne()
	
	@JoinColumn(name= "idUser")
	private UserDao user;

	public LivreDao(String title, String nivScolaire, String isbn, int dateEdition, String maisonEdition,
			double prixUnitaire, Blob image) {
		super();
		this.title = title;
		this.nivScolaire = nivScolaire;
		this.isbn = isbn;
		this.dateEdition = dateEdition;
		this.maisonEdition = maisonEdition;
		this.prixUnitaire = prixUnitaire;
		this.image = image;
	}


	
}
