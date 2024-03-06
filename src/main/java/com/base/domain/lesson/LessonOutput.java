package com.base.domain.lesson;

import java.util.Date;

public record LessonOutput(Long id, String title, String description, Date created_at, Date updated_at) {
    public LessonOutput(Lesson lesson) {
        this(lesson.getId(), lesson.getTitle(), lesson.getDescription(), lesson.getCreatedAt(), lesson.getUpdatedAt());
    }
}
