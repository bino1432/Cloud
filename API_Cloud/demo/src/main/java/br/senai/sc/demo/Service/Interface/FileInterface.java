package br.senai.sc.demo.Service.Interface;

import br.senai.sc.demo.controller.dto.FilePostDTO;
import org.springframework.web.multipart.MultipartFile;

public interface FileInterface {

    boolean create(Long id, MultipartFile file);
    String buscarImagem(Long id);

}
