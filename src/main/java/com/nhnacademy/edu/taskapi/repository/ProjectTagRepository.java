package com.nhnacademy.edu.taskapi.repository;

import com.nhnacademy.edu.taskapi.domain.tag.TagNameDto;
import com.nhnacademy.edu.taskapi.entity.ProjectTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectTagRepository extends JpaRepository<ProjectTag, ProjectTag.PK> {

    @Query("SELECT t.tagName as tagName FROM ProjectTag pt JOIN pt.tag t WHERE pt.pk.taskNumber = :taskNumber")
    List<TagNameDto> findTagNamesByTaskNumber(Long taskNumber);
}
