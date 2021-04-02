package fr.afpa.entities.dao;

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
public class AdresseDao { 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long idAdresse; 
	@Column(name = "houseNumber", nullable = false) 
	private int houseNumber; 
	@Column(name = "street", nullable = false) 
	private String street; 
	@Column(name = "postCode", nullable = false) 
	private int codePostal; 
	@Column(name = "town", nullable = false) 
	
	private String town; 
	@ManyToOne() 
	@JoinColumn(name = "idUser")
	private UserDao user;

}
