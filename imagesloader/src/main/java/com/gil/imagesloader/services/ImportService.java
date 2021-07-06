package com.gil.imagesloader.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gil.imagesloader.entites.Image;

public interface ImportService {
	List<Image> getImagesFromRemoteServer() throws JsonMappingException, JsonProcessingException;
	void saveImagesToLocal(List<Image> imagesList) throws MalformedURLException, IOException;
	void saveDataToDB(List<Image> imagesList);

}
