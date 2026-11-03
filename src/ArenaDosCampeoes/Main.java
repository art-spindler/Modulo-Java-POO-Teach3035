package ArenaDosCampeoes;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int lerInteiro(Scanner scan) { //usa try/catch pra escolhas com int

        while (true) {

            try {

                String entrada = scan.nextLine();

                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println("Digite apenas números!");

            }

        }
    }


    public static Inimigo gerarInimigo() { //gera inimigo aleatoriamente

        Random random = new Random();

        String[] nomes = { //nomes de inimigos aleatórios, com inspirações em outras obras
                "Zargor, o Orc",
                "Dragão Sombrio",
                "Goblin Assassino",
                "Cavaleiro Corrompido",
                "Lobo das Trevas",
                "Adão Esmagador",
                "Vergílio, a Tempestade",
                "Coringa, a carta",
                "Saruman, o mago das trevas",
                "Louva-a-deus psíquico"
        };

        int indice = random.nextInt(nomes.length);

        String nome = nomes[indice];

        int vida = random.nextInt(51) + 50;
        int ataque = random.nextInt(11) + 10;
        int defesa = random.nextInt(6) + 3;

        return new Inimigo(nome, vida, ataque, defesa); //criou inimigo
    }

    public static void exibirStatus(Personagem jogador, Personagem inimigo) { //exibe status da batalha

        System.out.println("\n========== ARENA ==========");
        System.out.println(jogador.nome + " | Vida: " + jogador.vida);
        System.out.println(inimigo.nome + " | Vida: " + inimigo.vida);
        System.out.println("===========================");
    }

    public static int turnoDoJogador(Personagem jogador, Personagem inimigo, Scanner scan,
                                      int pocoes) {
        int escolha;  // turno inteiro do jogador, com poçoes limitadas que são levadas de uma batalha a outra

        do {

            System.out.println("\nEscolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Usar Poção (" + pocoes + " restantes)");

            escolha = lerInteiro(scan);

            if (escolha < 1 || escolha > 3) {
                System.out.println("Opção inválida! Tente novamente.");
            }

            if (escolha == 3 && pocoes == 0) {
                System.out.println("Você não possui mais poções!");
                escolha = 0;
            }

        } while (escolha < 1 || escolha > 3);

        switch (escolha) {

            case 1:
                jogador.atacar(inimigo);
                break;

            case 2:
                jogador.defender();
                break;

            case 3:
                jogador.curar(20); //cura da poção e atualiza poções restantes
                pocoes--;
                break;
        }

        return pocoes;
    }

    public static void turnoDoInimigo(Personagem inimigo, Personagem jogador) { // turno do inimigo, com 75% de atacar

        int escolha = new java.util.Random().nextInt(4);

        if (escolha == 0) {

            inimigo.defender();

        } else {

            inimigo.atacar(jogador);

        }
    }

    public static int iniciarBatalha(Personagem jogador, Inimigo inimigo, Scanner scan, int pocoes) {
        //batalha com 1 inimigo

        System.out.println("\nInimigo encontrado: " + inimigo.nome);

        int turno = 1;

        while (jogador.estaVivo() && inimigo.estaVivo()) {

            System.out.println("\n===== TURNO " + turno + " =====");

            exibirStatus(jogador, inimigo); //status da batalha

            pocoes = turnoDoJogador(jogador, inimigo, scan, pocoes); // turno do jogador, pegando as poções

            if (inimigo.estaVivo()) { // inimigo
                turnoDoInimigo(inimigo, jogador);
            }

            turno++;
        }

        if (jogador.estaVivo()) {
            System.out.println("\nVocê venceu!");

        }

        return pocoes;
    }

    public static String mensagemDerrota(Personagem jogador) { //mensagem customizável de derrota, inspirada em um jogo-
        String nomeMaiusculo = jogador.nome.toUpperCase(); // -famoso, que na derrota, o nome do protagonista, Snake é-
        char vogalEncontrada = ' '; // -repetido 3 vezes
        int indiceVogal = -1;

        for (int i = 0; i < nomeMaiusculo.length(); i++) {
            char c = nomeMaiusculo.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vogalEncontrada = c;
                indiceVogal = i; //pega qual e onde a vogal foi encontrada
                break;
            }
        }

        if (indiceVogal != -1) {

            String parteAntes = nomeMaiusculo.substring(0, indiceVogal);

            String vogaisRepetidas = String.valueOf(vogalEncontrada).repeat(5); //repete a vogal 5 vezes

            String parteDepois = nomeMaiusculo.substring(indiceVogal + 1);

            String resultado = parteAntes + vogaisRepetidas + parteDepois; //pega o antes, a vogal, e depois e junta tudo

            return resultado;
        } else {
            return nomeMaiusculo;
        }

    }

    public static void iniciarArena(Personagem jogador, Scanner scan, ArrayList<Integer> ranking,
                                    ArrayList<String> rankingPersonagens) { //a arena completa

        int pocoes = 3;
        int vitorias = 0;

        while (jogador.estaVivo()) {

            System.out.println("\n===== BATALHA " + (vitorias + 1) + " ====="); //batalhas até perder

            Inimigo inimigo = gerarInimigo();

            pocoes = iniciarBatalha(jogador, inimigo, scan, pocoes);

            if (jogador.estaVivo()) {
                vitorias++;
                System.out.println("Vitórias: " + vitorias);
            }
        }

        System.out.println("\n" + jogador.nome +"? " + jogador.nome + "?! "+
                mensagemDerrota(jogador) + "!");
        System.out.println("\n == VOCÊ PERDEU! ==");
        System.out.println("Vitórias alcançadas: " + vitorias);


        ranking.add(vitorias);
        rankingPersonagens.add(jogador.nome);
    }

    public static void jogo (Scanner scan, ArrayList<Integer> ranking, ArrayList<String> rankingPersonagens){
        System.out.println("Bem-vindo à Arena dos Campeões!"); //menu de criação de personagem e início da arena

        System.out.print("Digite seu nome: ");

        String nome = scan.nextLine();

        System.out.println("\nEscolha sua classe:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");

        int escolha = lerInteiro(scan);

        Personagem jogador;

        switch (escolha) {

            case 1:
                jogador = new Guerreiro(nome);
                break;

            case 2:
                jogador = new Mago(nome);
                break;

            case 3:
                jogador = new Arqueiro(nome);
                break;

            default:
                System.out.println("Opção inválida!");
                scan.close();
                return;
        }

        System.out.println("\nVocê escolheu: " + jogador.nome);
        System.out.println("\n ======= Que a arena comece! =======");

        iniciarArena(jogador, scan, ranking, rankingPersonagens); //inicia arena

    }

    public static void exibirRanking(ArrayList<Integer> ranking, ArrayList<String> rankingPersonagens) { //ranking

        System.out.println("\n===== RANKING DE VITÓRIAS =====");

        for (int i = 0; i < ranking.size(); i++) {
            System.out.println("Guerreiro " + rankingPersonagens.get(i) + ": "
                    + ranking.get(i) + " vitórias");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> ranking = new ArrayList<>();
        ArrayList<String> rankingPersonagens = new ArrayList<>();

        int escolhamenu = 0;

        while (escolhamenu != 3) { //menu principal

            System.out.println("\n/// ARENA DOS CAMPEÕES ///");
            System.out.println("1 - Entrar na arena");
            System.out.println("2 - Ranking dos melhores guerreiros");
            System.out.println("3 - Sair");

            escolhamenu = lerInteiro(scan);

            if (escolhamenu == 1) {
                jogo(scan, ranking, rankingPersonagens);
            }
            else if (escolhamenu == 2) {
                exibirRanking(ranking, rankingPersonagens);
            }
            else if (escolhamenu == 3) {
                System.out.println("Saindo...");
            }
            else {
                System.out.println("Opção inválida!");
            }
        }

        scan.close();
    }

}


