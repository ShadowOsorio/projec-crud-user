package Cibertec.edu.pe.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Cibertec.edu.pe.Modelo.Usuario;
import Cibertec.edu.pe.Repository.IUsuarioRepository;
import Cibertec.edu.pe.util.UsuarioReportGenerator;
import net.sf.jasperreports.engine.JRException;

@Service
public class UsuarioServiceImplement  implements IUsuarioService{
	
	@Autowired
	private  IUsuarioRepository repositorio;
	

	@Override
	public List<Usuario> ListarUsuarios() {
		
		return repositorio.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		
		return repositorio.save(usuario);
	}

	@Override
	public Optional<Usuario> buscarUsuario(int codigo) {
		
		return repositorio.findById(codigo);
	}

	@Override
	public void eliminarUsuario(int codigo) {
		repositorio.deleteById(codigo);
		
	}

	@Override
	public byte[] exportPdf() throws JRException, FileNotFoundException {
		return UsuarioReportGenerator.exportToPdf(repositorio.findAll());
	}


}
