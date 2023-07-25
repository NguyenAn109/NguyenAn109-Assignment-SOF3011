package com.assignment.model;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String fullname;
	private String email;
	private String password;
	private boolean status;
	private String avata;
	private String viewedMovies;
	private String favoriteMovies;

	public User(String id, String fullname, String email, String password, boolean status, String avata,
			String viewedMovies, String favoriteMovies) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.status = status;
		this.avata = avata;
		this.viewedMovies = viewedMovies;
		this.favoriteMovies = favoriteMovies;
	}

	public User() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAvata() {
		return avata;
	}

	public void setAvata(String avata) {
		this.avata = avata;
	}

	public String getViewedMovies() {
		return viewedMovies;
	}

	public void setViewedMovies(String viewedMovies) {
		this.viewedMovies = viewedMovies;
	}

	public String getFavoriteMovies() {
		return favoriteMovies;
	}

	public void setFavoriteMovies(String favoriteMovies) {
		this.favoriteMovies = favoriteMovies;
	}

}
