package Cibertec.edu.pe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Cibertec.edu.pe.Modelo.Usuario;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
