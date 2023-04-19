package br.com.desafio.demo.Models;

import lombok.Data;

import java.util.Date;

@Data
public class PresidiarioModel {

    private String cpf;
    private String presidio;
    private String numeroRegistro;
    private Date dataNascimento;

}
