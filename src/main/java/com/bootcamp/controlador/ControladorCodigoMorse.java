package com.bootcamp.controlador;

import com.bootcamp.modelo.DecodificadorCodigoMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorCodigoMorse {
    @GetMapping
    public String convert(@RequestParam("codigo") String codigo) {
        return "El código morse '" + codigo + "' decodificado es: '" + DecodificadorCodigoMorse.decodificar(codigo) + "'";
    }
}
