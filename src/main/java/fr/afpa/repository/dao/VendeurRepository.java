package fr.afpa.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.LivreDao;
import fr.afpa.entities.dao.UserDao;
@Repository
public interface VendeurRepository extends JpaRepository<UserDao, Long>{
	
	public List<AdresseDao> findByNom(String nom);





}
