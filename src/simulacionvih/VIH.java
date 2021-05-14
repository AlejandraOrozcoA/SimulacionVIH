
package simulacionvih;

public class VIH {
    private int alto;
    private int ancho;
    private char actual[][];
    private char siguiente[][];
    
    public VIH(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        actual = new char [alto][ancho];
        siguiente= new char [alto][ancho];
        llenar();
    }

    public char getActual(int x, int y) {
        return actual[y][x];
    }

    public void setActual(int x, int y, char l) {
        this.actual[y][x]= l;
    }

    public char getSiguiente(int x, int y) {
        return siguiente [y][x];
    }

    public void setSiguiente(int x, int y, char l) {
        this.siguiente[y][x]= l;
    }

    private void llenar() {
        for (int i = 0; i < alto ; i++) {
            for (int j = 0; j < ancho ; j++) {
                actual[i][j]= 'H';
                siguiente[i][j]= 'H';
            }
        }
    }
    
   
}
