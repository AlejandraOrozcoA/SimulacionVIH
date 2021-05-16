
package simulacionvih;

import java.util.Random;

public class VIH {
    //Datos contasntes
    private final int rb = 1;
    private final int ra = 1;
    private final int lag = 4;
    private final int prepl = 99;
    private final int pinfect = 10000;
    private final int pvih = 5;
    //Datos variables 
    private int alto;
    private int ancho;
    private char actual[][];
    private char siguiente[][];
    private int lagActual [][];
    
    //conteo de celulas para la grafica 
    private int celulasH;
    private int celulasA;
    private int celulasB;
    private int celulasD;

    
    public VIH(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        this.celulasH= 0;
        this.celulasA=0;
        this.celulasB=0;
        this.celulasD=0;
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

    public int getCelulasH() {
        return celulasH;
    }

    public void setCelulasH(int celulasH) {
        this.celulasH = celulasH;
    }

    public int getCelulasA() {
        return celulasA;
    }

    public void setCelulasA(int celulasA) {
        this.celulasA = celulasA;
    }

    public int getCelulasB() {
        return celulasB;
    }

    public void setCelulasB(int celulasB) {
        this.celulasB = celulasB;
    }

    public int getCelulasD() {
        return celulasD;
    }

    public void setCelulasD(int celulasD) {
        this.celulasD = celulasD;
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
    
    //Basado en el estado actual regresa el estado siguiente
    public char definirEstadoSig(int y, int x) {
        int aux = 0; 
        char aux2 = this.getActual(x, y);
        int aux3 =0;
        switch (aux2) {
            case 'H': //identifica la celula actual y revisa las celulas vecinas 
                if (x > 0 && x < ancho-1 && y > 0 && y < alto-1 ) {
                    for (int i = -1 ; i < 2; i++) {
                        if (this.getActual(x-1,y+i)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            }                         
                        }else if(this.getActual(x-1,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                              return 'A';
                            }
                        }
                        if (this.getActual(x,y+i)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                        }else if(this.getActual(x,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x+1,y+i)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
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
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                        }else if(this.getActual(x,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x+1,y+i)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
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
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                        }else if(this.getActual(x+i,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x+i,y+1)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
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
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                        }else if(this.getActual(x+i,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x+i,y)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
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
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                        }else if(this.getActual(x,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                        }
                        if (this.getActual(x-1,y+i)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                        }else if(this.getActual(x-1,y+i)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A'; 
                            }
                        }
                    }
                }else if (x == 0 && y == 0) {
                    if (this.getActual(x+1,y)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x+1,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x+1,y+1)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x+1,y+1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x,y+1)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x,y+1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                }else if (x == ancho-1 && y == alto-1) {
                    if (this.getActual(x-1,y)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x-1,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x-1,y-1)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x-1,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x,y-1)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                }else if (x == 0 && y == alto-1) {
                    if (this.getActual(x+1,y)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x+1,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x+1,y-1)=='A') {
                             aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x+1,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x,y-1)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x,y-1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                }else if (x == ancho-1 && y == 0) {
                    if (this.getActual(x-1,y)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x-1,y)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x-1,y+1)=='A') {
                             aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } ;
                    }else if(this.getActual(x-1,y+1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                    if (this.getActual(x,y+1)=='A') {
                            aux3++;
                            if (aux3 == ra) {
                                return 'A';
                            } 
                    }else if(this.getActual(x,y+1)=='B'){
                            aux++;
                            if (aux == rb) {
                               return 'A';
                            }
                    }
                }
                
                break;
            case 'A'://Si el tiempo transcurrido es igual al lag la convierte en B
                this.setLagActual(x, y, true);                
                if (this.getLagActual(x, y)== lag) {
                    this.setCelulasA(this.getCelulasA()-1);
                    this.setCelulasB(this.getCelulasB()+1);
                    this.setSiguiente(x, y, 'B');
                    this.setLagActual(x, y, false);
                    return 'B';
                }
                return 'A';   
                
            case 'B':// se convierte en D
                this.setSiguiente(x, y, 'D');
                return 'D';
            case 'D':
                Random nuevaCelula = new Random();
                //tomas las provabilidades dadas para decidir si la celula mueta sera reemplazada 
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
    //Actualiza el estado
    public void actualizarEstado(int y, int x, char c){
        this.setCelulasH(0);
        this.setCelulasA(0);
        this.setCelulasB(0);
        this.setCelulasD(0);
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                this.setActual(x, y, c);
            }
        }
    }
    
    //inserta un porcetaje(pvih) de celulas infectadas tipo A aleatoriamente
    public void insertarCelulasA(){
        float porcentaje = (pvih*alto*ancho)/100;
        Random x = new Random();
        Random y = new Random();
        for (int i = 0; i < Math.round(porcentaje); i++) {
            this.setActual( x.nextInt(ancho),y.nextInt(alto) ,'A');
        }
    }
    
    public void contarCelulas(){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                switch (actual[i][j]) {
                    case 'H':
                        this.setCelulasH(this.getCelulasH()+1);
                        break;
                    case 'A':
                        this.setCelulasA(this.getCelulasA()+1);
                        break;
                    case 'B':
                        this.setCelulasB(this.getCelulasB()+1);
                        break;
                    case 'D':
                        this.setCelulasD(this.getCelulasD()+1);
                        break;
                }
            }
        }    
    }
}
