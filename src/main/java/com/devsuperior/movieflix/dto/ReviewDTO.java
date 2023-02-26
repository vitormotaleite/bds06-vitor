package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO {
	
	private Long id;
	private String text;
	private User user;
	private Long movieId;

	
	public ReviewDTO() {
		super();
	}

	
	public ReviewDTO(Long id, String text, User user, Long movieId) {
		super();
		this.id = id;
		this.text = text;
		this.user = user;
		this.movieId = movieId;
	}

	public ReviewDTO(Review entity) {
		this.id = entity.getId();
		this.text = entity.getText();
		this.user = entity.getUser();
		this.movieId = entity.getMovie().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

}
