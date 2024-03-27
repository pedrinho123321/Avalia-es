import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arena arena = new Arena();

        boolean flag=true;

        while (flag) {

                System.out.println("\nMenu:");
                System.out.println("1) Adicionar rapper à arena");
                System.out.println("2) Mostrar informações da arena e seus rappers");
                System.out.println("3) Mostrar rappers com microfone dourado");
                System.out.println("4) Mostrar o ranking dos rappers");
                System.out.println("5) Sair");
                System.out.print("Escolha uma opção: ");
                System.out.print("");
                String opcao = scanner.nextLine();

                switch (opcao.toLowerCase()) {
                    case "1":
                        System.out.print("Nome do rapper: ");
                        String nomeRapper = scanner.nextLine();
                        System.out.print("Idade do rapper: ");
                        int idadeRapper = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nota de rima do rapper (de 0 a 10): ");
                        double notaRima = Double.parseDouble(scanner.nextLine());
                        System.out.print("Tipo de microfone do rapper (dourado, madeira ou plástico): ");
                        String tipoMicrofone = scanner.nextLine();
                        arena.addRapper(new Rapper(nomeRapper, idadeRapper, notaRima, new Microfone(tipoMicrofone)));
                        break;
                    case "2":
                        arena.mostraInfo();
                        break;
                    case "3":
                        arena.microfoneDou();
                        break;
                    case "4":
                        arena.ranking();
                        break;
                    case "5":
                        System.out.println("Encerrando programa...");
                        return;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                }
        }
    }
}
