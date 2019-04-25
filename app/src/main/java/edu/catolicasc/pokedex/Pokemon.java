package edu.catolicasc.pokedex;

public class Pokemon {

    private int id;
    private String nome;
    private double peso;
    private double altura;
    private String imgUrl;

    public Pokemon(int id, String nome, double peso, double altura, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.imgUrl = imgUrl;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
