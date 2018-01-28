package com.example.restejbjpa.util;

import com.example.restejbjpa.domain.MovieCategory;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class MovieCategoryResponse {
	
	private List<MovieCategory> movieCategory = new ArrayList<>();

	public List<MovieCategory> getMovieCategory() {
		return movieCategory;
	}

	public void setMovieCategory(List<MovieCategory> movieCategory) {
		this.movieCategory = movieCategory;
	}
}
