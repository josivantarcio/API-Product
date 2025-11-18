package com.jtarcio.meuprimeirospringboot.controller;

import com.jtarcio.meuprimeirospringboot.service.MensagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping("/mensagem")
    public String getMensagem() {
        return mensagemService.getMensagem();
    }


}
