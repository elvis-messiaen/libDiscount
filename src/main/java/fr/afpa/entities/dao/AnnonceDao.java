package fr.afpa.entities.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "annonce")
public class AnnonceDao {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_annonce")
	private Long idAnnonce;
	
	
	private Date date;
	private String titre;
	private int remise;
	private double prixTotal;
	
	@OneToOne
	@JoinColumn(name= "idLivre", referencedColumnName = "idLivre")
	private LivreDao livre;
	
	@ManyToOne(
            cascade = {CascadeType.PERSIST}
            )
    @JoinColumn(name= "id_user")
    private UserDao user;

	public AnnonceDao(Date date, String titre, int remise, double prixTotal, LivreDao livre, UserDao user) {
		super();
		this.date = date;
		this.titre = titre;
		this.remise = remise;
		this.prixTotal = prixTotal;
		this.livre = livre;
		this.user = user;
	}
	
	
	

}
