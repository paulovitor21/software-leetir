package br.com.paulovitor.naturassp.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadServiceImpl implements IUploadService {

	@Override
	public String uploadFile(MultipartFile arquivo) {
		
		try {
			/* qual o intuito disso aqui? 
			 * copiar o arquivo via requisição para uma pasta definida
			 * e retornar o caminho dele. Se der qualquer erro retornar NULL
			 * */
			System.out.println("DEBUG -" + arquivo.getOriginalFilename());
			String caminho = "C:\\Users\\paulo\\Pictures\\images";
			Path path = Paths.get(caminho + File.separator + arquivo.getOriginalFilename());
			Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("DEBUG - Arquivo copiado...");
			return path.toString();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
}
