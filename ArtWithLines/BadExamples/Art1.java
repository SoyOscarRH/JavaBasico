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
 
public class Art1 extends JPanel {
 
    public void BasicFigure(Graphics g, int Resolution, int Size) {
        int Final = ((int) Size / Resolution) * Resolution;
        int Start = 0;

        for (int step = Start; step <= Final; step += Resolution) {
            g.drawLine(Start, step, step, Final);
        }
    }

    public void paintComponent(Graphics g) {

        int XShift = 0, YShift = 0;
        double XScale = 1, YScale = 1;
        double AngleRotation = Math.toRadians(5);
        int WindowsSize = 700;
        int Resolution = 20;
        double Size = (WindowsSize);

        YScale = 0.3;
        XScale = 0.3;

        int XShifts[] = {350, 140, 140, 350};
        int YShifts[] = {350, 350, 140, 140};

        for (int i = 0; i < 4; i++) {
            AngleRotation = Math.toRadians(90 * i + 90);
            AffineTransform Tranformation = new AffineTransform();
            Tranformation.translate(XShifts[i], YShifts[i]);  
            Tranformation.scale(XScale, YScale);
            Tranformation.rotate(AngleRotation, WindowsSize / 2, WindowsSize / 2);
            
            ((Graphics2D) g).setTransform(Tranformation);
            g.setColor(Color.GREEN);
            BasicFigure(g, Resolution, (int) Size);
        }

        YScale = 0.5;
        XScale = 1;

        int XShifts2[] = {0, 0};
        int YShifts2[] = {0, 325};

        for (int i = 0; i < 2; i++) {
            AngleRotation = Math.toRadians(90 + i*180);
            AffineTransform Tranformation = new AffineTransform();
            Tranformation.translate(XShifts2[i], YShifts2[i]);  
            Tranformation.scale(XScale, YScale);
            Tranformation.rotate(AngleRotation, WindowsSize / 2, WindowsSize / 2);
            
            ((Graphics2D) g).setTransform(Tranformation);
            g.setColor(Color.GREEN);
            BasicFigure(g, Resolution, (int) Size);
        }


    }

    public static void main(String[] args) {
        Art1 Canvas = new Art1();
        JFrame BeautifulLinesFrame = new JFrame("Beautiful Lines");
        
        BeautifulLinesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BeautifulLinesFrame.setBackground(Color.white);
        BeautifulLinesFrame.setSize(700, 700);
        BeautifulLinesFrame.add(Canvas);
     
        BeautifulLinesFrame.setVisible(true);
    }
}