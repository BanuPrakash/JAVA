package com.adobe.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.prj.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Integer> {

}
