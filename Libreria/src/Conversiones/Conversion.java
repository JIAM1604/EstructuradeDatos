package Conversiones;

/**
 * Created by Inspiron 15 3000 on 12/10/2020.
 */
public class Conversion {
    public String binario(int numero){
    int exp=0,digito;
    double binario= 0;
    while(numero!=0){
        digito = numero % 2;
        binario = binario + digito * Math.pow(10,exp);
        exp++;
        numero= numero/ 2;
    }
    return String.format("%.of %n",binario+"");
    }
    public String hex(int numero){
     return Integer.toHexString(numero);

    }
    public  String octal(int numero){
        return Integer.toOctalString(numero);

    }
    public  String conv(int numero,int base ){
        String dig= "ACDEF";
        String res= "";
        while (numero>0){
            int digito = numero % base;
                    res = dig.charAt(digito) + res;
            numero = numero/ base;
        }
        return res;
    }

}
