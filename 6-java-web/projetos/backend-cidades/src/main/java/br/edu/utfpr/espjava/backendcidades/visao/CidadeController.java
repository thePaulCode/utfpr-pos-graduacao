package br.edu.utfpr.espjava.backendcidades.visao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/api/v1")
public class CidadeController {

    @GetMapping
    public String listar(){
        return "crud.html";
    }
}
