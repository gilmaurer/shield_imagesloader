package com.gil.imagesloader.controllers;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gil.imagesloader.exceptions.DataNotFoundException;
import com.gil.imagesloader.services.FetchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
	
	private final FetchService fetchService;
	
	@GetMapping()
	public ResponseEntity<?> getAllImages() {
		return new ResponseEntity<>(fetchService.getAllImages(), HttpStatus.OK);
	}
	
	@GetMapping("/albums/{albumId}")
	public ResponseEntity<?> getAlbumImages(@PathVariable int albumId) {
			return new ResponseEntity<>(fetchService.getImagesByAlbum(albumId), HttpStatus.OK);	
	}
	
	@GetMapping("/{imageId}")
	public ResponseEntity<byte[]> getImage(@PathVariable int imageId) throws IOException, DataNotFoundException {
	    byte[] media = fetchService.getImage(imageId);
		return new ResponseEntity<>(media, HttpStatus.OK);
	}
	
}
