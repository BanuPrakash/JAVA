package com.adobe.prj.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;

	private String name;

	@Builder.Default
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movies_actors", 
		joinColumns = @JoinColumn(name = "mid"), 
		inverseJoinColumns = @JoinColumn(name = "aid"))
	private List<Actor> actors = new ArrayList<>();
}
