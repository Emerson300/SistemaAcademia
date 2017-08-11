/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author emerson
 */
public class Teste {
    private int id;
    private String nome,nomeProfessor,obs;
    private Date data;

    public Teste() {
    }
    

    public Teste(int id, String nome, String nomeProfessor, String obs, Date data) {
        this.id = id;
        this.nome = nome;
        this.nomeProfessor = nomeProfessor;
        this.obs = obs;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
    
    
    
    
}
