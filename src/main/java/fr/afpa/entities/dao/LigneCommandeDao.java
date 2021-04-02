package fr.afpa.entities.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @autor Elvis
 */

@Data
@AllArgsConstructor 
@NoArgsConstructor 
@Entity
public class LigneCommandeDao {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long idLigneCommandeDao;
	@Column(name="quantite",nullable = false)
	private int quantite;
	@Column(name="prix",nullable = false)
	private double prix;
	@OneToMany(mappedBy = "ligneCommandeDao")
	private  List<LivreDao> listLivre;
	
	
	@ManyToOne(
			cascade= {CascadeType.PERSIST}
			)
	@JoinColumn(name="idCommande")
	private CommandeDao commandeDao;
}
