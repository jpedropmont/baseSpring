package com.riodevida.repository;

import com.riodevida.common.BaseRepository;
import com.riodevida.domain.lesson.Lesson;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends BaseRepository<Lesson> {

    List<Lesson> findByTitleContaining(String title);

}
