package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.entity.ProjectTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTagRepository extends JpaRepository<ProjectTag, ProjectTag.PK> {

}
