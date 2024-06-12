import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arquivo arquivo = new Arquivo();
        List<Aluno> alunos = new ArrayList<>();

        while (true) {
            System.out.println("1. Salvar aluno");
            System.out.println("2. Mostrar alunos");
            System.out.println("3. Ordenar alunos");
            System.out.println("4. Mostrar quantidade de alunos");
            System.out.println("5. Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do aluno:");
                    String nome = sc.nextLine();
                    System.out.println("Digite a matrícula do aluno:");
                    int matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o curso do aluno:");
                    String curso = sc.nextLine();
                    System.out.println("Digite a média do aluno:");
                    float media = sc.nextFloat();
                    sc.nextLine();

                    if (matricula <= 0 || (!curso.equals("Computação") && !curso.equals("Software") && !curso.equals("Telecomunicações"))) {
                        System.out.println("Informação inválida!");
                        break;
                    } else {
                        Aluno aluno = new Aluno(nome, matricula, curso, media);
                        alunos.add(aluno);
                        arquivo.escrever(aluno);
                    }
                    break;

                case 2:
                    alunos = arquivo.ler();
                    for (Aluno a : alunos) {
                        System.out.println("Nome: " + a.getNome() + ", Matrícula: " + a.getMatricula() + ", Curso: " + a.getCurso() + ", Média: " + a.getMedia());
                    }
                    break;

                case 3:
                    alunos.sort((a1, a2) -> Float.compare(a1.getMedia(), a2.getMedia()));
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("alunos.txt", false))) {
                        for (Aluno a : alunos) {
                            bw.write(a.getNome() + "," + a.getMatricula() + "," + a.getCurso() + "," + a.getMedia());
                            bw.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;


                case 4:
                    int computacao = 0, software = 0, telecomunicacoes = 0;
                    for (Aluno a : alunos) {
                        switch (a.getCurso()) {
                            case "Computação":
                                computacao++;
                                break;
                            case "Software":
                                software++;
                                break;
                            case "Telecomunicações":
                                telecomunicacoes++;
                                break;
                        }
                    }
                    System.out.println("Computação: " + computacao);
                    System.out.println("Software: " + software);
                    System.out.println("Telecomunicações: " + telecomunicacoes);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}