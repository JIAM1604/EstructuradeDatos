/**
 * Created by Inspiron 15 3000 on 26/10/2020.
 */
public class Principal {

    public static void main(String[] arg){
        int[] arreglo1={1,2,5,8,4};
        String[] array2=new String[10];
        int suma = 0;

        for( int a=0;a< arreglo1.length; a++){
            suma= suma+arreglo1[a];

        } //Llave for
        System.out.println(suma);

        int[][] arreglo2= {
                {1, 6, 5, 8, 7},
                {0, 5, 8, 6, 5},
                {5, 8, 7, 2, 3},

        };
        for (int x=0;x<arreglo2.length;x++){
            for (int y=0; y<arreglo2[x].length;y++) {
                System.out.println(arreglo2[x][y]);
            }
        }

    }//Llave static void main


} //Llave public class Principal
