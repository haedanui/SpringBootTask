package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.domain.tag.TagNameDto;
import com.nhnacademy.edu.taskapi.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<TagNameDto> findBy();

    List<TagNameDto> findByProjectProjectId(Long projectId);



}
