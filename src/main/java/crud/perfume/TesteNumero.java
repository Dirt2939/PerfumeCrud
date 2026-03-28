package crud.perfume;

import java.util.*;

public class TesteNumero {
    private static final ArrayList<Perfume> perfumes = new ArrayList<>();
    private static final ArrayList<Perfume> perfumesBack = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        // VALORES PADRÃO, CASO DESEJADO APENAS COMENTE
       Collections.addAll(perfumes,
                new Perfume("Monroe"),
                new Perfume("Jason"),
                new Perfume("Chanel No. 5"),
                new Perfume("Sauvage"),
                new Perfume("One Million"),
                new Perfume("Acqua di Gio")
        );

        do {
            System.out.println("\n========= Menu Perfume =========");
            System.out.println("[1] - Cadastrar perfume\n" +
                               "[2] - Alterar perfume\n" +
                               "[3] - Excluir perfume\n" +
                               "[4] - Listar perfume \n" +
                               "[5] - Quantidade de perfumes\n" +
                               "[6] - Limpar lista\n" +
                               "[7] - Pesquisar perfume\n" +
                               "[8] - Ordenar lista\n" +
                               "[9] - Desordenar Lista\n\n" +
                               "[0] - Sair\n");
            try {
                int opt = sc.nextInt();
                sc.nextLine();
                switch (opt) {
                    case 1 -> addPerfume();
                    case 2 -> updatePerfume();
                    case 3 -> deletePerfume();
                    case 4 -> showPerfumes();
                    case 5 -> showAmountPerfumes();
                    case 6 -> clearPerfumes();
                    case 7 -> isPerfume();
                    case 8 -> sortPerfumes();
                    case 9 -> backPerfumes();
                    case 0 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Input inválido");
                    }
                }
            } catch (Exception e) {
                System.err.println("ERRO: " + e.getMessage());
                sc.nextLine();
            }
        } while (true);
    }

    public static void addPerfume() {
        System.out.println("\n========= Adicionar =========");
        System.out.println("Digite o nome do perfume: ");
        perfumes.add(new Perfume(sc.nextLine()));

        System.out.println("\nPerfume adicionado com sucesso!");
    }

    public static int searchPerfume() {
        System.out.println("\n========= Pesquisa =========");
        System.out.println("Digite o nome do perfume: ");
        String resp = sc.nextLine();

        int index = -1;

        for (int i = 0; i < perfumes.size(); i++) {
            if (perfumes.get(i).getNome().equalsIgnoreCase(resp)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            return index;
        } else if (perfumes.isEmpty()) {
            throw new RuntimeException("\nNão há nenhum perfume");
        }

        throw new RuntimeException("\nPerfume não encontrado");
    }
    
    public static void updatePerfume() {
        int index = searchPerfume();
        System.out.println("\n========= Editar =========");
        System.out.println("Digite o novo nome do perfume: ");
        perfumes.set(index, new Perfume(sc.nextLine()));

        System.out.println("\nPerfume modificado com sucesso!");
    }

    public static void deletePerfume() {
        int index = searchPerfume();
        System.out.println("\n========= Deletar =========");
        System.out.println("Tem certeza que deseja remover esse perfume?(s/n) ");
        switch (sc.nextLine()) {
            case "s", "sim" -> {
                perfumes.remove(index);
                System.out.println("\nPerfume removido com sucesso!");
            }
            case "n", "nao" -> {
                System.out.println("\nCancelando..,");
                return;
            }
            default -> System.out.println("\nInput inválido...");
        }
    }

    public static void showPerfumes() {
        if (perfumes.isEmpty()) {
            throw new RuntimeException("\nNão há nenhum perfume");
        } else {
            System.out.println("\n========= Perfumes =========");
            for (Perfume p : perfumes) {
                System.out.println(p.getNome());
            }
        }
    }

    public static void showAmountPerfumes() {
        System.out.println("\nAtualmente se tem " + perfumes.size() + " perfumes");
    }

    public static void sortPerfumes() {
        if (perfumes.isEmpty()) {
            throw new RuntimeException("\nNão há nenhum perfume");
        }
        perfumes.clear();
        perfumesBack.addAll(perfumes);
        perfumes.sort(Comparator.comparing(Perfume::getNome));
        System.out.println("\nAgora os perfumes estão em ordem alfabética!");
    }

    public static void isPerfume() {
        System.out.println("\nResultado da pesquisa: "+perfumes.get(searchPerfume()).getNome());
    }

    public static void clearPerfumes() {
        perfumes.clear();
        System.out.println("\nPerfumes removidos!");
    }

    public static void backPerfumes() {
        perfumes.clear();
        perfumes.addAll(perfumesBack);
        System.out.println("\nLista restaurada com sucesso!");
    }

}
