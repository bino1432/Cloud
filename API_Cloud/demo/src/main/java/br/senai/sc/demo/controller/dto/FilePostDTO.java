package br.senai.sc.demo.controller.dto;

import org.springframework.web.multipart.MultipartFile;

public record FilePostDTO(
    MultipartFile file
) {
}
