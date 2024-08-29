package com.fitness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.models.CommunityPost;
import com.fitness.repositories.CommunityPostRepository;


@Service
public class CommunityPostService {


	 	@Autowired
	    private CommunityPostRepository communityPostRepository;

	    public List<CommunityPost> getAllPosts() {
	        return communityPostRepository.findAll();
	    }

	    public CommunityPost getPostById(Long id) {
	        return communityPostRepository.findById(id).orElse(null);
	    }

	    public CommunityPost savePost(CommunityPost post) {
	        return communityPostRepository.save(post);
	    }

	    public void deletePost(Long id) {
	        communityPostRepository.deleteById(id);
	    }

	
}
