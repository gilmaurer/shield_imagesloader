package com.gil.imagesloader.services;

import java.io.IOException;
import java.util.List;

import com.gil.imagesloader.entites.Image;
import com.gil.imagesloader.exceptions.DataNotFoundException;

public interface FetchService {
	
	List<Image> getAllImages();

	List<Image> getImagesByAlbum(int albumId);

	byte[] getImage(int id) throws IOException, DataNotFoundException;

}
