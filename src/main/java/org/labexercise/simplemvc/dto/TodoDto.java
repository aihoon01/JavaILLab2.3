package org.labexercise.simplemvc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDto {
    private Long id;
    private String title;
    private Boolean completed;
}
