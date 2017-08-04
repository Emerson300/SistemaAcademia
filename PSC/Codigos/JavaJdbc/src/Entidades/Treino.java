/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author emerson
 */
public class Treino {
    private int id;
    private String nome,cronograma;

    public Treino() {
        
    }
    
    public Treino(int id, String nome, String cronograma) {
        this.id = id;
        this.nome = nome;
        this.cronograma = cronograma;
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

    public String getCronograma() {
        return cronograma;
    }

    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }
    
}
