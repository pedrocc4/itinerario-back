package com.bosonit.backend.app.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Multip {
    private MultipartFile file;
}
