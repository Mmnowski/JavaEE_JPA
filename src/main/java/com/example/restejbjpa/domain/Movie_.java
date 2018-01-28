package com.example.restejbjpa.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Movie.class)
public class Movie_ {
    public static volatile SingularAttribute<Movie, String> title;
    public static volatile SingularAttribute<Movie, String> director;
    public static volatile SingularAttribute<Movie, Integer> amount;
    public static volatile SingularAttribute<Movie, Integer> yearOfRelease;
    public static volatile SingularAttribute<Movie, MovieCategory> moviecategory;
}
