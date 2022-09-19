package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Image;

@Repository 
public interface ImageRepo extends JpaRepository<Image, Integer> {

}
