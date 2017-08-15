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
public class Avaliacao {
    private String nome,bracoDir,bracoEsq,antiBracoDir,antiBracoEsq,pernaDir,pernaEsq,coxaDir,coxaEsq,Abdomen,
                  cintura,quadril,subescapular,triceps,suprailiaca,abdomenDobra,radio,femur,obs;
    private int id;
    private float altura,peso,imc;
   
    public Avaliacao() {
        
    }

    public Avaliacao(String nome, String bracoDir, String bracoEsq, String antiBracoDir, String antiBracoEsq, String pernaDir, String pernaEsq, String coxaDir, String coxaEsq, String Abdomen, String cintura, String quadril, String subescapular, String triceps, String suprailiaca, String abdomenDobra, String radio, String femur, String obs, int id, float altura, float peso) {
        this.nome = nome;
        this.bracoDir = bracoDir;
        this.bracoEsq = bracoEsq;
        this.antiBracoDir = antiBracoDir;
        this.antiBracoEsq = antiBracoEsq;
        this.pernaDir = pernaDir;
        this.pernaEsq = pernaEsq;
        this.coxaDir = coxaDir;
        this.coxaEsq = coxaEsq;
        this.Abdomen = Abdomen;
        this.cintura = cintura;
        this.quadril = quadril;
        this.subescapular = subescapular;
        this.triceps = triceps;
        this.suprailiaca = suprailiaca;
        this.abdomenDobra = abdomenDobra;
        this.radio = radio;
        this.femur = femur;
        this.obs = obs;
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBracoDir() {
        return bracoDir;
    }

    public void setBracoDir(String bracoDir) {
        this.bracoDir = bracoDir;
    }

    public String getBracoEsq() {
        return bracoEsq;
    }

    public void setBracoEsq(String bracoEsq) {
        this.bracoEsq = bracoEsq;
    }

    public String getAntiBracoDir() {
        return antiBracoDir;
    }

    public void setAntiBracoDir(String antiBracoDir) {
        this.antiBracoDir = antiBracoDir;
    }

    public String getAntiBracoEsq() {
        return antiBracoEsq;
    }

    public void setAntiBracoEsq(String antiBracoEsq) {
        this.antiBracoEsq = antiBracoEsq;
    }

    public String getPernaDir() {
        return pernaDir;
    }

    public void setPernaDir(String pernaDir) {
        this.pernaDir = pernaDir;
    }

    public String getPernaEsq() {
        return pernaEsq;
    }

    public void setPernaEsq(String pernaEsq) {
        this.pernaEsq = pernaEsq;
    }

    public String getCoxaDir() {
        return coxaDir;
    }

    public void setCoxaDir(String coxaDir) {
        this.coxaDir = coxaDir;
    }

    public String getCoxaEsq() {
        return coxaEsq;
    }

    public void setCoxaEsq(String coxaEsq) {
        this.coxaEsq = coxaEsq;
    }

    public String getAbdomen() {
        return Abdomen;
    }

    public void setAbdomen(String Abdomen) {
        this.Abdomen = Abdomen;
    }

    public String getCintura() {
        return cintura;
    }

    public void setCintura(String cintura) {
        this.cintura = cintura;
    }

    public String getQuadril() {
        return quadril;
    }

    public void setQuadril(String quadril) {
        this.quadril = quadril;
    }

    public String getSubescapular() {
        return subescapular;
    }

    public void setSubescapular(String subescapular) {
        this.subescapular = subescapular;
    }

    public String getTriceps() {
        return triceps;
    }

    public void setTriceps(String triceps) {
        this.triceps = triceps;
    }

    public String getSuprailiaca() {
        return suprailiaca;
    }

    public void setSuprailiaca(String suprailiaca) {
        this.suprailiaca = suprailiaca;
    }

    public String getAbdomenDobra() {
        return abdomenDobra;
    }

    public void setAbdomenDobra(String abdomenDobra) {
        this.abdomenDobra = abdomenDobra;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getFemur() {
        return femur;
    }

    public void setFemur(String femur) {
        this.femur = femur;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

}
