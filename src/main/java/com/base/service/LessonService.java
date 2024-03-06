package com.base.service;

import com.base.common.BaseService;
import com.base.domain.lesson.Lesson;
import com.base.exceptions.NotFoundException;
import com.base.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService extends BaseService<Lesson, LessonRepository> {

    public List<Lesson> search(String title) {
        var lessons = repository.findByTitleContaining(title);
        if (lessons.size() == 0) {
            throw new NotFoundException("Lesson not found!");
        }
        return lessons;
    }

}
