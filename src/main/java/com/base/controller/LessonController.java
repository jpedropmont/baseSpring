package com.base.controller;

import com.base.domain.lesson.LessonMapper;
import com.base.domain.lesson.LessonInput;
import com.base.domain.lesson.LessonOutput;
import com.base.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lessons")
@CrossOrigin(origins = "http://localhost:3000")
public class LessonController {

    @Autowired
    private LessonService service;

    @Autowired
    private LessonMapper mapper;

    @GetMapping
    public ResponseEntity<List<LessonOutput>> getAll() {
        var lessons = service.getAll();
        var body = lessons.stream()
                .map(LessonOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(body);
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<LessonOutput>> getByTitle(@PathVariable String title) {
        var lessons = service.search(title);
        var body = lessons.stream()
                .map(LessonOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<LessonOutput> create(@RequestBody LessonInput input) {
        var lesson = mapper.toEntity(input);
        var newLesson = service.upsert(lesson);
        var body = new LessonOutput(newLesson);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonOutput> update(
            @PathVariable Long id,
            @RequestBody LessonInput input) {
        var lessonToUpdate = service.getById(id);
        mapper.toEntity(input, lessonToUpdate);
        var updatedLesson = service.upsert(lessonToUpdate);
        var body = new LessonOutput(updatedLesson);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LessonOutput> delete(@PathVariable Long id) {
        var lesson = service.getById(id);
        service.delete(id);
        var body = new LessonOutput(lesson);
        return ResponseEntity.ok(body);
    }
}
