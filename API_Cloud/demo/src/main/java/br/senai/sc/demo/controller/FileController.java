package br.senai.sc.demo.controller;

import br.senai.sc.demo.Service.FileService;
import br.senai.sc.demo.controller.dto.FilePostDTO;
import br.senai.sc.demo.model.File;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/aws")
public class FileController {

    private FileService service;

    @PostMapping("/{id}")
    public boolean postAwsS3(@PathVariable Long id,@RequestBody MultipartFile file){
        return service.create(id, file);
    }

}
