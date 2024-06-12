class Aluno {
    private String nome;
    private int matricula;
    private String curso;
    private float media;

    public Aluno(String nome, int matricula, String curso, float media) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public float getMedia() {
        return media;
    }
}