package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.ProjectTag;
import com.nhnacademy.edu.taskapi.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
