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
public class Mensalidade {
    private int id;
    private float valor;
    private String nome,obs;
    private Date data;

    public Mensalidade() {
    }

    public Mensalidade(int id, float valor, String nome, String obs, Date data) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.obs = obs;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
