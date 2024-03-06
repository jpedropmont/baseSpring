package com.base.domain.lesson;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    Lesson toEntity(LessonInput lessonInput);
    void toEntity(LessonInput input, @MappingTarget Lesson lesson);

}
