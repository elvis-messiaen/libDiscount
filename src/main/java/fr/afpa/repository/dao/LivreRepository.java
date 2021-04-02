package fr.afpa.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.LibrairieDao;
import fr.afpa.entities.dao.LivreDao;
import fr.afpa.entities.dao.UserDao;
@Repository
public interface LivreRepository extends JpaRepository<LivreDao, Long> {
	
	List<LivreDao> findAllByidLivre(Long id);

	List<LibrairieDao> findAllByUserIdUser(Long idUser);

	List<LivreDao> findByUserIdUser(Long idUser);
	
}
