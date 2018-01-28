package com.example.restejbjpa;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import javax.ws.rs.core.MediaType;

import com.example.restejbjpa.domain.Movie;
import com.example.restejbjpa.domain.Buyer;
import com.example.restejbjpa.domain.MovieCategory;
import com.example.restejbjpa.domain.Studio;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MovieServiceTest{

  private static final String MOVIE_TITLE = "BRAINPOWER";
  private static final int MOVIE_YOR = 2137;
  private static final String MOVIE_DIRECTOR = "Mike Hawk";
  private static final int MOVIE_AMOUNT = 123;

  private static final String MOVIE_GENRE = "Horror";
  private static final boolean MOVIE_IS_ADULT = true;
  private static final boolean MOVIE_IS_THREE_DIM = true;

  private static final String STUDIO_NAME = "Walt Disney";
  private static final String STUDIO_COUNTRY = "France";

  private static final String BUYER_FIRSTNAME = "Ralph";
  private static final String BUYER_LASTNAME = "Fitzner";
  private static final int BUYER_AGE = 22;

  @BeforeClass
  public static void setUp(){
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = 8080;
    RestAssured.basePath = "/restejbjpa/api";
  }


  @Test
  public void addMovieCategory() {
////  Delete test
//    delete("/category/").then().assertThat().statusCode(200);

    MovieCategory mc = new MovieCategory(MOVIE_GENRE, MOVIE_IS_ADULT, MOVIE_IS_THREE_DIM);

    given().
            contentType(MediaType.APPLICATION_JSON).
            body(mc).
            when().
            post("/category").then().assertThat().statusCode(201);

  }

  @Test
  public void addBuyer() {
////  Delete test
//    delete("/buyer/").then().assertThat().statusCode(200);
    Buyer b = new Buyer(BUYER_FIRSTNAME, BUYER_LASTNAME, BUYER_AGE);

    given().
            contentType(MediaType.APPLICATION_JSON).
            body(b).
            when().
            post("/buyer").then().assertThat().statusCode(201);
  }

  @Test
  public void addStudio() {
////  Delete test
//    delete("/studio/").then().assertThat().statusCode(200);

    Studio s = new Studio(STUDIO_NAME,STUDIO_COUNTRY);

    given().
            contentType(MediaType.APPLICATION_JSON).
            body(s).
            when().
            post("/studio").then().assertThat().statusCode(201);

  }

  @Test
  public void addGame() {
////  Delete test
//    delete("/movie/").then().assertThat().statusCode(200);

    MovieCategory mc = new MovieCategory(MOVIE_GENRE, MOVIE_IS_ADULT, MOVIE_IS_THREE_DIM);
    Studio s = new Studio(STUDIO_NAME,STUDIO_COUNTRY);
    Buyer b1 = new Buyer(BUYER_FIRSTNAME, BUYER_LASTNAME, BUYER_AGE);
    Buyer b2 = new Buyer(BUYER_FIRSTNAME, BUYER_LASTNAME, BUYER_AGE);

    List<Buyer> buyers = new ArrayList<>();
    buyers.add(b1);
    buyers.add(b2);

    Movie m = new Movie(MOVIE_TITLE, MOVIE_YOR, MOVIE_DIRECTOR, MOVIE_AMOUNT, mc, s, buyers);

    given().
            contentType(MediaType.APPLICATION_JSON).
            body(m).
            when().
            post("/movie").then().assertThat().statusCode(201);
  }
}