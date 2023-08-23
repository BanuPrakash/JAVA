package com.adobe.prj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Actor;
import com.adobe.prj.entity.Movie;
import com.adobe.prj.service.MovieService;

@Component
public class MovieClient implements CommandLineRunner {
	
	@Autowired
	MovieService service;
	
	@Override
	public void run(String... args) throws Exception {
		//addmovies();
		//addMovieOnly();
		assign();
	}

	private void assign() {
		service.assignActorToMovie(1, 2); // assign Uma to Kill Bill
	}

	private void addMovieOnly() {
		Movie m = Movie.builder().name("Kill Bill").build();
		service.addMovie(m);
	}

	private void addmovies() {
		Movie m = Movie.builder().name("Pulp Fiction").build();
		
		Actor a1 = Actor.builder().name("Uma Thurman").build();
		Actor a2 = Actor.builder().name("John Travolta").build();
		
		m.getActors().add(a1);
		m.getActors().add(a2);
		
		service.addMovie(m);
	}

}
