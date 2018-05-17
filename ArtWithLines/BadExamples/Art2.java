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
 
public class Art2 extends JPanel {
 
    public void BasicFigure(Graphics g, int Resolution, int Size) {
        int Final = ((int) Size / Resolution) * Resolution;
        int Start = 0;

        for (int step = Start; step <= Final; step += Resolution) {
            g.drawLine(Final - step, (int)(step * 0.577) , step, (int) (Final * 0.577) );
        }
    }

    public void paintComponent(Graphics g) {

        int XShift = 0, YShift = 0;
        double XScale = 1, YScale = 1;
        double AngleRotation = Math.toRadians(5);
        int WindowsSize = 700;
        int Resolution = 25;
        double Size = (WindowsSize);

        YScale = 0.5;
        XScale = 0.5;

        int XShifts[] = {350, 315, 242, 150, 65, 11, 0, 39, 112, 204, 290, 342};
        int YShifts[] = {140, 56, 0, -10, 26, 101, 192, 274, 329, 339, 305, 232};
        java.awt.Color Colors[] = {
            Color.GREEN, 
            Color.BLUE,
            Color.BLACK,
            Color.RED,
            Color.YELLOW,
            Color.MAGENTA,
            Color.GRAY,
            Color.GREEN,
            Color.BLUE,
            Color.RED,
            Color.YELLOW,
            Color.BLACK
        };


        for (int i = 0; i < 12; i++) {
            AngleRotation = Math.toRadians(-30 * i);
            AffineTransform Tranformation = new AffineTransform();
            Tranformation.translate(XShifts[i], YShifts[i]);  
            Tranformation.scale(XScale, YScale);
            Tranformation.rotate(AngleRotation, WindowsSize / 2, WindowsSize / 2);
            
            ((Graphics2D) g).setTransform(Tranformation);
            g.setColor(Colors[i]);
            BasicFigure(g, Resolution, (int) Size);
        }

    }

    public static void main(String[] args) {
        Art2 Canvas = new Art2();
        JFrame BeautifulLinesFrame = new JFrame("Beautiful Lines");
        
        BeautifulLinesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BeautifulLinesFrame.setBackground(Color.white);
        BeautifulLinesFrame.setSize(700, 700);
        BeautifulLinesFrame.add(Canvas);
     
        BeautifulLinesFrame.setVisible(true);
    }
}