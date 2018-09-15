package com.company.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
