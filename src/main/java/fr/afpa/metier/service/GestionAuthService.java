package fr.afpa.metier.service;

import java.util.Optional;

import javax.management.relation.Role;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.entities.dao.RoleDao;
import fr.afpa.entities.dao.UserDao;
import fr.afpa.repository.dao.UserRepository;

@Service
public class GestionAuthService {
	
	@Autowired
	private UserRepository userRepository;
	/**
	 * 
	 * @param mail
	 * @param password
	 * @return
	 */
	public Optional<UserDao> login(String mail, String password) {
		return userRepository.findByMailAndPassword(mail, password);
	}
/**
 * methode pour gerer les roles
 * @param session
 * @return
 */
	public RoleDao getRole(HttpSession session) {
		UserDao user = (UserDao) session.getAttribute("user");
		return user != null ? user.getRole() : null;
	}
	/**
	 * methode pour verififier si session en cours
	 * @param session
	 * @return
	 */
	public boolean isLogged(HttpSession session) {
		// Get ModelMap: recupere la HashMap des attributs de session
		UserDao user = (UserDao) session.getAttribute("user");
		return user != null;
	}
	
}
