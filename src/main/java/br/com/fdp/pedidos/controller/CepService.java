package br.com.fdp.pedidos.controller;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import br.com.fdp.pedidos.model.Endereco;
import br.com.fdp.pedidos.service.CepWebService;
@Named
public class CepService {


    public Endereco encontraCEP(String cep) {
        CepWebService cepWebService = new CepWebService(cep);
        
        Endereco endereco = new Endereco();
        

        if (cepWebService.getResultado() == 1) {
            //setTipoLogradouro(cepWebService.getTipoLogradouro());
            endereco.setLogradouro(cepWebService.getLogradouro());
            endereco.setComplemento(cepWebService.getComplemento());
            endereco.setCidade(cepWebService.getCidade());
            endereco.setBairro(cepWebService.getBairro());
          return endereco;
        } else {
            return null;
        }
    }


}
