/*=====================================================================
====================        DRAW LINES       ==========================
=====================================================================*/
import java.lang.Math;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
 
public class GenericBezierCurve extends JPanel {
 
    static int WindowsSize = 680;


    /*============================================================
    ============          DRAW BEZIER CURVE     ==================
    ============================================================*/
    public void DrawBezierCurve(Graphics g, int Size, int Resolution, double AngleDefinition) {

        int Final = ((int) Size / Resolution) * Resolution;
        int Start = 0;

        int UpBound   = (int) ((1 - Math.sin(AngleDefinition)) * Final);
        int LeftBound = (int) ((Math.cos(AngleDefinition)) * Final);

        for (int step = Start; step <= Final; step += Resolution) {
            int MoveX = LeftBound - (int)(step * Math.cos(AngleDefinition));
            int MoveY = UpBound   + (int)(step * Math.sin(AngleDefinition));
            g.drawLine(step, Final, MoveX, MoveY);
        }

        g.drawLine(0, Final, Final, Final);
        g.drawLine(0, Final, LeftBound, UpBound);

    }


    /*============================================================
    ============       PAINT COMPONENT      ======================
    ============================================================*/
    public void paintComponent(Graphics g) {

        int XShift = 20, YShift = 20;
        double XScale = 0.8, YScale = 0.8;
        double AngleRotation = Math.toRadians(0);
        double AngleDefinition = Math.toRadians(90);
        int Resolution = 15;
        int ShapeSize = WindowsSize;

        AffineTransform Tranformation = new AffineTransform();
        Tranformation.translate(XShift, YShift);  
        Tranformation.scale(XScale, YScale);
        Tranformation.rotate(AngleRotation, WindowsSize / 2, WindowsSize / 2);
        
        ((Graphics2D) g).setTransform(Tranformation);

        g.setColor(new Color(40,53,147));
        DrawBezierCurve(g, ShapeSize, Resolution, AngleDefinition);
    }



    /*============================================================
    ====================       MAIN     ==========================
    ============================================================*/
    public static void main(String[] args) {
        GenericBezierCurve Canvas = new GenericBezierCurve();
        JFrame BeautifulLinesFrame = new JFrame("Beautiful Lines");
        
        BeautifulLinesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BeautifulLinesFrame.setBackground(Color.white);
        BeautifulLinesFrame.setSize(WindowsSize, WindowsSize);
        BeautifulLinesFrame.add(Canvas);
        BeautifulLinesFrame.setVisible(true);
    }
}