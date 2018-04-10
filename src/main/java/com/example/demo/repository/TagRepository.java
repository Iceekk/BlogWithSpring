package com.example.demo.repository;

import com.example.demo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ico on 4/10/2018.
 */
public interface TagRepository extends JpaRepository<Tag, Integer>{
    Tag findByName(String name);
}
