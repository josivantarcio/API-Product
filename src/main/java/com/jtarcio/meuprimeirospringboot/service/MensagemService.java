package com.jtarcio.meuprimeirospringboot.service;

import com.jtarcio.meuprimeirospringboot.repository.MensagemRepository;
import org.springframework.stereotype.Service;


@Service
public class MensagemService {
    private final MensagemRepository mensagemRepository;

    // Injeção de dependencia por construtor
    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String getMensagem() {
        return mensagemRepository.getMensagem();
    }

}

