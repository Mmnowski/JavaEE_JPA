package com.example.restejbjpa.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.restejbjpa.domain.Movie;

@XmlRootElement
public class MovieResponse {
	
	private List<Movie> movie = new ArrayList<>();

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
}
