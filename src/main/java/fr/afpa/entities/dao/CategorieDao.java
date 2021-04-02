package fr.afpa.entities.dao;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * @autor Elvis
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategorieDao {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE) 
private Long idCategorie;
@Column(name="nomCategorieLivre",nullable = false)
private String nomCategorie;
@OneToMany(mappedBy = "categorie")
private List<LivreDao> listeLivre;

}
