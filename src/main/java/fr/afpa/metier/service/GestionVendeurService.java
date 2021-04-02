package fr.afpa.metier.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.LibrairieDao;
import fr.afpa.entities.dao.RoleDao;
import fr.afpa.entities.dao.UserDao;
import fr.afpa.repository.dao.AdresseRepository;
import fr.afpa.repository.dao.LibrairieRepository;
import fr.afpa.repository.dao.VendeurLibrairieRepository;
import fr.afpa.repository.dao.VendeurRepository;


/*
 * @author Elvis
 */
@Service
@Transactional
public class GestionVendeurService {
	@Autowired
	private AdresseRepository adresseRepository;
	
	@Autowired
	private LibrairieRepository librairieRepository;

	@Autowired
	private VendeurRepository vendeurRepository;

	@Autowired
	private VendeurLibrairieRepository vendeurLibrairieRepository;

/**
 * 
 * @param nom
 * @param prenom
 * @param mail
 * @param phone
 * @param mdp
 * @param numVoie
 * @param nomVoie
 * @param codePostal
 * @param actif
 * @param ville
 * @param nomLibrairie
 * @param numVoieLibrairie
 * @param nomVoieLibrairie
 * @param codePostalLibrairie
 * @param villeLibrairie
 * @return
 */
	public UserDao creatVendeurService(String nom, String prenom, String mail, String phone, String mdp, 
			int numVoie,String nomVoie ,int codePostal, boolean actif, String ville, String nomLibrairie,
			String numVoieLibrairie, String nomVoieLibrairie, String codePostalLibrairie, String villeLibrairie) {
	
	
		/**
		 * creation et ajout adresse 
		 */
		AdresseDao adresse = new AdresseDao(numVoie,nomVoie, codePostal,ville);
		List<AdresseDao> listAdressePerso = new ArrayList<AdresseDao>();
		listAdressePerso.add(adresse);
		

	/**
	 * creation et ajout adresse librairie
	 */
		LibrairieDao adresseLibrairie = new LibrairieDao(nomLibrairie, Integer.parseInt(numVoieLibrairie),nomVoieLibrairie, Integer.parseInt(codePostalLibrairie),villeLibrairie);
		List<LibrairieDao> listAdresseLibrairie = new ArrayList<LibrairieDao>();

		listAdresseLibrairie.add(adresseLibrairie);
		
		UserDao userVendeur = new UserDao(nom,prenom,mail,phone,mdp,listAdressePerso,actif);
		userVendeur.setLibrairie(listAdresseLibrairie);
		userVendeur.setRole(RoleDao.VENDEUR);
		adresseLibrairie.setUser(userVendeur);
		adresse.setUser(userVendeur);

		userVendeur = vendeurRepository.save(userVendeur);
		return userVendeur;
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<AdresseDao> allAdressesVendeur(UserDao user) {
		return adresseRepository.findAllByUserIdUser(user.getIdUser());
	}

	public AdresseDao getAdresse(long id) {
		return adresseRepository.findById(id)
				/**
				 *  Lance une exception si pas en bdd
				 */
				.orElseThrow(EntityNotFoundException::new);
	}
	/**
	 * 
	 * @param idVendeur
	 * @param numVoie
	 * @param nomVoie
	 * @param codePostal
	 * @param ville
	 * @return
	 */
	public AdresseDao addAdresseVendeur(long idVendeur, int numVoie, String nomVoie, int codePostal, String ville) {
	/**
	 * methode pour ajour adresse Vendeur
	 */
		UserDao user = vendeurRepository.findById(idVendeur).orElseThrow(EntityNotFoundException::new);
		AdresseDao adresse = new AdresseDao(numVoie, nomVoie, codePostal, ville);
		user.getAdresse().add(adresse);
		adresse.setUser(user);

		vendeurRepository.save(user);

		return adresse;
	}
/**
 * methode pour modifier adresse vendeur
 * @param id
 * @param numVoie
 * @param nomVoie
 * @param codePostal
 * @param ville
 * @return
 */
	public AdresseDao modifierAdresseVendeur(long id, int numVoie, String nomVoie, int codePostal, String ville) {
		AdresseDao adresse = adresseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		adresse.setNumVoie(numVoie);
		adresse.setNomVoie(nomVoie);
		adresse.setCodePostal(codePostal);
		adresse.setVille(ville);
		return adresseRepository.save(adresse);
	}

	/**
	 * meethode pour delte adresse vendeur
	 * @param id
	 */
	public void supprimerAdresseVendeur(Long id) {
		adresseRepository.deleteById(id);
	}
	
	/**
	 * methode pour afficher adresse vendeur
	 * @param idUser
	 * @return
	 */
	public List<AdresseDao> afficherAdresseVendeur(Long idUser) {	
		return adresseRepository.findByUserIdUser(idUser);
	}
	
	
	
	/**
	 * methode pour suppression adresse vendeur	
	 * @param id
	 */
			public void supprimerLibrairie(Long id) {
			librairieRepository.deleteById(id);
		}

			
	/**	
	 * 
	 * @param idUser
	 * @return
	 */
		public List<LibrairieDao> afficherLibrairie(Long idUser) {	
			return librairieRepository.findByUserIdUser(idUser);
		}	
	/**	
	 * 
	 * @param user
	 * @return
	 */
		public List<LibrairieDao> allLibrairie(UserDao user) {
			return librairieRepository.findAllByUserIdUser(user.getIdUser());
		}
/**
 * 
 * @param id
 * @return
 */
		public LibrairieDao getLibrairie(long id) {
			return librairieRepository.findById(id)
					// Lance une exception si Librairie est pas en bdd
					.orElseThrow(EntityNotFoundException::new);
		}
	/**	
	 * methode ajout adresse librairie
	 * @param idLibrairie
	 * @param nomLibrairie
	 * @param numVoieLibrairie
	 * @param nomVoieLibrairie
	 * @param codePostalLibrairie
	 * @param villeLibrairie
	 * @return
	 */
		public LibrairieDao addLibrairie(long idLibrairie, String nomLibrairie,int numVoieLibrairie, String nomVoieLibrairie, int codePostalLibrairie, String villeLibrairie) {
			
			UserDao user = vendeurLibrairieRepository.findById(idLibrairie).orElseThrow(EntityNotFoundException::new);
			LibrairieDao librairie = new LibrairieDao(nomLibrairie, numVoieLibrairie, nomVoieLibrairie, codePostalLibrairie,villeLibrairie );
			user.getLibrairie().add(librairie);
			librairie.setUser(user);

			vendeurLibrairieRepository.save(user);

			return librairie;
		}

/**
 * methode modification adresse  librairie
 * @param idVendeur
 * @param nomLibrairie
 * @param numVoieLibrairie
 * @param nomVoieLibrairie
 * @param codePostalLibrairie
 * @param villeLibrairie
 * @return
 */
		public LibrairieDao modifierLibrairie(long idVendeur,String nomLibrairie, int numVoieLibrairie, String nomVoieLibrairie, int codePostalLibrairie,String villeLibrairie) {
			LibrairieDao adresseLibrairie = librairieRepository.findById(idVendeur).orElseThrow(EntityNotFoundException::new);
			adresseLibrairie.setNomVoieLibrairie(nomLibrairie);
			adresseLibrairie.setNumVoieLibrairie(numVoieLibrairie);
			adresseLibrairie.setNomVoieLibrairie(nomVoieLibrairie);
			adresseLibrairie.setCodePostalLibrairie(codePostalLibrairie);
			adresseLibrairie.setVilleLibrairie(villeLibrairie);
			return librairieRepository.save(adresseLibrairie);
		}

	
}
