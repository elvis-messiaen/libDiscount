package fr.afpa.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjouterLivreDto {
	private long idUser;
	private String title;
	private String niveau;
	private String isbn;
	private int dateEdition;
	private String maisonEdition;
	private double prixUnitaire;
}
