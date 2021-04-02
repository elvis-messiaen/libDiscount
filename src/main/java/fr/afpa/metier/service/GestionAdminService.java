package fr.afpa.metier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.repository.dao.AdresseRepository;
import fr.afpa.repository.dao.UserRepository;

/*
 * @author Chris
 */
@Service
public class GestionAdminService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdresseRepository adresseRepository;
	
	

}
