package fr.afpa.metier.service;

import java.sql.Blob;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.entities.dao.LibrairieDao;
import fr.afpa.entities.dao.LivreDao;
import fr.afpa.entities.dao.UserDao;
import fr.afpa.repository.dao.LivreRepository;
import fr.afpa.repository.dao.VendeurLibrairieRepository;
import fr.afpa.repository.dao.VendeurRepository;

/*
 * @author Elvis
 */
@Service
@Transactional
public class GestionLivreService {
	@Autowired
	private LivreRepository livreRepository;
	@Autowired
	private VendeurRepository vendeurRepository;

	@Autowired
	private VendeurLibrairieRepository vendeurLibrairieRepository;
	

	/**
	 * 
	 * @param id
	 * @return
	 */
	public LivreDao getLivre(long id) {
		return livreRepository.findById(id)
				// Lance une exception si pas en bdd
				.orElseThrow(EntityNotFoundException::new);
	}
	/**
	 * methode ajout de livre
	 * @param idUser
	 * @param title
	 * @param niveau
	 * @param isbn
	 * @param dateEdition
	 * @param maisonEdition
	 * @param prixUnitaire
	 * @param photo
	 * @return
	 */
	public LivreDao addLivre(long idUser, String title,String niveau,String isbn, int dateEdition, String maisonEdition, double prixUnitaire, Blob photo) {
		
		UserDao user = vendeurRepository.findById(idUser).orElseThrow(EntityNotFoundException::new);
		LivreDao livre = new LivreDao(title, niveau, isbn, dateEdition, maisonEdition, prixUnitaire, photo);
		user.getLivre().add(livre);
		livre.setUser(user);

		new Exception().printStackTrace();
		livreRepository.save(livre);

		return livre;
	}
	/**
	 * methode modifier livre
	 * @param id
	 * @param title
	 * @param niveau
	 * @param isbn
	 * @param dateEdition
	 * @param maisonEdition
	 * @param prixUnitaire
	 * @param photo
	 * @return
	 */
	public LivreDao modifierLivre(long id, String title,String niveau,String isbn, int dateEdition, String maisonEdition, double prixUnitaire,Blob photo) {
		LivreDao livre = livreRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		livre.setTitle(title);
		livre.setNivScolaire(niveau);
		livre.setIsbn(isbn);
		livre.setDateEdition(dateEdition);	
		livre.setMaisonEdition(maisonEdition);
		livre.setPrixUnitaire(prixUnitaire);
		livre.setImage(photo);
		return livreRepository.save(livre);
	}

	/**
	 * methode de suppression livre
	 * @param id
	 */
	public void supprimerLivre(Long id) {
		livreRepository.deleteById(id);
	}
	
	/**
	 * methode affichage livre
	 * @param idUser
	 * @return
	 */
	public List<LivreDao> afficherLivre(Long idUser) {	
		return livreRepository.findByUserIdUser(idUser);
	}
	/**
	 * methode affiche tout les livres 
	 * @param user
	 * @return
	 */
	public List<LibrairieDao> allLivre(UserDao user) {
		return livreRepository.findAllByUserIdUser(user.getIdUser());
	}
	
}
