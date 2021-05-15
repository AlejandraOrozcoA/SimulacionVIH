
package simulacionvih.vistas;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import simulacionvih.VIH;

public class Simulacion extends javax.swing.JFrame {
    private final int ancho = 200;
    private final int alto = 200;
    private VIH cel;
    private Image tableroI;
    private Graphics tableroG;
    private boolean inicio;
    private Timer t; 
    private TimerTask task;
    
    public Simulacion() {
        initComponents();
        cel = new VIH(ancho, alto);
        inicio = true;
        tableroI = createImage(jPanel1.getWidth(),jPanel1.getHeight() );
        tableroG = tableroI.getGraphics();
        t = new Timer();
        task = new TimerTask(){
            @Override
            public void run(){
                
                if (btnInicio.getText().equals("Pausa")) {
                    for (int i = 0; i < alto; i++) {
                        for (int j = 0; j < ancho; j++) {
                           cel.setSiguiente(j, i, cel.definirEstadoSig(i, j));
                        }
                    }
                    for (int i = 0; i < alto; i++) {
                        for (int j = 0; j < ancho; j++) {
                           cel.actualizarEstado(i, j,cel.getSiguiente(j, i));
                        }
                    }
                    dibujarTablero();
                }
            }
        };
        t.scheduleAtFixedRate(task, 0, 400);
        dibujarTablero();
    }
    
    private void dibujarTablero(){
        tableroG.setColor(jPanel1.getBackground());
        tableroG.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());  
        
        //Dibuja Celulas
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (cel.getActual(i,j)== 'A') {
                    tableroG.setColor(Color.yellow);
                    int y = i* jPanel1.getHeight()/alto;
                    int x = j* jPanel1.getWidth()/ancho;
                    tableroG.fillRect(x, y, jPanel1.getWidth()/ancho, jPanel1.getHeight()/alto);
                }else if (cel.getActual(i,j)== 'B') {
                    tableroG.setColor(Color.GREEN);
                    int y = i* jPanel1.getHeight()/alto;
                    int x = j* jPanel1.getWidth()/ancho;
                    tableroG.fillRect(x, y, jPanel1.getWidth()/ancho, jPanel1.getHeight()/alto);
                }else if (cel.getActual(i,j)== 'D') {
                    tableroG.setColor(Color.RED);
                    int y = i* jPanel1.getHeight()/alto;
                    int x = j* jPanel1.getWidth()/ancho;
                    tableroG.fillRect(x, y, jPanel1.getWidth()/ancho, jPanel1.getHeight()/alto);
                }else{
                    tableroG.setColor(jPanel1.getBackground());
                    int y = i* jPanel1.getHeight()/alto;
                    int x = j* jPanel1.getWidth()/ancho;
                    tableroG.fillRect(x, y, jPanel1.getWidth()/ancho, jPanel1.getHeight()/alto);
                }
            }
        }
        
        tableroG.setColor(Color.black);
        //dibuja barras Horizontales 
        for (int i = 0; i < alto; i++) {
            int y = i* jPanel1.getHeight()/alto;
            tableroG.drawLine(0, y,jPanel1.getWidth() , y);
        }
        // Dibuja barras Verticales  
        for (int j = 0; j < ancho; j++) {
            int x = j* jPanel1.getWidth()/ancho;
            tableroG.drawLine(x, 0, x , jPanel1.getHeight());
        }
        
        jPanel1.getGraphics().drawImage(tableroI, 0, 0, jPanel1);
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        btnInicio.setText("Inicio");
        btnInicio.setName(""); // NOI18N
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnClean.setText("Limpiar");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar Celulas A ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        inicio = !inicio;
        if (inicio) {
            btnInicio.setText("Inicio");
        }else{
            btnInicio.setText("Pausa");
        }
        dibujarTablero();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        int x = ancho * evt.getX()/jPanel1.getWidth();
        int y = alto * evt.getY()/jPanel1.getHeight();
        cel.setActual(y, x, 'A');
        dibujarTablero();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        tableroI = createImage(jPanel1.getWidth(),jPanel1.getHeight() );
        tableroG = tableroI.getGraphics();
        dibujarTablero();
    }//GEN-LAST:event_jPanel1ComponentResized

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        cel.llenar();
        dibujarTablero();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cel.insertarCelulasA();
        dibujarTablero();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
