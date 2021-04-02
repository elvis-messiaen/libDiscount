package fr.afpa.repository.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afpa.entities.dao.AdresseDao;
import fr.afpa.entities.dao.UserDao;

import java.util.List;
import java.util.Optional;
/*
 * @author Chris
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserDao, Long> {
	
	Optional<UserDao> findByMailAndPassword(String mail, String password);
	
	
	@Modifying
	@Query("update utilisateur u set u.nom = :nom, u.prenom = :prenom,u.mail = :mail,u.telephone = :phone, u.password = :password where u.idUser = :idUser")
	void setUserInfoById(@Param("nom")String nom, @Param("prenom")String prenom, @Param("mail")String mail, @Param("phone")String phone, @Param("password")String password, @Param("idUser")Long userId);


	 UserDao findByIdUser(Long idUser);
}
