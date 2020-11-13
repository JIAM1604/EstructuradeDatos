/**
 * Created by Inspiron 15 3000 on 12/11/2020.
 */
public class Pez {
    private String tipo_pez;
    private  int por_nacimiento;
    private String pesca;
    private String pescado;
    private  String pescados;


    public Pez(String tipo_pez, int por_nacimiento,String pesca,String pescado,String pescados){
        this.tipo_pez = tipo_pez;
        this.por_nacimiento= por_nacimiento;
        this.pesca= pesca;
        this.pescado= pescado;
        this.pescados = pescados;
        return;
    }

    public String getTipo_pez() {
        return tipo_pez;
    }

    public void setTipo_pez(String tipo_pez) {
        this.tipo_pez = tipo_pez;
    }

    public int getPor_nacimiento() {
        return por_nacimiento;
    }

    public void setPor_nacimiento(int por_nacimiento) {
        this.por_nacimiento = por_nacimiento;
    }

    public String getPesca() {
        return pesca;
    }

    public void setPesca(String pesca) {
        this.pesca = pesca;
    }

    public String getPescado() {
        return pescado;
    }

    public void setPescado(String pescado) {
        this.pescado = pescado;
    }

    public String getPescados() {
        return pescados;
    }

    public void setPescados(String pescados) {
        this.pescados = pescados;
    }
}
