package br.com.desafio.demo.Services;

import br.com.desafio.demo.Models.PresidiarioModel;
import br.com.desafio.demo.Models.PresidioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class PresidiarioService {


        private List<PresidiarioModel> listaDePresidiarios = new ArrayList<>();

        public void adicionar(PresidiarioModel presidiarioSalvo){

            listaDePresidiarios.add(presidiarioSalvo);

        }

        public List<PresidiarioModel> listaTodos(){
            return listaDePresidiarios;

        }
        public PresidiarioModel buscarPorResgistro(Integer registro){
            return listaDePresidiarios.stream().filter(p-> registro.equals(p.getNumeroRegistro())).findFirst().orElseThrow();

        }

    public PresidioModel buscarPorPresidio() {
            return null;
    }

    public void remove(String registro) {
    }

}
