package com.adobe.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.prj.entity.Actor;

public interface ActorDao extends JpaRepository<Actor, Integer> {

}
