package fr.afpa.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.LibrairieDao;

public interface LibrairieRepository extends JpaRepository <LibrairieDao, Long> {
	
	ArrayList<LibrairieDao> findByUserIdUser(Long id);
	
	/**
	 * Recupere la liste des addreses de librairie pour un utilisateur
	 * @param id de l'utilisateur
	 * @return liste des adresses de librairie de l'utilisateur
	 */
	List<LibrairieDao> findAllByUserIdUser(Long id);
	List<LibrairieDao> findByidLibrairie(Long idLibrairie);
	
	
//	public List<LibrairieDao> findByNom(String nom);

}
