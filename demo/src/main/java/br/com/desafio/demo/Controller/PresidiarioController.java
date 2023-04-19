package br.com.desafio.demo.Controller;

import br.com.desafio.demo.Models.PresidiarioModel;
import br.com.desafio.demo.Models.PresidioModel;
import br.com.desafio.demo.Services.PresidiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PresidiarioController {
    @Autowired
    private PresidiarioService service;

        //USANDO GET...

    @PostMapping(value = "/presidiario/novo")
    public ResponseEntity novoPresidiario(@RequestBody PresidiarioModel presidiarioModel,
                                          @RequestParam Integer codigoPresidio) {
        // busco presidio q ele pertence
        PresidioModel p = service.buscarPorPresidio();
        p.getListaPresidiarios().add(presidiarioModel);// pego a lista e adiciona o presidiario
        presidiarioModel.setPresidio(String.valueOf(new PresidioModel(codigoPresidio)));
        service.adicionar(presidiarioModel);
        return new ResponseEntity(presidiarioModel + " " + codigoPresidio, HttpStatus.CREATED);
    }

    private String presidio(Integer codigoPresidio) {
        return null;
    }

    @GetMapping(value = "/presidiarios")
    public ResponseEntity ListarTodos(){
        return new ResponseEntity(service.listaTodos(),HttpStatus.OK);

    }


    @GetMapping(value = "/presidiario/{resgistro}")
    public ResponseEntity ListarPorRegistro(@PathVariable Integer registro){

        PresidiarioModel Preso = service.buscarPorResgistro(registro);
        if (Preso == null){
            return new ResponseEntity<>("registro invalido", HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity( Preso,HttpStatus.OK);



    }
    @DeleteMapping(value = "/deletar/{registro}")
    public ResponseEntity deletar(@PathVariable String registro){
        service.remove(registro);
        return  new ResponseEntity(HttpStatus.OK);
    }


}


