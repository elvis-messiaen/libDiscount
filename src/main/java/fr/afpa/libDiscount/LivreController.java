package fr.afpa.libDiscount;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.LibrairieDao;
import fr.afpa.entities.dao.LivreDao;
import fr.afpa.entities.dao.UserDao;
import fr.afpa.entities.dto.AjouterLivreDto;
import fr.afpa.metier.service.GestionLivreService;
import fr.afpa.repository.dao.LivreRepository;

/*
 * @author Elvis
 */

@Controller
@SessionAttributes("user")
public class LivreController {

	private static final Logger logger = LoggerFactory.getLogger(VendeurController.class);

	@Autowired
	private GestionLivreService gestionLivreService;
	
	@Autowired
	private LivreRepository livreRepository;

	@RequestMapping(value = "/AjouterLivre", method = RequestMethod.GET)
	public String rediAjouterLivre() {
		return "AjouterLivre";
	}

	/*
	 * creation methode ajouter un livre
	 */

	@PostMapping(value = "/ajoutLivre")
	public ModelAndView ajouLivre(
			@ModelAttribute AjouterLivreDto data,
			@RequestPart(value = "photo") MultipartFile photo,
			ModelAndView mv,
			HttpSession session) throws Exception {

		UserDao user = (UserDao) session.getAttribute("user");
		if (user == null || user.getIdUser() != data.getIdUser()) {

			//mv.setViewName("redirect:/login");
			//return mv;
		}
	
		Blob blob;
		try {
			blob = new SerialBlob(photo.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to save file: {}", e.getMessage());
			throw e;
		}
		
		gestionLivreService.addLivre(data.getIdUser(), data.getTitle(), data.getNiveau(), data.getIsbn(), data.getDateEdition(), data.getMaisonEdition(), data.getPrixUnitaire(), blob);
		List listeLivre = (List) gestionLivreService.allLivre(user);
		
		mv.addObject("listeLivre", listeLivre);
		mv.setViewName("redirect:/Livres");
		return mv;

	}
	@RequestMapping(value = ("/modifierLivre/{id}"), method = RequestMethod.GET)
	public ModelAndView modLivre(ModelAndView mv,
			HttpSession session,
			@PathVariable(value="id") long id) {
		
		LivreDao livre = gestionLivreService.getLivre(id);
		
		mv.addObject("listeLivre", livre);
		mv.setViewName("redirect:/Livres");
		return mv;
	}
	
	
	@PostMapping (value ="/modifLivre")
		public ModelAndView modiLivre(ModelAndView mv,
				@RequestParam(value = "idLivre") long idLivre,
				@RequestParam(value = "title") String title,
				@RequestParam(value = "niveau") String niveau, 
				@RequestParam(value = "isbn") String isbn,
				@RequestParam(value = "dateEdition") int dateEdition,
				@RequestParam(value = "maisonEdition") String maisonEdition,
				@RequestParam(value = "prixUnitaire") double prixUnitaire, 
				@RequestParam(value = "photo") Blob photo) {
			
			LivreDao livre = gestionLivreService.modifierLivre(idLivre, title, niveau, isbn, dateEdition, maisonEdition, prixUnitaire, photo);
			
			mv.setViewName("Livre");
			return mv;
	}
	
	@GetMapping (value ="/supprimerLivre/{id}")
	public ModelAndView supLivre(ModelAndView mv,
			@PathVariable(value="idLivre")Long idLivre) {
		
		gestionLivreService.supprimerLivre(idLivre);
		mv.setViewName("Livre");
		return mv;
		
	}
	
	@GetMapping(value =  "/Livre")
	public ModelAndView adrLivre(ModelAndView mv, HttpSession session) {
		UserDao user = (UserDao) session.getAttribute("user");
		if (user == null) {
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		List<LibrairieDao> listeLivre = gestionLivreService.allLivre(user);
		
		mv.addObject("listeLivre", listeLivre);
		mv.setViewName("Livre");
		return mv;
	}
	

}














