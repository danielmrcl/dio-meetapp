/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.danielmarcl.dio.meetapp.controller;

import dev.danielmarcl.dio.meetapp.model.Evento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author daniel
 */
@Named
@SessionScoped
public class EventoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Evento evento;
    
    private List<Evento> eventos = new ArrayList<>();

    public void cadastrarEvento() {
        String status;
        
        try {
            eventos.add(evento);
            
            status = String.format("Evento %s cadastrado com sucesso!", evento.getNome());
        } catch (Exception e) {
            status = "Ocorreu algum erro ao cadastrar!";
        } finally {
            evento = new Evento();
        }
        
        System.out.println(status);
    }
    
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
}
