package Exercicios1.Exercicio1;

public class Carro {

    private String modelo;
    private int ano;
    private String marca;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getDescricao() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano;
    }
}