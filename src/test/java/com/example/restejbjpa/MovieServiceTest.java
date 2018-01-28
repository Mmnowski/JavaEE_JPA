package com.example.restejbjpa;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.restejbjpa.domain.Movie;
import com.jayway.restassured.RestAssured;

public class MovieServiceTest{

  private static final String MOVIE_TITLE = "BRAINPOWER";
  private static final int MOVIE_YOR = 2137;
  private static final String MOVIE_DIRECTOR = "Mike Hawk";
  private static final int MOVIE_AMOUNT = 123;

  @BeforeClass
  public static void setUp(){
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = 8080;
    RestAssured.basePath = "/restejbjpa/api";
  }


  @Test
  public void addMovie(){

    delete("/movie/").then().assertThat().statusCode(200);

    Movie m1 = new Movie(MOVIE_TITLE, MOVIE_YOR, MOVIE_DIRECTOR, MOVIE_AMOUNT,null, null, null);

    given().
      contentType(MediaType.APPLICATION_JSON).
      body(m1).
      when().
      post("/movie/").then().assertThat().statusCode(201);
  }

}