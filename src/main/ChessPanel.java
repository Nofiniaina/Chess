package main;

import board.Board;

import javax.swing.*;
import java.awt.*;

public class ChessPanel extends JPanel {

    public final int BOX_SIZE = 50;
    public final int maxScreenCol = 10;
    public final int maxScreenRow = 10;
    public final int maxScreenWidth = BOX_SIZE * maxScreenCol;
    public final int maxScreenHeight = BOX_SIZE * maxScreenRow;

    Board br = new Board(this);
    public ChessPanel(){
        this.setPreferredSize(new Dimension(maxScreenWidth,maxScreenHeight));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        br.draw(g2);
        g.dispose();
    }

}
