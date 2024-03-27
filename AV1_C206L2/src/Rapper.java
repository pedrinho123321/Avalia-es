public class Rapper {

    String nome;
    int idade;
    double nota;
    Microfone mat;

    public Rapper(String nome, int idade, double nota, Microfone microfone) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
        this.mat = microfone;
    }

    public void mostrarInfo() {
        System.out.println("Nome do Rapper: " + nome);
        System.out.println("Idade do Rapper: " + idade);
        System.out.println("Nota de rima do Rapper: " + nota);
        System.out.println("O microfone do Rapper é de: " + mat.material);
        System.out.println("-----------------------------");
    }


}

