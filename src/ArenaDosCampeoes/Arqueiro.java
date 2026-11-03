package ArenaDosCampeoes;

public class Arqueiro extends Personagem {

    public Arqueiro(String nome) {
        super(nome, 95, 95,22, 6);
    }

    @Override
    protected int calcularDano(Personagem alvo) {

        return super.calcularDano(alvo) + 4;
    }

}
