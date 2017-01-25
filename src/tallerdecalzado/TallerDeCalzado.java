
package tallerdecalzado;
// creado por Mao Rivera
// 24 de Enero del 2017

import java.awt.EventQueue;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

//maorivera@outlook.com

public class TallerDeCalzado {

   
    public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable(){
        public void run(){
            try{
                JFrame.setDefaultLookAndFeelDecorated(true);                                
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeCoffeeSkin");
                //SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceCremeTheme" );
                            
            }              
            catch(Exception e){
            } 
             Splash.setDefaultLookAndFeelDecorated(false);
            new Splash().setVisible(true);
        }
        });
    
}
    
}
