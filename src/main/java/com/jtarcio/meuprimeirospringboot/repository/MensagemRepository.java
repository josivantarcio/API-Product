package com.jtarcio.meuprimeirospringboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

    public String getMensagem() {
        return "Mensagem do repositório";
    }
}
