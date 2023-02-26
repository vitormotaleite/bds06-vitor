package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsuperior.movieflix.entities.Review;


public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	@Query("SELECT r FROM Review r " +
            "WHERE r.movie.id = :idMovie")
    List<Review> findByReviewMovieId(@Param("idMovie")Long idMovie);
}
