package com.base.repository;

import com.base.common.BaseRepository;
import com.base.domain.lesson.Lesson;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends BaseRepository<Lesson> {

    List<Lesson> findByTitleContaining(String title);

}
