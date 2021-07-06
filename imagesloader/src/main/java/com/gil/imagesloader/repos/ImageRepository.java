package com.gil.imagesloader.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gil.imagesloader.entites.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
	List<Image> findByAlbumId(int albumId);
}
