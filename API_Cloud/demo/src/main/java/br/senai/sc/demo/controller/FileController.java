package br.senai.sc.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/aws")
public class FileController {

    @PostMapping("/{id}/{idapontamento}")
    public void postAwsS3(@PathVariable Long id, @PathVariable Long idIdapontamento){

    }

}
