package fr.afpa.libDiscount;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.UserDao;
import fr.afpa.metier.service.GestionUserService;

/**
 * Handles requests for the application home page.
 */
/*
 * @author Chris
 */
@Controller
@SessionAttributes("user")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private GestionUserService gestionUserService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		return "Accueil";
	}
	
		//redirection vers la page creationCompte
		@GetMapping(value = "/Creation")
		public String redirectionFormulaireCreationUser() {
			return "Creation";
		}
		
		//creation Compte
		@PostMapping(value = "/Creation")
		public ModelAndView createUser(
				@RequestParam(value = "nom") String nom ,
				@RequestParam(value = "prenom") String prenom,
				@RequestParam(value = "mail") String mail,
				@RequestParam(value = "phone") String phone,
				@RequestParam(value = "pwd") String pwd,
				@RequestParam(value = "numVoie") String numVoie,
				@RequestParam(value = "nomVoie") String nomVoie,
				@RequestParam(value = "codePostal") String codePostal,
				@RequestParam(value = "ville") String ville,
				@RequestParam(value = "actif") boolean actif,
				ModelAndView mv) {
			
			gestionUserService.createUserService(nom, prenom, mail, phone, pwd, numVoie, nomVoie, codePostal, ville, actif);			
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		@PostMapping(value="/modifierInfosClient")
		public ModelAndView modifierInfosClient (
				@RequestParam(value = "nom") String nom ,
				@RequestParam(value = "prenom") String prenom,
				@RequestParam(value = "mail") String mail,
				@RequestParam(value = "phone") String phone,
				@RequestParam(value = "pwd") String pwd,
				@RequestParam(value = "idUser") String idUser ,
				ModelAndView mv 
				){
		
			gestionUserService.modifierInfosClient(nom, prenom, mail, phone, pwd, Long.parseLong(idUser));			
			mv.setViewName("redirect:/mesInformations");
			return mv;
		}
		
		
		    
		//redirection vers la page createCompteVendeur
		@GetMapping(value = "/CreationCompteVendeur")
		public String redirectionFormulaireCreationVendeur() {
			return "CreationCompteVendeur";
		}
		
		//redirection vers la page login Admin
		@GetMapping(value = "/loginAdmin")
		public String redirectionloginAdmin() {
			return "loginAdmin";
		}
			
		//redirection vers le panier
		@GetMapping(value = "/Panier")
		public String redirectionPanier() {
			return "Panier";
		}
		//redirection vers mon compte
		@GetMapping(value = "/MonCompte")
		public String MonCompte() {
			return "MonCompte";
		}
		
		//redirection vers mon compte Vendeur
		@GetMapping(value = "/MonCompteVendeur")
		public String MonCompteVendeur() {
			return "MonCompteVendeur";
		}
		
		//redirection vers la page Admin
		@GetMapping(value = "/Admin")
		public String Admin() {
			return "Admin";
		}

//		//redirection vers la page Livre
//		@GetMapping(value = "/Livre")
//		public String livre() {
//			return "Livre";
//		}
		//redirection vers la page modifier infos client

		@GetMapping(value = "/modifierInfosClient")
		public String modifierInfosClient() {
			return "modifierInfosClient";
		}
		//redirection vers la page mes informations client
		@GetMapping(value = "/mesInformations")
		public String mesInformations() {
			return "mesInformations";
		}
		/**
		 * methode affichage adresse utilisateur role client si null renvoi page login
		 * @param mv
		 * @param session
		 * @return
		 */
		@GetMapping(value =  "/adressesClient")
	    public ModelAndView adressesClient(ModelAndView mv, HttpSession session) {
	        UserDao user = (UserDao) session.getAttribute("user");
	        if (user == null) {
	            mv.setViewName("redirect:/login");
	            return mv;
	        }

	        List<AdresseDao> listeAdresseClient = gestionUserService.afficherAdresseClient(user);
	        System.out.println(listeAdresseClient);
	        mv.addObject("listeAdrClient", listeAdresseClient);
	        mv.setViewName("adressesClient");
	        return mv;
	    }
		/**
		 * methode ajout adresse utilisateur role client
		 * @param idUser
		 * @param numVoie
		 * @param nomVoie
		 * @param codePostal
		 * @param ville
		 * @param mv
		 * @return
		 */
		@PostMapping(value="/ajouterAdresseClient")
		public ModelAndView ajouterAdresseClient (
				@RequestParam(value = "idUser") String idUser,
				@RequestParam(value = "numVoie") int numVoie,
				@RequestParam(value = "nomVoie") String nomVoie,
				@RequestParam(value = "codePostal") int codePostal,
				@RequestParam(value = "ville") String ville,
				ModelAndView mv 
				){
		
			gestionUserService.addAdresseClient(Long.parseLong(idUser), numVoie, nomVoie, codePostal, ville );			
			mv.setViewName("redirect:/Adresses");
			return mv;
		}
		// redirection vers la page ajouter adresse client
		@GetMapping(value = "/ajouterAdresseClient")
		public String ajouterAdresseClient() {
			return "ajouterAdresseClient";
		}
		
		@RequestMapping(value = ("/modifierAdresseClient/{idAdresse}"), method = RequestMethod.GET)
		public ModelAndView modifierAdresseClient(ModelAndView mv,
				HttpSession session,
				@PathVariable(value="idAdresse") long id) {
			
			AdresseDao adresse = gestionUserService.getAdresse(id);
			
			mv.addObject("adresseClient", adresse);
			mv.setViewName("modifierAdresseClient");
			return mv;
		}
		

		@PostMapping(value="/modifierAdresseClient")
		public ModelAndView modifierAdresseClient (ModelAndView mv, 
				@RequestParam(value="idAdresse")long idAdresse,
				@RequestParam(value="numVoie")String numVoie,
				@RequestParam(value="nomVoie")String nomVoie,
				@RequestParam(value="codePostal")String codePostal,
				@RequestParam(value="ville")String ville){
		
			gestionUserService.modifierAdresseClient(idAdresse, Integer.parseInt(numVoie), nomVoie, Integer.parseInt(codePostal), ville);
			
			mv.setViewName("redirect:/adressesClient");
			return mv;
		}
		
		// pour supprimer une adresse avec un id 
		
		@GetMapping(value="/supprimerAdresseClient/{idAdresse}")
		public ModelAndView supAdrVendeur (ModelAndView mv, 
				@PathVariable(value="idAdresse") Long id) {
			
			
			gestionUserService.supprimerAdresseClient(id);
			mv.setViewName("redirect:/adressesClient");
			
			return mv;
		}


}
