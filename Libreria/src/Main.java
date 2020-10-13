import Conversiones.Conversion;

/**
 * Created by Inspiron 15 3000 on 12/10/2020.
 */
public class Main {
    public static void main(String[]args){
        Conversion conversion=new Conversion();
        String res= conversion.binario(2);
        System.out.println(res);
        res = conversion.hex(1);
        System.out.println(res);
    }
}
