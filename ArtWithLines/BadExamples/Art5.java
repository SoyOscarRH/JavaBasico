/*=====================================================================
====================        DRAW LINES       ==========================
=====================================================================*/

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Art5 extends JPanel {
 
    public void paintComponent(Graphics g) {

        int Iterations = 30;
        int b = Iterations * 10;
        int Start = 50;
        int End = 650;
        int Middle = 350;

        for(int i = 0; i <= Iterations; i++) {
            
            int Step = 10 * i;

            g.setColor(Color.BLACK);
            g.drawLine(Start + Step, Start, Start + b, Start + Step);

            g.setColor(Color.ORANGE);
            g.drawLine(Middle + Step, Start, Start + b, Middle - Step);

            g.setColor(Color.BLUE);
            g.drawLine(End - Step, End, End - b, End - Step);

            g.setColor(Color.GREEN);
            g.drawLine(Middle - Step, End, End - b, Middle + Step);

            g.setColor(Color.PINK);
            g.drawLine(Start + Step , Start + Step, Middle - Step, Middle + Step);

            g.setColor(Color.RED);
            g.drawLine(Middle + Step, Middle + Step, End - Step, Start + Step);
        }
    }
 
    public static void main(String[] args) {
        Art5 Canvas = new Art5();
        JFrame BeautifulLinesFrame = new JFrame("Beautiful Lines");
        
        BeautifulLinesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BeautifulLinesFrame.setBackground(Color.white);
        BeautifulLinesFrame.setSize(700, 700);
        BeautifulLinesFrame.add(Canvas);
     
        BeautifulLinesFrame.setVisible(true);
    }
}