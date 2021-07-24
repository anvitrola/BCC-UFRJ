import java.util.*;

public class Principal {

    public static int obterArmariosAbertos(int n) { // simulação
        // false: armário fechado && true: armário aberto
        boolean[] armarios = new boolean[n + 1];

        for (int crianca = 1; crianca <= n; crianca++) { // x crianças para n armários, sendo x=n
            for (int armario = 1; armario <= n; armario++) { // cada criança percorrerá todos os armários, que é n
                if (armario % crianca == 0) {
                    armarios[armario] = !armarios[armario];
                }
            }
        }

        ArrayList<Integer> armariosAbertos = new ArrayList<>();

        for (int armario = 1; armario <= n; armario++) {
            if (armarios[armario]) {
                armariosAbertos.add(armario);
            }
        }

        return armariosAbertos.size();
    }

    public static int obterRaizQuadrada(int n) { // porque todos os quadrados perfeitos possuem um número ímpar de
                                                 // divisores.
        return (int) Math.sqrt(n);
    }
    public static void main(String[] args) {
        System.out.println("Quantos armários? ");
        Scanner scan = new Scanner(System.in);
        
        int qtdArmarios = scan.nextInt();
        int contArmariosAbertos = obterArmariosAbertos(qtdArmarios);
        
        System.out.println("Quantidade de armários abertos: " + contArmariosAbertos);
        scan.close();
    }
}
