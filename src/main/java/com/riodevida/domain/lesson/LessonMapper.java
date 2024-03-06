package com.riodevida.domain.lesson;

import com.riodevida.domain.lesson.Lesson;
import com.riodevida.domain.lesson.LessonInput;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    Lesson toEntity(LessonInput lessonInput);
    void toEntity(LessonInput input, @MappingTarget Lesson lesson);

}
