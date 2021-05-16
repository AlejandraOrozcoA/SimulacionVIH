
package simulacionvih.vistas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.math.plot.Plot2DPanel;

public class Grafica {

    private double yH[];
    private double yA[];
    private double yB[];
    private double yD[];
    private double yI[];
    
    private double t[];

    private JButton btnG1, btnG2;
    
    private Plot2DPanel plot = new Plot2DPanel();      
    public Grafica(ArrayList<Double> h,ArrayList<Double> a,ArrayList<Double> b, ArrayList<Double> d, int contador){
        yH= new double[h.size()+1];
        yA= new double[a.size()+1];
        yB= new double[b.size()+1];
        yD= new double[d.size()+1];
        yI= new double[a.size()+1];
        
        t = new double [contador];
        
        llenarH(h);
        llenarA(a);
        llenarB(b);
        llenarD(d);
        llenarI(a,b);
        llenarT(contador);
        agregarComponentes();
    }

    private void agregarComponentes() {
        btnG1 = new JButton("Grafica 1");
        btnG2 = new JButton("Grafica 2");
        
        JFrame frame =  new JFrame("Grafica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.add(construirPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        
        btnG1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                plot.removeAllPlots();
                plot.addScatterPlot("Celulas Infectadas",Color.ORANGE ,t, yI);
                plot.addLinePlot("Celulas Infectadas",Color.ORANGE ,t, yI);
                plot.addScatterPlot("Celulas Muertas", Color.RED, t, yD);
                plot.addLinePlot("Celulas Muertas", Color.RED, t, yD);
                plot.addScatterPlot("Celulas Sanas",Color.BLUE ,t, yH);
                plot.addLinePlot("Celulas Sanas",Color.BLUE ,t, yH);
                
            }
        });
        
        btnG2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                plot.removeAllPlots();
                plot.addScatterPlot("Celulas Infectadas A",Color.ORANGE ,t, yA);
                plot.addLinePlot("Celulas Infectadas A",Color.ORANGE ,t, yA);
                plot.addScatterPlot("Celulas Infectadas B",Color.GREEN ,t, yB);
                plot.addLinePlot("Celulas Infectadas B",Color.GREEN ,t, yB);
                plot.addScatterPlot("Celulas Muertas", Color.RED, t, yD);
                plot.addLinePlot("Celulas Muertas", Color.RED, t, yD);
                plot.addScatterPlot("Celulas Sanas",Color.BLUE ,t, yH);
                plot.addLinePlot("Celulas Sanas",Color.BLUE ,t, yH);
            }
        });
        
    }

    private JPanel construirPanel() {
        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        pPrincipal.add(plot,BorderLayout.CENTER);
        pPrincipal.add(contruirSubpanel(),BorderLayout.SOUTH);
        return pPrincipal;
    }

    private Component contruirSubpanel() {
        JPanel pSub = new JPanel();
        pSub.add(btnG1);
        pSub.add(btnG2);
        return pSub;
    }

    private void llenarT(int contador) {
        for (int i = 0; i < contador; i++) {
                t[i]=i;   
        }
    }

    private void llenarH(ArrayList h) {
        for (int i = 0; i < h.size(); i++) {
             yH[i]= Double.parseDouble(h.get(i).toString());   
        }
    }

    private void llenarA(ArrayList<Double> a) {
        for (int i = 0; i < a.size(); i++) {
             yA[i]= Double.parseDouble(a.get(i).toString());   
        }
    }

    private void llenarB(ArrayList<Double> b) {
        for (int i = 0; i < b.size(); i++) {
             yB[i]= Double.parseDouble(b.get(i).toString());   
        }
    }

    private void llenarD(ArrayList<Double> d) {
        for (int i = 0; i < d.size(); i++) {
             yD[i]= Double.parseDouble(d.get(i).toString());   
        }
    }

    private void llenarI(ArrayList<Double> a, ArrayList<Double> b) {
        for (int i = 0; i < a.size(); i++) {
             yI[i]= Double.parseDouble(a.get(i).toString())+ Double.parseDouble(b.get(i).toString());   
        }
    }  
}
