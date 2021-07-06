package com.gil.imagesloader.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gil.imagesloader.entites.Image;

import lombok.Data;

//@Component
@Data
public class ImageList {
	
	@JsonProperty("images")
	private List<Image> images = new ArrayList<>();

}
