package br.com.desafio.demo.Models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class PresidioModel {

    private List <PresidiarioModel> presidiarioModelList = new ArrayList<>();
    private String nomePresidio;
    private Integer codigoPresidio;

    public PresidioModel(Integer codigoPresidio) {
    }


    public Collection<PresidiarioModel> getListaPresidiarios() {

    }


}
