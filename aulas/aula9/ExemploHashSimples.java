import java.util.HashSet;

public class ExemploHashSimples {

    public static void main(String[] args){

        HashSet<String> tableHashString = new HashSet<>();

        tableHashString.add ("Alexandre");
        tableHashString.add ("Hermes");
        tableHashString.add ("Davi");
        tableHashString.add ("Alan");
        tableHashString.add ("Alexandre");
        tableHashString.add ("Davi");

        for (String item : tableHashString){

            System.out.println(item + " -> " + item.hashCode());

        }

        System.out.println(tableHashString.contains("alan"));   
    }

}