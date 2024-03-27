class Arena {
    String nome;
    String lugar;
    Rapper[] rappers;
    int contador;

    public Arena() {
        this.nome = "Arena Rap";
        this.lugar = "Local da Arena";
        this.rappers = new Rapper[100];
        this.contador = 0;
    }

    public void addRapper(Rapper rapper) {
        if (contador < rappers.length) {
            rappers[contador++] = rapper;
            System.out.println("Rapper adicionado à arena com sucesso!!!!");
        } else {
            System.out.println("Infelizmente atingimos o limite de Rappers de hj.");
        }
    }

    public void mostraInfo() {
        System.out.println("Informações da Arena:");
        System.out.println("Nome da Arena: " + nome);
        System.out.println("Local da Arena: " + lugar);
        System.out.println("Número total de rappers: " + contador);
        for (int i = 0; i < contador; i++) {
            rappers[i].mostrarInfo();
        }
    }

    public void microfoneDou() {
        System.out.println("Rappers com microfone dourado:");
        for (int i = 0; i < contador; i++) {
            if (rappers[i].mat.material.equalsIgnoreCase("dourado")) {
                rappers[i].mostrarInfo();
            }
        }
    }

    public void ranking() {
        System.out.println("Ranking dos Rappers:");
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {
                if (rappers[j].nota < rappers[j + 1].nota) {
                    Rapper temp = rappers[j];
                    rappers[j] = rappers[j + 1];
                    rappers[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". " + rappers[i].nome + " - Nota: " + rappers[i].nota);
        }
    }
}