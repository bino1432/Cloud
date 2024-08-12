package br.senai.sc.demo.Service.Interface;

import br.senai.sc.demo.controller.dto.FilePostDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public interface FileInterface {

    boolean create(Long id, MultipartFile file);
    List<String> buscarImagem(Long id);

}
