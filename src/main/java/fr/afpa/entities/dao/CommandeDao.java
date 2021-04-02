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
public class CommandeDao {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long idCommande;
	@Column(name="dateCommande",nullable = false)
	private LocalDate dateCommande;
	@ManyToOne(
			cascade = {CascadeType.PERSIST}
			)
	@JoinColumn(name= "id_user")
	private UserDao user;
	
	@OneToMany(mappedBy = "commandeDao")
	private List<LigneCommandeDao> ligneCommande;
	
}
