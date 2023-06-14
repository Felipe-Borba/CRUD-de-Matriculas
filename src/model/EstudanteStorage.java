package model;

import java.util.ArrayList;
import java.util.List;
public class EstudanteStorage {
    private static int incremento = 0;
    private static List<Estudante> estudantes = new ArrayList<>();

    public static void inserir(Estudante estudante) {
        estudante.setId(++incremento);
        estudantes.add(estudante);
    }

    public static void atualizar(Estudante estudante) {
        int i = estudantes.indexOf(estudante);
        if (i >= 0) {
            estudantes.set(i, estudante);
        }
    }

    public static void remover(Estudante estudante) {
        estudantes.remove(estudante);
    }

    public static List<Estudante> listar() {
        return estudantes;
    }
}
