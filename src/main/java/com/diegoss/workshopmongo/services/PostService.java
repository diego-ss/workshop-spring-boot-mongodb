package com.diegoss.workshopmongo.services;

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
}
