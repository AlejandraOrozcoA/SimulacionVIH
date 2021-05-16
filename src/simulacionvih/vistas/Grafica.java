
package simulacionvih.vistas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.math.array.DoubleArray.*;
import org.math.plot.Plot2DPanel;

public class Grafica {
    
    private double x[] ={0.0,0.0};
    private double y[] ={0.0,0.0};
    
    private double yH[];
    private double yA[];
    private double yB[];
    private double yD[];
    
    private double t[];

    private JButton btnA, btnB, btnH, btnD;
    private Plot2DPanel plot = new Plot2DPanel();

    public Grafica() {
        agregarComponentes();
    }
    
    
    public Grafica(ArrayList<Double> h,ArrayList<Double> a,ArrayList<Double> b, ArrayList<Double> d, int contador){
        yH= new double[h.size()];
        yA= new double[a.size()];
        yB= new double[b.size()];
        yD= new double[d.size()];
        
        t = new double [contador];
        llenarH(h);
        llenarA(a);
        llenarB(b);
        llenarD(d);
        llenarT(contador);
        agregarComponentes();
    }

    private void agregarComponentes() {
        btnA = new JButton("Celulas A");
        btnB = new JButton("Celulas B");
        btnH = new JButton("Celulas H");
        btnD = new JButton("Celulas D");
   
        JFrame frame =  new JFrame("Grafica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.add(construirPanel());
        frame.setVisible(true); 
        
        btnH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                plot.addScatterPlot("Celulas H",Color.BLUE ,t, yH);
                plot.addLinePlot("Celulas H",Color.BLUE ,t, yH);
            }
        });
        
        btnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                plot.addScatterPlot("Celulas A",Color.orange ,t, yA);
                plot.addLinePlot("Celulas A",Color.orange ,t, yA);
            }
        });
        
        btnB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                plot.addScatterPlot("Celulas B",Color.GREEN,t, yB);
                plot.addLinePlot("Celulas B",Color.GREEN,t, yB);
            }
        });
        
        btnD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                plot.addScatterPlot("Celulas D", Color.RED, t, yD);
                plot.addLinePlot("Celulas D", Color.RED, t, yD);
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
        pSub.add(btnA);
        pSub.add(btnB);
        pSub.add(btnH);
        pSub.add(btnD);
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
    
}
