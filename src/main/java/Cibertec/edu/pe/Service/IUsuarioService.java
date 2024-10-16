package Cibertec.edu.pe.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import Cibertec.edu.pe.Modelo.Usuario;
import net.sf.jasperreports.engine.JRException;

public interface IUsuarioService {
	public List<Usuario>ListarUsuarios();
	public Usuario guardarUsuario(Usuario usuario);
	public Optional <Usuario> buscarUsuario(int codigo);
	public void eliminarUsuario(int codigo);
	byte[]  exportPdf()throws JRException, FileNotFoundException;

}
