package br.senai.sc.demo.controller;

import br.senai.sc.demo.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/aws/file")
public class FileController {

    private FileService service;

    @PostMapping("/{id}")
    public ResponseEntity<Boolean> postAwsS3(@PathVariable Long id,@RequestBody MultipartFile file){
        return new ResponseEntity<>(
              service.create(id, file), HttpStatusCode.valueOf(200)
        );
    }

    @GetMapping("/{id}")
    public List<String> buscarImagem(@PathVariable Long id){
        return service.buscarImagem(id);

    }
}
