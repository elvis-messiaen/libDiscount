package fr.afpa.libDiscount;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.UserDao;
import fr.afpa.metier.service.GestionUserService;
import fr.afpa.repository.dao.UserRepository;

/*
 * @author Chris
 */
@Controller
@SessionAttributes("user")
public class AdminController {
	@Autowired
	private GestionUserService gestionAdminService;
	@Autowired
	private GestionUserService gestionUserService;
	
	/**
	 * Methode pour afficher la liste des utilisateurs
	 * @param mv
	 * @param session
	 * @return
	 */
	@GetMapping(value = "/gestionUtilisateurs")
	public ModelAndView listerUser(ModelAndView mv, HttpSession session) {
        UserDao user = (UserDao) session.getAttribute("user");
        if (user == null) {
            mv.setViewName("redirect:/login");
            return mv;
        }

        List<UserDao> listeUser = gestionAdminService.afficherListeUser(user);
        System.out.println(listeUser);
        mv.addObject("listeUser", listeUser);
        mv.setViewName("gestionUtilisateurs");
        return mv;
    }
	/**
	 * Methode de controle pour suppression user
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/supprimerUser/{idUser}")
	public ModelAndView supprimerUser (ModelAndView mv, 
			@PathVariable(value="idUser") Long id) {
		
		
		gestionUserService.supprimerUser(id);
		mv.setViewName("redirect:/gestionUtilisateurs");
		
		return mv;
	}
}
