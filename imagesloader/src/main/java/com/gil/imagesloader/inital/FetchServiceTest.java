package com.gil.imagesloader.inital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.gil.imagesloader.entites.Image;
import com.gil.imagesloader.services.FetchService;


@Component
@Order(2)
public class FetchServiceTest implements CommandLineRunner {

	@Autowired
	FetchService fetchService;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("****** Fetch Service Test*********");
		
		System.out.println("****** getAllImages() *********");
		List<Image> images = fetchService.getAllImages();
		images.forEach(System.out::println);
		
		
		System.out.println("****** getImagesByAlbum(1) *********");
		List<Image> imagesByAlbum = fetchService.getImagesByAlbum(1);
		imagesByAlbum.forEach(System.out::println);
		

	}

}
