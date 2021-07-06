package com.gil.imagesloader.inital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.gil.imagesloader.entites.Image;
import com.gil.imagesloader.services.ImportService;

@Component
@Order(1)
public class Initialize implements CommandLineRunner {

	@Autowired
	private ImportService importService;
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Image> imagesList = importService.getImagesFromRemoteServer();
		importService.saveImagesToLocal(imagesList);
		importService.saveDataToDB(imagesList);

	}

}
