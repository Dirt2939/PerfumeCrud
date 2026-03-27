package crud.perfume;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class TesteNumero {
    private static final ArrayList<String> perfumes = new ArrayList<>();
    private static final ArrayList<String> perfumesBack = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        // VALORES PADRÃO, CASO APENAS DESEJADO COMENTE
        Collections.addAll(perfumes, "Monroe", "Farenheint", "Blue Skye",
                "Mu'Lio Junpê", "Black Stone", "Diamond");

        do {
            System.out.println("\n========= Menu Perfume =========");
            System.out.println("[1] - Cadastrar perfume\n[2] - Alterar perfume\n" +
                    "[3] - Excluir perfume\n[4] - Listar perfume\n[5] - Quantidade de perfumes\n" +
                    "[6] - Limpar lista\n[7] - Pesquisar perfume\n[8] - Ordenar lista\n" +
                    "\n[0] - Sair\n");
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
                    default -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println("ERRO: " + e.getMessage());
            }
        } while (true);
    }

    public static void addPerfume() {
        System.out.println("\n========= Adicionar =========");
        System.out.println("Digite o nome do perfume: ");
        perfumes.add(sc.nextLine());

        System.out.println("Perfume adicionado com sucesso!");
    }

    public static int searchPerfume() {
        System.out.println("\n========= Pesquisa =========");
        System.out.println("Digite o nome do perfume para modificação: ");
        int index = perfumes.indexOf(sc.nextLine());

        if (index != -1) {
            return index;
        } else if (perfumes.isEmpty()) {
            throw new RuntimeException("Não há nenhum perfume");
        }
        throw new RuntimeException("Perfume não encontrado");
    }

    public static void updatePerfume() {
        int index = searchPerfume();
        System.out.println("\n========= Editar =========");
        System.out.println("Digite o novo nome do perfume: ");
        perfumes.set(index, sc.nextLine());

        System.out.println("Perfume modificado com sucesso!");
    }

    public static void deletePerfume() {
        int index = searchPerfume();
        System.out.println("\n========= Deletar =========");
        System.out.println("Tem certeza que deseja remover esse perfume?(s/n) ");
        switch (sc.nextLine()) {
            case "s", "sim" -> perfumes.remove(index);
            case "n", "nao" -> {
                return;
            }
            default -> System.out.println("Input inválido...");
        }
    }

    public static void showPerfumes() {
        if (perfumes.isEmpty()) {
            throw new RuntimeException("Não há nenhum perfume");
        } else {
            System.out.println("\n========= Perfumes =========");
            for (String p : perfumes) {
                System.out.println(p);
            }
        }
    }

    public static void showAmountPerfumes() {
        System.out.println("Atualmente se tem " + perfumes.size() + " perfumes");
    }

    public static void sortPerfumes() {
        if (perfumes.isEmpty()) {
            throw new RuntimeException("Não há nenhum perfume");
        }
        Collections.sort(perfumes);
        perfumesBack.addAll(perfumes);
        System.out.println("Agora os perfumes estão em ordem alfabética");
    }

    public static void isPerfume() {
        searchPerfume();
        System.out.println("Perfume existe");
    }

    public static void clearPerfumes() {
        perfumes.clear();
    }

}
