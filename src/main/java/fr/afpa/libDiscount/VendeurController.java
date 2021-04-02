package fr.afpa.libDiscount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.LibrairieDao;
import fr.afpa.entities.dao.RoleDao;
import fr.afpa.entities.dao.UserDao;
import fr.afpa.metier.service.GestionUserService;
import fr.afpa.metier.service.GestionVendeurService;
import fr.afpa.repository.dao.AdresseRepository;
import fr.afpa.repository.dao.VendeurRepository;

/*
 * @author Elvis
 */
@Controller
@SessionAttributes("user")
public class VendeurController {

	private static final Logger logger = LoggerFactory.getLogger(VendeurController.class);

	@Autowired
	private GestionVendeurService gestionVendeurService;
	
	@RequestMapping(value = "/CreationCompteVendeur", method = RequestMethod.POST)

	public String rediCreationCompteVendeur() {
		return "CreationCompteVendeur";
	}

/**
 * methode creation compte vendeur
 * @param nom
 * @param prenom
 * @param mail
 * @param phone
 * @param mdp
 * @param numVoie
 * @param nomVoie
 * @param codePostal
 * @param ville
 * @param actif
 * @param nomLibrairie
 * @param numVoieLibrairie
 * @param nomVoieLibrairie
 * @param codePostalLibrairie
 * @param villeLibrairie
 * @param mv
 * @return
 */
	@PostMapping(value = "/CreationCptVendeur")
	public ModelAndView creatVendeur(
			@RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom, 
			@RequestParam(value = "mail") String mail,
			@RequestParam(value = "phone") String phone, 
			@RequestParam(value = "mdp") String mdp,
//			@RequestParam(value = "confirmmdp") String confirmmdp, 
			@RequestParam(value = "numVoie") int numVoie,
			@RequestParam(value = "nomVoie") String nomVoie, 
			@RequestParam(value = "codePostal") int codePostal,
			@RequestParam(value = "ville") String ville,
			@RequestParam(value = "actif") boolean actif,
			@RequestParam(value = "nomLibrairie") String nomLibrairie,
			@RequestParam(value = "numVoieLibrairie") String numVoieLibrairie,
			@RequestParam(value = "nomVoieLibrairie") String nomVoieLibrairie,
			@RequestParam(value = "codePostalLibrairie") String codePostalLibrairie,
			@RequestParam(value = "villeLibrairie") String villeLibrairie, 
			ModelAndView mv) {

		gestionVendeurService.creatVendeurService(nom, prenom, mail, phone, mdp, numVoie, nomVoie,
				codePostal, actif, ville, nomLibrairie, numVoieLibrairie, nomVoieLibrairie, codePostalLibrairie,
				villeLibrairie);

		mv.setViewName("redirect:/login");
		return mv;
//// <=================================================================================>

//// <======================== operation sur adresse vendeur ==================================================>
	}

	/**
	 * methode ajout adresse 
	 * redirection
	 * @return
	 */
	@RequestMapping(value = ("/AjouterAdresses"), method = RequestMethod.GET)
	public String addAdresseVendeur() {
		return "AjouterAdresses";
	}
	/**
	 * ajouter adresse
	 * @param idUser
	 * @param numVoie
	 * @param nomVoie
	 * @param codePostal
	 * @param ville
	 * @param mod
	 * @param session
	 * @return
	 */
	@PostMapping(value = "/ajoutadrAdresVendeur")
	public ModelAndView ajouterAdresseVendeur(
			@RequestParam(value = "idUser") int idUser,
			@RequestParam(value = "numVoie") int numVoie,
			@RequestParam(value = "nomVoie") String nomVoie, 
			@RequestParam(value = "codePostal") int codePostal,
			@RequestParam(value = "ville") String ville, 
			ModelAndView mod,
			HttpSession session) {
		UserDao user = (UserDao) session.getAttribute("user");
		if (user == null || user.getIdUser() != idUser) {
			mod.setViewName("redirect:/login");
			return mod;
		}

		gestionVendeurService.addAdresseVendeur(idUser, numVoie, nomVoie, codePostal, ville);
		List<AdresseDao> listeAdresseVendeur = gestionVendeurService.allAdressesVendeur(user);
		
		mod.addObject("listeAdrVendeur", listeAdresseVendeur);
		mod.setViewName("Adresses");
		return mod;
	}
/**
 * methode de modification adresse
 * avec verifon de la session
 * @param mv
 * @param session
 * @param id
 * @return
 */
	@RequestMapping(value = ("/modifierAdresseVendeur/{id}"), method = RequestMethod.GET)
	public ModelAndView modAdrPerso(ModelAndView mv,
			HttpSession session,
			@PathVariable(value="id") long id) {
		
		AdresseDao adresse = gestionVendeurService.getAdresse(id);
		
		mv.addObject("adresseVendeur", adresse);
		mv.setViewName("modifierAdrVendeur");
		return mv;
	}
	
/**
 * methode de modification adresse vendeur
 * methode de 
 * @param mv
 * @param id
 * @param numVoie
 * @param nomVoie
 * @param codePostal
 * @param ville
 * @return
 */
	@PostMapping(value="/modifierAdrVendeur")
	public ModelAndView modiAdrPerso (ModelAndView mv, 
			@RequestParam(value="idAdresse")long id,
			@RequestParam(value="numVoie")int numVoie,
			@RequestParam(value="nomVoie")String nomVoie,
			@RequestParam(value="codePostal")int codePostal,
			@RequestParam(value="ville")String ville){
	
		AdresseDao adresse = gestionVendeurService.modifierAdresseVendeur(id, numVoie, nomVoie, codePostal, ville);
		
		mv.setViewName("redirect:Adresses");
		return mv;
	}

	

	/**
	 * methode pour supprimer une adresse avec un id 
	 * @param mv
	 * @param id
	 * @return
	 */
	
	@GetMapping(value="/supprimerAdresseVendeur/{idAdresse}")
	public ModelAndView supAdrVendeur (ModelAndView mv, 
			@PathVariable(value="idAdresse") Long id) {
		
		
		gestionVendeurService.supprimerAdresseVendeur(id);
		mv.setViewName("redirect:/Adresses");
		
		return mv;
	}
	
/**
 * methode affichage adresses
 * @param mv
 * @param session
 * @return
 */
	@GetMapping(value =  "/Adresses")
	public ModelAndView adressevendeur(ModelAndView mv, HttpSession session) {
		UserDao user = (UserDao) session.getAttribute("user");
		if (user == null) {
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		List<AdresseDao> listeAdresseVendeur = gestionVendeurService.allAdressesVendeur(user);
		
		mv.addObject("listeAdrVendeur", listeAdresseVendeur);
		mv.setViewName("Adresses");
		return mv;
	}
	
	
// <=================================================================================>

// <======================== operation sur adresse librairie vendeur ==================================================>	

	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = ("/AjouterLibrairie"), method = RequestMethod.GET)
	public String addAdresseLibrairie() {
		return "AjouterLibrairie";
	}
	
/**
 * 
 * @param idUser
 * @param nomLibrairie
 * @param numVoieLibrairie
 * @param nomVoieLibrairie
 * @param codePostalLibrairie
 * @param villeLibrairie
 * @param mod
 * @param session
 * @return
 */
	@PostMapping( value ="/AjouterLibrairie")
	public ModelAndView ajouterLibrairie(
			@RequestParam(value="idUser")int idUser,
			@RequestParam(value="nomLibrairie")String nomLibrairie,
			@RequestParam(value="numVoieLibrairie")int numVoieLibrairie,
			@RequestParam(value="nomVoieLibrairie")String nomVoieLibrairie,
			@RequestParam(value="codePostalLibrairie")int codePostalLibrairie,
			@RequestParam(value="villeLibrairie")String villeLibrairie,
			ModelAndView mod,
			HttpSession session) {
		UserDao user = (UserDao) session.getAttribute("user");
		if (user == null || user.getIdUser() != idUser) {
			mod.setViewName("redirect:/login");
			return mod;
		}
		gestionVendeurService.addLibrairie(idUser, nomLibrairie, numVoieLibrairie, nomVoieLibrairie, codePostalLibrairie,villeLibrairie );		
		List<LibrairieDao> listeLibrairie = gestionVendeurService.allLibrairie(user);
		mod.addObject("listeLibrairie", listeLibrairie);
		mod.setViewName("Librairie");
		return mod;
	}
	/**
	 * 
	 * @param mv
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping(value = ("/modifierAdrLibrairie/{id}"), method = RequestMethod.GET)
	public ModelAndView modLibrairie(ModelAndView mv,
			HttpSession session,
			@PathVariable(value="id") long id) {
		
		LibrairieDao librairie = gestionVendeurService.getLibrairie(id);
		
		mv.addObject("adresseLibrairie", librairie);
		mv.setViewName("modifierAdrLibrairie");
		return mv;
	}
	
/**
 * 
 * @param mv
 * @param id
 * @param nomLibrairie
 * @param numVoieLibrairie
 * @param nomVoieLibrairie
 * @param codePostalLibrairie
 * @param villeLibrairie
 * @return
 */
	@PostMapping(value="/modifierAdrLibrairie")
	public ModelAndView modiAdrPerso (ModelAndView mv, 
			@RequestParam(value="idLibrairie")long id,
			@RequestParam(value="nomLibrairie")String nomLibrairie,
			@RequestParam(value="numVoieLibrairie")int numVoieLibrairie,
			@RequestParam(value="nomVoieLibrairie")String nomVoieLibrairie,
			@RequestParam(value="codePostalLibrairie")int codePostalLibrairie,
			@RequestParam(value="villeLibrairie")String villeLibrairie){
	
		LibrairieDao librairie = gestionVendeurService.modifierLibrairie(id, nomLibrairie, numVoieLibrairie, nomVoieLibrairie, codePostalLibrairie,villeLibrairie) ;
		
		mv.setViewName("redirect:/Librairie");
		return mv;
	}
	
	/**
	 * 
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/supprimerLibrairie/{idLibrairie}")
	public ModelAndView supLibrairie (ModelAndView mv, 
			@PathVariable(value="idLibrairie") Long id) {
		
		gestionVendeurService.supprimerLibrairie(id);
		mv.setViewName("redirect:/Librairie");
		
		return mv;
	}
	
/**
 * 
 * @param mv
 * @param session
 * @return
 */
	@GetMapping(value =  "/Librairie")
	public ModelAndView adrLibrairie(ModelAndView mv, HttpSession session) {
		UserDao user = (UserDao) session.getAttribute("user");
		if (user == null) {
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		List<LibrairieDao> listeLibrairie = gestionVendeurService.allLibrairie(user);
		
		mv.addObject("listeLibrairie", listeLibrairie);
		mv.setViewName("Librairie");
		return mv;
	}
}
