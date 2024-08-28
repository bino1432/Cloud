package br.senai.sc.demo.service.Interface;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileInterface {

    boolean create(Long id, MultipartFile file);
    List<String> buscarImagem(Long id);

}
