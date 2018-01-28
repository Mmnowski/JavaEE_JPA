package com.example.restejbjpa.domain;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
		@NamedQuery(name = "movie.all", query = "Select m from Movie m"),
		@NamedQuery(name = "movie.deleteAll", query = "Delete from Movie "),
		@NamedQuery(name = "movie.findByYor", query = "Select b from Movie b where b.yearOfRelease = :yearOfRelease"),
		@NamedQuery(name = "movie.findByAuthorFirstName",
				query = "Select a.firstName, a.lastName, b.title, b.yearOfRelease from Movie b JOIN b.buyer a where a.firstName = :firstName")
})
@XmlRootElement
public class Movie {

	private Long id;
	private String Title = "";
	private int YearOfRelease;
	private String Director;
	private int Amount;

	private MovieCategory moviecategory;
	private Studio studio;
	private List<Buyer> buyer;

	public Movie(String title, int yearOfRelease, String director, int amount, MovieCategory moviecategory, Studio studio, List<Buyer> buyer) {
		Title = title;
		YearOfRelease = yearOfRelease;
		Director = director;
		Amount = amount;
		this.moviecategory = moviecategory;
		this.studio = studio;
		this.buyer = buyer;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public MovieCategory getMovieCategory(){return moviecategory;}
	public void setMovieCategory(MovieCategory mc){this.moviecategory = mc;}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Studio getStudio() {
		return studio;
	}
	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Buyer> getBuyer() {
		return buyer;
	}
	public void setBuyer(List<Buyer> buyer) {
		this.buyer = buyer;
	}



	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getYearOfRelease() {
		return YearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		YearOfRelease = yearOfRelease;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
