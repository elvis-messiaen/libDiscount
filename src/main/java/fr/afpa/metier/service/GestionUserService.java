package fr.afpa.metier.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.RoleDao;
import fr.afpa.entities.dao.UserDao;
import fr.afpa.repository.dao.AdresseRepository;
import fr.afpa.repository.dao.UserRepository;
import fr.afpa.repository.dao.libDiscountRepository;
/*
 * @author Chris
 */
@Service
public class GestionUserService {

	@Autowired
	private AdresseRepository adresseRepository;

	@Autowired
	private libDiscountRepository libDiscountRepository;
	
	@Autowired
	private UserRepository userRepository;
	/**
	 * methode creation d'un utilisateur role client
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param phone
	 * @param pwd
	 * @param numVoie
	 * @param nomVoie
	 * @param codePostal
	 * @param ville
	 * @param actif
	 * @return
	 */
	public UserDao createUserService(String nom , String prenom, String mail, String phone, String pwd, String numVoie, String nomVoie, String codePostal, String ville, boolean actif) {
		
		
		AdresseDao adresse = new AdresseDao(Integer.parseInt(numVoie), nomVoie, Integer.parseInt(codePostal), ville);
		List<AdresseDao> list = new ArrayList<AdresseDao>();
		list.add(adresse);
		
		UserDao user = new UserDao(nom, prenom, mail, pwd, phone, list, actif);
		user.setRole(RoleDao.CLIENT);
		user.setAdresse(list);
		adresse.setUser(user);		
		user = libDiscountRepository.save(user);
		adresse = adresseRepository.save(adresse);
		return user;
		
	}
	/**
	 * methode pour modifier les infos utilisateur role client
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param phone
	 * @param pwd
	 * @param idUser
	 * @return
	 */
	public UserDao modifierInfosClient(String nom , String prenom, String mail, String phone, String pwd, Long idUser) {
			
			UserDao user = userRepository.findByIdUser(idUser);
			 user.setNom(nom);
			user.setPrenom(prenom);
			user.setMail(mail);
			user.setTelephone(phone);
			user.setPassword(pwd);
			userRepository.setUserInfoById(nom, prenom, mail, phone, pwd, idUser);
			
			
			return user;
		}
	/**
	 * methode pour ajouter une adresse role client
	 * @param idUser
	 * @param numVoie
	 * @param nomVoie
	 * @param codePostal
	 * @param ville
	 * @return
	 */
	public AdresseDao addAdresseClient(long idUser, int numVoie, String nomVoie, int codePostal, String ville) {
			
			UserDao user = userRepository.findById(idUser).orElseThrow(EntityNotFoundException::new);
			AdresseDao adresse = new AdresseDao(numVoie, nomVoie, codePostal, ville);
			adresse.setUser(user);
			user.getAdresse().add(adresse);
			
			userRepository.save(user);
	
			return adresse;
		}
	/**
	 * methode pour afficher la liste adresses role client
	 * @param user
	 * @return
	 */
	public List<AdresseDao> afficherAdresseClient(UserDao user) {	
		return adresseRepository.findAllByUserIdUser(user.getIdUser());
	}
	/**
	 * methode de suppression adresse pour le role client
	 * @param id
	 */
	public void supprimerAdresseClient(Long id) {
		adresseRepository.deleteById(id);
	}
	/**
	 * methode pour recuperer une adresse
	 */
	public AdresseDao getAdresse(long id) {
		return adresseRepository.findById(id)
				// Lance une exception si pas en bdd
				.orElseThrow(EntityNotFoundException::new);
	}
	/**
	 * methode pour modifier une adresse
	 * @param id
	 * @param numVoie
	 * @param nomVoie
	 * @param codePostal
	 * @param ville
	 * @return
	 */
	public AdresseDao modifierAdresseClient(long id, int numVoie, String nomVoie, int codePostal, String ville) {
		AdresseDao adresse = adresseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		adresse.setNumVoie(numVoie);
		adresse.setNomVoie(nomVoie);
		adresse.setCodePostal(codePostal);
		adresse.setVille(ville);
		return adresseRepository.save(adresse);
	}
	/**
	 * methode pour afficher la liste des utilisateurs
	 * @param user
	 * @return
	 */
	public List<UserDao> afficherListeUser(UserDao user) {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	/**
	 * methode de suppression utilisateur
	 * @param id
	 */
	public void supprimerUser(Long id) {
		userRepository.deleteById(id);
		
	}
	



	
}

		
		


