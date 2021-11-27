package com.diegoss.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegoss.workshopmongo.domain.Post;
import com.diegoss.workshopmongo.repositories.PostRepository;
import com.diegoss.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public PostService() {
		
	}
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id) {
		var Post = repository.findById(id);
		return Post.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String title){
		return repository.findByTitle(title);
	}
	
	public List<Post> findByArguments(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
