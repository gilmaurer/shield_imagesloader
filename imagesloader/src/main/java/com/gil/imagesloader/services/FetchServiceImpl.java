package com.gil.imagesloader.services;

import static com.gil.imagesloader.exceptions.ErrorMessages.NOT_FOUND_BY_ID;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gil.imagesloader.entites.Image;
import com.gil.imagesloader.exceptions.DataNotFoundException;
import com.gil.imagesloader.repos.ImageRepository;

@Service
public class FetchServiceImpl implements FetchService {

	@Autowired
	ImageRepository imageRepository;

	@Override
	public List<Image> getAllImages() {
		return imageRepository.findAll();
	}

	@Override
	public List<Image> getImagesByAlbum(int albumId) {
		return imageRepository.findByAlbumId(albumId);
	}

	@Override
	public byte[] getImage(int id) throws IOException, DataNotFoundException {
		Image image = imageRepository.findById(id).orElseThrow(() -> new DataNotFoundException(NOT_FOUND_BY_ID, id));																									
		byte[] media = Files.readAllBytes(Path.of(image.getLocalPath()));
		return media;
	}

}
