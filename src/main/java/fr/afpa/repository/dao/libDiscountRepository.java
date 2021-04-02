package fr.afpa.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.entities.dao.UserDao;
/*
 * @author Chris
 */
@Repository
public interface libDiscountRepository extends JpaRepository<UserDao, Long> {

	

}
