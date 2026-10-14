package aulas.aula9;

import java.util.HashSet;

class Aluno {

    int matricula;
    String nome;

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
    }

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

}

public class ExemploHashObjetos {

    public static void main(String[] args) {
        
        HashSet<Aluno> tabelHashAluno = new HashSet<>();

        tabelHashAluno.add(new Aluno(1, "alexandre"));
        tabelHashAluno.add(new Aluno(2, "hermes"));
        tabelHashAluno.add(new Aluno(3, "davi"));
        tabelHashAluno.add(new Aluno(2, "hermes"));

        for (Aluno a :tabelHashAluno){

            System.out.println(a);
            
        }


    }
    
}
