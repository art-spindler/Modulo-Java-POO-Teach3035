package ArenaDosCampeoes;
import java.util.ArrayList;
import java.util.List;

public class Personagem {

    protected String nome;
    protected int vida;
    protected int vidaMaxima;
    protected int ataque;
    protected int defesa;
    private boolean defendendo = false;

    protected List<String> inventario;

    public Personagem(String nome, int vida, int vidaMaxima, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;

        this.inventario = new ArrayList<>();
    }

    public void atacar(Personagem alvo) {

        int dano = calcularDano(alvo);

        System.out.println(this.nome + " atacou " + alvo.nome
                + " e causou " + dano + " de dano!");

        alvo.tomarDano(dano);
    }

    protected int calcularDano(Personagem alvo) {

        return Math.max(0, this.ataque - alvo.defesa);
    }


    public void defender() {

        defendendo = true;

        System.out.println(this.nome + " está se defendendo!");
    }

    public void tomarDano(int dano) {

        if (defendendo) {
            dano = dano / 2;
            defendendo = false;
        }

        vida = Math.max(0, vida - dano);

        System.out.println(this.nome + " perdeu " + dano + " de vida!");

    }

    public boolean estaVivo() {

        return vida > 0;

    }

    public void curar(int quantidade) {

        vida = Math.min(vidaMaxima, vida + quantidade);

        System.out.println(nome + " recuperou vida!");

    }

}
