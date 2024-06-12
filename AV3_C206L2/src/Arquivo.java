import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

class Arquivo {
    public void escrever(Aluno aluno) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("alunos.txt", true))) {
            bw.write(aluno.getNome() + "," + aluno.getMatricula() + "," + aluno.getCurso() + "," + aluno.getMedia());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public List<Aluno> ler() {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("alunos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                int matricula = Integer.parseInt(partes[1]);
                String curso = partes[2];
                float media = Float.parseFloat(partes[3]);
                alunos.add(new Aluno(nome, matricula, curso, media));
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return alunos;
    }
}