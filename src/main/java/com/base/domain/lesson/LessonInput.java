package com.base.domain.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonInput {
    @NotBlank(message = "Title cannot be empty")
    @JsonProperty("title")
    private String title;

    @NotBlank(message = "Description cannot be empty")
    @JsonProperty("description")
    private String description;
}

