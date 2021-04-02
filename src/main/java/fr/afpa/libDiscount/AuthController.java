package fr.afpa.libDiscount;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.entities.dao.RoleDao;
import fr.afpa.entities.dao.UserDao;
import fr.afpa.metier.service.GestionAuthService;

/*
 * @author Elvis
 */
@Controller
@SessionAttributes("user")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private GestionAuthService authService;
	
	
	//redirection vers la page login
	@GetMapping(value = "/login")
	public String login(HttpSession session) {
		logger.info("Connexion de l'utilisateur {}", session.getAttribute("user"));
		if (authService.isLogged(session)) {
			return "redirect:/";
		} else {
			return "login";
		}
	}
			
	@PostMapping(value = "/login")
	public ModelAndView login(
			ModelAndView mv,
			@RequestParam String mail,
			@RequestParam String password) {
		logger.info("Connexion de l'utilisateur {}", mail);
		
		Optional<UserDao> userData = authService.login(mail, password);
		
		if (userData.isPresent()) {
			logger.info("L'utilisateur {} est connecter", mail);
			if(userData.get().getRole().name().contains("CLIENT")) {
				// Set la session et renvoie sur la page mon Compte en fonction du role
		        mv.addObject("user", userData.get());
				mv.setViewName("redirect:/MonCompte");
				
			}
			else if(userData.get().getRole().name().contains("VENDEUR")){
				// Set la session et renvoie sur la page mon Compte Vendeuren fonction du role
				mv.addObject("user", userData.get());
				mv.setViewName("redirect:/MonCompteVendeur");
			}
			else if(userData.get().getRole().name().contains("ADMIN")) {
				// Set la session et renvoie sur la page Admin en fonction du role
				mv.addObject("user", userData.get());
				mv.setViewName("redirect:/Admin");
			}
			return mv;
		} else {
			logger.info("L'utilisateur {} n'est pas connecter", mail);
			
			// Ajoute l'erreur et renvoie sur login
			mv.addObject("erreur", "Utilisateur ou mot de passe invalide");
			mv.setViewName("login");
			return mv;
		}
	}
	
	@Controller
    public class LogoutController {

        @RequestMapping(value="/logout",method = RequestMethod.GET)
        public String logout(HttpServletRequest request){
            HttpSession httpSession = request.getSession();
            httpSession.invalidate();
            return "redirect:/";
        }

    }
	
}
