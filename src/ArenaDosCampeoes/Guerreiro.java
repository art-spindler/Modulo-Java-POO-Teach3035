package ArenaDosCampeoes;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 120, 120, 20, 10);
    }

    @Override
    protected int calcularDano(Personagem alvo) {

        return super.calcularDano(alvo) + 5;
    }

}
