package fr.afpa.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.LibrairieDao;
import fr.afpa.entities.dao.UserDao;
@Repository
public interface VendeurLibrairieRepository extends JpaRepository<UserDao, Long>{
	
	public List<LibrairieDao> findByNom(String nom);



}
