package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Login {
String[][] login={{"usuario1","usuario2","usuario3","usuario4","usuario5"},{"12345","54321","43215","32154","21543"}};
    @FXML TextField usuario,contrasena;
    public void ingresar(){
        String usu,con;
        usu=usuario.getText();
        con=contrasena.getText();
        int n = login[0].length;
        int centro,inf=0,sup=n-1;
        while(inf<=sup){
            centro=(sup+inf)/2;
            if(login[0][centro].equals(usu)){
                if(login[1][centro].equals(con)){
                    try{
                        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                        Scene scene=new Scene(root);
                        Main.stage.setScene(scene);
                        break;
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                }
            } else if(usu.compareTo(login[0][centro])<0){
                sup=centro-1;
            }
            else {
                inf=centro+1;
            }
        }
    }
}
