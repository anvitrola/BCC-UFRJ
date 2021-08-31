import java.util.ArrayList;
import java.util.HashSet;

public class SomaDoPar {
    HashSet<Integer> listaNumerica;
    /**
     * Percorre a lista dada para encontrar um par de elementos
     * cuja soma seja o valor desejado.
     *
     * @param numeros uma lista de inteiros
     * @param somaDesejada a soma desejada
     *
     * @return O menor dos elementos do par encontrado;
     *         ou null, caso nenhum par de elementos some o valor desejado
     */
    public static Integer encontrarParComSomaDada(
            ArrayList<Integer> numeros, int somaDesejada) {
        this.listaNumerica = new HashSet<>();
        listaNumerica.addAll(numeros);

     // Algoritmo ineficiente (quadrático):
       for (int i = 0; i < numeros.size(); i++) {
           for (int j = i + 1; j < numeros.size(); j++) {
                int x = numeros.get(i);
                int y = numeros.get(j);
                if (x + y == somaDesejada) {
                    return Math.min(x, y);
                }
           }
       }

     // Algoritmo eficiente (linear):
        for(int i = 0; i < numeros.size(); i++){
            int numeroComplementar = somaDesejada - numeros.get(i);

            if(this.listaNumerica.contains(numeroComplementar)){
                numeroComplementar < numeros.get(i)
                        ? return numeroComplementar
                    : return numeros.get(i)
            }
        }

        return null;
}
