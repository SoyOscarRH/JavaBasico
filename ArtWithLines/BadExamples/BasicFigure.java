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
 
public class BasicFigure extends JPanel {
 
    public void BasicFigure(Graphics g, int Resolution, int Size) {
        int Final = ((int) Size / Resolution) * Resolution;
        int Start = 0;

        for (int step = Start; step <= Final; step += Resolution) {
            g.drawLine(Start, step, step, Final);
        }
    }

    public void paintComponent(Graphics g) {

        int XShift = 100, YShift = 100;
        int XScale = 1, YScale = 1;
        double AngleRotation = Math.toRadians(0);
        int WindowsSize = 700;

        AffineTransform Tranformation = new AffineTransform();
        Tranformation.rotate(AngleRotation, WindowsSize / 2, WindowsSize / 2);
        Tranformation.translate(XShift, YShift);  
        Tranformation.scale(XScale, YScale);
        
        ((Graphics2D) g).setTransform(Tranformation);
        g.setColor(Color.GREEN);
        BasicFigure(g, 10, (int) (WindowsSize * 0.5) );
    }

    public static void main(String[] args) {
        BasicFigure Canvas = new BasicFigure();
        JFrame BeautifulLinesFrame = new JFrame("Beautiful Lines");
        
        BeautifulLinesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BeautifulLinesFrame.setBackground(Color.white);
        BeautifulLinesFrame.setSize(700, 700);
        BeautifulLinesFrame.add(Canvas);
     
        BeautifulLinesFrame.setVisible(true);
    }
}