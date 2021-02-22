import presentacion.Modelo;


public class Launcher {

    private Modelo miApp;

    public Launcher() {
        miApp = new Modelo();
        this.miApp = miApp;
       // miApp.iniciar();
    }        
    
    public static void main(String[] args) {
        new Launcher();
    }
    
}
