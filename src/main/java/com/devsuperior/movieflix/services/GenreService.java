package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;

	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
	public List<GenreDTO> findAll() {
		List<Genre> list = genreRepository.findAll();
		return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
	public GenreDTO findById(Long id) {
		Optional<Genre> categoryObj = genreRepository.findById(id);
		Genre client = categoryObj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return new GenreDTO(client);
	}
}
