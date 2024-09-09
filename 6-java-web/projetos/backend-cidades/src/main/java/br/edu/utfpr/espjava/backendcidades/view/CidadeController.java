package br.edu.utfpr.espjava.backendcidades.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class CidadeController {

    @GetMapping("/")
    public String listar(Model memoria){

        var cidades = Set.of(
                new Cidade("Bauru", "São Paulo"),
                new Cidade("München", "Bayern"),
                new Cidade("Berlin", "Berlin")
        );

        memoria.addAttribute("listaCidades", cidades);

        return "/crud";
    }
}
