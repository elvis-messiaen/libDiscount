package fr.afpa.entities.dao;

import java.awt.Image;
import java.util.ArrayList;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LibrairieDao {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idLibrairie;
@Column(name="nomLibrairie",nullable = false)
private String nomLibrairie;
@Column(name="numVoieLibrairie",nullable = false)
private int numVoieLibrairie;
@Column(name="nomVoieLibrairie",nullable = false)
private String nomVoieLibrairie;
@Column(name="codePostalLibrairie",nullable = false)
private int codePostalLibrairie;
@Column(name="villeLibrairie",nullable = false)
private String villeLibrairie;

@ManyToOne()
@JoinColumn(name= "idUser")
private UserDao user;


public LibrairieDao(int numvoieLibrairie, String nomVoieLibrairie, int codePostalLibrairie, String villeLibrairie) {
	super();
	this.numVoieLibrairie = numvoieLibrairie;
	this.nomVoieLibrairie = nomVoieLibrairie;
	this.codePostalLibrairie = codePostalLibrairie;
	this.villeLibrairie = villeLibrairie;
}



public LibrairieDao(String nomLibrairie, int numVoieLibrairie, String nomVoieLibrairie,
		int codePostalLibrairie, String villeLibrairie) {
	this.nomLibrairie=nomLibrairie;
	this.numVoieLibrairie = numVoieLibrairie;
	this.nomVoieLibrairie=nomVoieLibrairie;
	this.codePostalLibrairie=codePostalLibrairie;
	this.villeLibrairie=villeLibrairie;
}


}






