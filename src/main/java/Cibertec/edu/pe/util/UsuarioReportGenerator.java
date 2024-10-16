package Cibertec.edu.pe.util;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import Cibertec.edu.pe.Modelo.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class UsuarioReportGenerator {
	public static byte[] exportToPdf(List<Usuario> list)throws JRException, FileNotFoundException{
		return JasperExportManager.exportReportToPdf(getReport(list));
	}
	private static JasperPrint getReport (List<Usuario>list)throws FileNotFoundException, JRException {
		Map<String, Object> params =new HashMap<String, Object>();
		params.put("usersData", new JRBeanCollectionDataSource(list));
		
		
		
	JasperPrint report=	
		JasperFillManager.fillReport(
				JasperCompileManager.compileReport(
		 ResourceUtils.getFile("classpath:userReport.jrxml").getAbsolutePath()),params, new JREmptyDataSource());
       return report;
	}

}
