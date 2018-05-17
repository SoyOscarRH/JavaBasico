/*=====================================================================
====================        DRAW LINES       ==========================
=====================================================================*/

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
 
public class Art3 extends JPanel {
 
    public void BasicFigureRight(Graphics g, int Resolution, int Size) {
        int Final = ((int) Size / Resolution) * Resolution;
        int Start = 0;

        for (int step = Start; step <= Final; step += Resolution) {
            g.drawLine(Start, step, step, Final);
        }
    }

    public void BasicFigureLeft(Graphics g, int Resolution, int Size) {
        int Final = ((int) Size / Resolution) * Resolution;
        int Start = 0;

        for (int step = Start; step <= Final; step += Resolution) {
            g.drawLine(Final, step, Final - step, Final);
        }
    }

    public void paintComponent(Graphics g) {

        int XShift = 0, YShift = 0;
        double XScale = 1, YScale = 1;
        double AngleRotation = Math.toRadians(5);
        int WindowsSize = 700;
        int Resolution = 20;
        double Size = (WindowsSize);

        YScale = 0.35;
        XScale = 0.35;

        XShift = 350;
        YShift = 350;

        g.setColor(Color.GREEN);
        for (int i = 0; i < 12 ; i++) {
            AngleRotation = Math.toRadians(45 * i);
            AffineTransform Tranformation = new AffineTransform();
            Tranformation.translate(XShift, YShift);  
            Tranformation.scale(XScale, YScale);
            Tranformation.rotate(AngleRotation, 0, 0);
            
            ((Graphics2D) g).setTransform(Tranformation);
            BasicFigureRight(g, Resolution, (int) Size);
            
        }

        g.setColor(Color.MAGENTA);

        int XShifts[] = {105, 176, 350, 523, 595, 523, 350, 177};
        int YShifts[] = {350, 176, 106, 177, 350, 523, 596, 523};

        for (int i = 0; i < 8; i++) {
            AngleRotation = Math.toRadians(45*i);
            AffineTransform Tranformation = new AffineTransform();
            Tranformation.translate(XShifts[i], YShifts[i]);  
            Tranformation.scale(XScale, YScale);
            Tranformation.rotate(AngleRotation, 0, 0);
            
            ((Graphics2D) g).setTransform(Tranformation);
            BasicFigureLeft(g, Resolution, (int) Size);
        }
        

    }

    public static void main(String[] args) {
        Art3 Canvas = new Art3();
        JFrame BeautifulLinesFrame = new JFrame("Beautiful Lines");
        
        BeautifulLinesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BeautifulLinesFrame.setBackground(Color.white);
        BeautifulLinesFrame.setSize(800, 700);
        BeautifulLinesFrame.add(Canvas);
     
        BeautifulLinesFrame.setVisible(true);
    }
}