
package simulacionvih;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class VIH {
    private final int rb = 4;
    private final int lag = 4;
    private final int prepl = 99;
    private final int pinfect = 10000;
    private final int pvih = 5;
    private int alto;
    private int ancho;
    private char actual[][];
    private char siguiente[][];
    private int lagActual [][];

    
    public VIH(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        actual = new char [alto][ancho];
        siguiente= new char [alto][ancho];
        lagActual = new int [alto][ancho];
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

    public int getLagActual(int x, int y) {
        return lagActual[y][x];
    }

    public void setLagActual(int x, int y, boolean bandera) {
        if (bandera) {
            lagActual[y][x] = lagActual[y][x]+1;
        }else {
            lagActual[y][x]= 0;
        }
    }
    
    //Inicializa los arreglos actual y siguiente
    public void llenar() {
        for (int i = 0; i < alto ; i++) {
            for (int j = 0; j < ancho ; j++) {
                this.setActual(j, i, 'H');
                this.setSiguiente(j, i,'H');
                this.setLagActual(j, i, false);
            }
        }
    }
        
    public char definirEstadoSig(int y, int x) {
        int aux = 0;
        char aux2 = this.getActual(x, y);
        switch (aux2) {
            case 'H':
                if (x > 0 && x < ancho-1 && y > 0 && y < alto-1 ) {
                    for (int i = -1 ; i < 2; i++) {
                        if (this.getActual(x-1,y+i)=='A') {
                            return 'A';                           
                        }else if(this.getActual(x-1,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                              return 'A';
                            }
                        }
                        if (this.getActual(x,y+i)=='A') {
                            return 'A';
                        }else if(this.getActual(x,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x+1,y+i)=='A') {
                            return 'A';
                        }else if(this.getActual(x+1,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                    }
                }else if(x == 0 && y > 0 && y < alto-1){
                    for (int i = -1 ; i < 2; i++) {
                        if (this.getActual(x,y+i)=='A') {
                            return 'A';
                        }else if(this.getActual(x,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x+1,y+i)=='A') {
                            return 'A';
                        }else if(this.getActual(x+1,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A'; 
                            }
                        }
                    }
                }else if(y == 0 && x > 0 && x < ancho-1){
                    for (int i = -1 ; i < 2; i++) {
                        if (this.getActual(x+i,y)=='A') {
                            return 'A';
                        }else if(this.getActual(x+i,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x+i,y+1)=='A') {
                            return 'A';
                        }else if(this.getActual(x+i,y+1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                    }
                }else if (y == alto-1 && x>0  && x < ancho-1 ) {
                    for (int i = -1 ; i < 2; i++) {
                        if (this.getActual(x+i,y-1)=='A') {
                            return 'A';
                        }else if(this.getActual(x+i,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x+i,y)=='A') {
                            return 'A';
                        }else if(this.getActual(x+i,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                    }
                }else if (x == ancho-1 && y>0 && y< alto-1) {
                    for (int i = -1 ; i < 2; i++) {
                        if (this.getActual(x,y+i)=='A') {
                            return 'A';
                        }else if(this.getActual(x,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x-1,y+i)=='A') {
                            return 'A';
                        }else if(this.getActual(x-1,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A'; 
                            }
                        }
                    }
                }else if (x == 0 && y == 0) {
                    if (this.getActual(x+1,y)=='A') {
                      return 'A';
                    }else if(this.getActual(x+1,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x+1,y+1)=='A') {
                      return 'A';
                    }else if(this.getActual(x+1,y+1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x,y+1)=='A') {
                      return 'A';
                    }else if(this.getActual(x,y+1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                }else if (x == ancho-1 && y == alto-1) {
                    if (this.getActual(x-1,y)=='A') {
                      return 'A';
                    }else if(this.getActual(x-1,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x-1,y-1)=='A') {
                      return 'A';
                    }else if(this.getActual(x-1,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x,y-1)=='A') {
                      return 'A';
                    }else if(this.getActual(x,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                }else if (x == 0 && y == alto-1) {
                    if (this.getActual(x+1,y)=='A') {
                      return 'A';
                    }else if(this.getActual(x+1,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x+1,y-1)=='A') {
                      return 'A';
                    }else if(this.getActual(x+1,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x,y-1)=='A') {
                      return 'A';
                    }else if(this.getActual(x,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                }else if (x == ancho-1 && y == 0) {
                    if (this.getActual(x-1,y)=='A') {
                      return 'A';
                    }else if(this.getActual(x-1,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x-1,y+1)=='A') {
                      return 'A';
                    }else if(this.getActual(x-1,y+1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x,y+1)=='A') {
                      return 'A';
                    }else if(this.getActual(x,y+1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                }
                
                break;
            case 'A':
                this.setLagActual(x, y, true);                
                if (this.getLagActual(x, y)== 4) {
                    this.setSiguiente(x, y, 'B');
                    this.setLagActual(x, y, false);
                    return 'B';
                }
                return 'A';   
                
            case 'B':
                this.setSiguiente(x, y, 'D');
                return 'D';
            case 'D':
                Random nuevaCelula = new Random();
                if (nuevaCelula.nextInt(prepl) == 1) {
                    Random nuevaA = new Random();
                    if (nuevaA.nextInt(pinfect)== 1) {
                        this.setSiguiente(x, y, 'A');
                        return 'A';
                    }else{
                        this.setActual(x, y, 'H');
                        return'H';
                    }
                }else{
                    return 'D';
                } 
        }
        return this.getActual(x, y); 
    }
    public void actualizarEstado(int y, int x, char c){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                this.setActual(x, y, c);
            }
        }
    }
    
    public void insertarCelulasA(){
        float porcentaje = (pvih*alto*ancho)/100;
        Random x = new Random();
        Random y = new Random();
        for (int i = 0; i < Math.round(porcentaje); i++) {
            this.setActual( x.nextInt(ancho),y.nextInt(alto) ,'A');
        }
    }
}
