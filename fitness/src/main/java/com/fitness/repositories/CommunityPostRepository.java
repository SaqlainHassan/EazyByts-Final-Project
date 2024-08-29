package com.fitness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.models.CommunityPost;

public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {

}
