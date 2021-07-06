package com.gil.imagesloader.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gil.imagesloader.beans.ImageList;
import com.gil.imagesloader.entites.Image;
import com.gil.imagesloader.repos.ImageRepository;
import com.gil.imagesloader.utils.Utils;

@Service
public class ImportServiceImpl implements ImportService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private ImageRepository imageRepository;
	
	private static final String URL = "https://shield-j-test.s3.amazonaws.com/photo.txt";
	
	@Override
	public List<Image> getImagesFromRemoteServer() throws JsonProcessingException {
		String res = restTemplate.getForObject(URL, String.class);
		String resAsJson = Utils.StringtoJsonString(res, "images");
		ImageList imageList = mapper.readValue(resAsJson, ImageList.class);
		return imageList.getImages();

	}

	@Override
	public void saveImagesToLocal(List<Image> imagesList) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		for(int i = 0 ; i < imagesList.size() ; i++) {
			
			Image image = imagesList.get(i);
			URL imageUrl = new URL(image.getUrl());
			String destinationFile = Utils.formatDestinition(image.getUrl(), image.getTitle());
			inputStream = imageUrl.openStream();
			outputStream = new FileOutputStream(destinationFile);
			byte[] byteArray = new byte[2048];
			int length;
			
			while ((length = inputStream.read(byteArray)) != -1) {
		          outputStream.write(byteArray, 0, length);   // Will write data to file byte by byte of size 2048
		    }
			image.setTimestamp(java.sql.Date.valueOf(LocalDate.now()));
			image.setLocalPath(destinationFile);
			image.setFileSize(Files.size(Path.of(destinationFile)));
			
		}
		
		inputStream.close();
		outputStream.close();
		
		
	}

	@Override
	public void saveDataToDB(List<Image> imagesList) {
		imageRepository.saveAll(imagesList);
	}

}
