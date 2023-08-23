package com.adobe.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.ActorDao;
import com.adobe.prj.dao.MovieDao;
import com.adobe.prj.entity.Actor;
import com.adobe.prj.entity.Movie;

import jakarta.transaction.Transactional;

@Service
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private ActorDao actorDao;
	
	public void addMovie(Movie m) {
		movieDao.save(m);
	}
	
	public void addActor(Actor a) {
		actorDao.save(a);
	}
	
	@Transactional
	public void assignActorToMovie(int aid, int mid) {
		Actor a = actorDao.findById(aid).get();
		Movie m = movieDao.findById(mid).get();
		m.getActors().add(a); // dirty checking --> update database
	}
}
