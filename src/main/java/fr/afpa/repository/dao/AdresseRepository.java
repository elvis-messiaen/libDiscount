package fr.afpa.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.entities.dao.AdresseDao;
/*
 * @author Chris
 */
@Repository
public interface AdresseRepository extends JpaRepository<AdresseDao, Long> {

	ArrayList<AdresseDao> findByUserIdUser(Long id);
	
	List<AdresseDao> findByidAdresse(Long idAdresse);
//	AdresseDao findByIdAdresse (Long idAdresse);

	
	/**
	 * Recupere la liste des addreses du vendeur
	 * @param id du vendeur
	 * @return liste des adresses du vendeur
	 */
	List<AdresseDao> findAllByUserIdUser(Long id);
	
	
	

}
