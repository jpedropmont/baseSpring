package com.riodevida.service;

import com.riodevida.common.BaseService;
import com.riodevida.domain.lesson.Lesson;
import com.riodevida.exceptions.NotFoundException;
import com.riodevida.repository.LessonRepository;
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
