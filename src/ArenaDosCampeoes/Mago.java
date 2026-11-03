package ArenaDosCampeoes;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 80, 80,25, 4);
    }

    @Override
    protected int calcularDano(Personagem alvo) {

        return super.calcularDano(alvo) + 8;
    }


}
