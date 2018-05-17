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
 
public class Art4 extends JPanel {
 
    static int WindowsSize = 600;


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

        int XShift = 100, YShift = 0;
        double XScale = 0.4, YScale = 0.4;
        double AngleRotation = Math.toRadians(0);
        double AngleDefinition = Math.toRadians(60);
        int Resolution = 30;
        int ShapeSize = 700;

        int XShifts[] = {150, -521, -861};
        int YShifts[] = {150, 929, -43};

        for (int i = 0; i < 3; i++) {
            AngleRotation = Math.toRadians(i * 120);
            
            AffineTransform Tranformation = new AffineTransform();
            Tranformation.translate(XShifts[i], YShifts[i]);  
            Tranformation.rotate(AngleRotation, ShapeSize, 0);
            Tranformation.scale(XScale, YScale);
            
            ((Graphics2D) g).setTransform(Tranformation);

            g.setColor(new Color(212,225,87));
            DrawBezierCurve(g, ShapeSize, Resolution, AngleDefinition);
        }

        int XShifts2[] = {-300, -972, 40};
        int YShifts2[] = {-240, 540, 733};

        for (int i = 0; i < 3; i++) {
            AngleRotation = Math.toRadians(-120*i - 60);
            
            AffineTransform Tranformation = new AffineTransform();
            Tranformation.translate(XShifts2[i], YShifts2[i]);  
            Tranformation.rotate(AngleRotation, ShapeSize, 0);
            Tranformation.scale(XScale, YScale);
            
            ((Graphics2D) g).setTransform(Tranformation);

            g.setColor(new Color(92,107,192));
            DrawBezierCurve(g, ShapeSize, Resolution, AngleDefinition);
        }

    }



    /*============================================================
    ====================       MAIN     ==========================
    ============================================================*/
    public static void main(String[] args) {
        Art4 Canvas = new Art4();
        JFrame BeautifulLinesFrame = new JFrame("Beautiful Lines");
        
        BeautifulLinesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BeautifulLinesFrame.setBackground(Color.white);
        BeautifulLinesFrame.setSize(WindowsSize, WindowsSize);
        BeautifulLinesFrame.add(Canvas);
        BeautifulLinesFrame.setVisible(true);
    }
}