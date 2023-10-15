package board;

import main.ChessPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Board {
    ChessPanel cp;
    //Cell[][] board = new Cell[8][8];
    Cell[] whiteAsset ;
    Cell[] blackAsset ;
    public Board(ChessPanel cp){
        this.cp = cp;

        whiteAsset = new Cell[6];
        blackAsset = new Cell[6];

        getPieceAsset();
    }

    public void getPieceAsset(){
        try {
            whiteAsset[0] = new Cell();
            whiteAsset[0].image = ImageIO.read(getClass().getResourceAsStream("/white/w_rook.png"));

            whiteAsset[1] = new Cell();
            whiteAsset[1].image = ImageIO.read(getClass().getResourceAsStream("/white/w_knight.png"));

            whiteAsset[2] = new Cell();
            whiteAsset[2].image = ImageIO.read(getClass().getResourceAsStream("/white/w_bishop.png"));

            whiteAsset[3] = new Cell();
            whiteAsset[3].image = ImageIO.read(getClass().getResourceAsStream("/white/w_queen.png"));

            whiteAsset[4] = new Cell();
            whiteAsset[4].image = ImageIO.read(getClass().getResourceAsStream("/white/w_king.png"));

            whiteAsset[5] = new Cell();
            whiteAsset[5].image = ImageIO.read(getClass().getResourceAsStream("/white/w_pawn.png"));


            blackAsset[0] = new Cell();
            blackAsset[0].image = ImageIO.read(getClass().getResourceAsStream("/black/b_rook.png"));

            blackAsset[1] = new Cell();
            blackAsset[1].image = ImageIO.read(getClass().getResourceAsStream("/black/b_knight.png"));

            blackAsset[2] = new Cell();
            blackAsset[2].image = ImageIO.read(getClass().getResourceAsStream("/black/b_bishop.png"));

            blackAsset[3] = new Cell();
            blackAsset[3].image = ImageIO.read(getClass().getResourceAsStream("/black/b_queen.png"));

            blackAsset[4] = new Cell();
            blackAsset[4].image = ImageIO.read(getClass().getResourceAsStream("/black/b_king.png"));

            blackAsset[5] = new Cell();
            blackAsset[5].image = ImageIO.read(getClass().getResourceAsStream("/black/b_pawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initTile(Graphics2D g2){
        int x = cp.BOX_SIZE;
        int y = cp.BOX_SIZE;
        // Draw white tile
        for (int i = 0; i < 5; i++) {
            g2.drawImage(whiteAsset[i].image,x,y,cp.BOX_SIZE,cp.BOX_SIZE,null);
            //System.out.println(x);
            x += cp.BOX_SIZE;
        }
        for (int i = 2; i >= 0; i--) {
            g2.drawImage(whiteAsset[i].image,x,y,cp.BOX_SIZE,cp.BOX_SIZE,null);
            x += cp.BOX_SIZE;
        }
        x = cp.BOX_SIZE;
        y += cp.BOX_SIZE;
        for (int i = 0; i < 8; i++) {
            g2.drawImage(whiteAsset[5].image,x,y,cp.BOX_SIZE,cp.BOX_SIZE,null);
            x += cp.BOX_SIZE;
        }

        // Draw black tile
        y = cp.BOX_SIZE*7;
        x = cp.BOX_SIZE;
        for (int i = 0; i < 8; i++) {
            g2.drawImage(blackAsset[5].image,x,y,cp.BOX_SIZE,cp.BOX_SIZE,null);
            x += cp.BOX_SIZE;
        }
        x = cp.BOX_SIZE;
        y += cp.BOX_SIZE;
        for (int i = 0; i < 5; i++) {
            g2.drawImage(blackAsset[i].image,x,y,cp.BOX_SIZE,cp.BOX_SIZE,null);
            x += cp.BOX_SIZE;
        }
        for (int i = 2; i >= 0; i--) {
            g2.drawImage(blackAsset[i].image,x,y,cp.BOX_SIZE,cp.BOX_SIZE,null);
            x += cp.BOX_SIZE;
        }
    }
    public void draw(Graphics2D g2){
        int col = 1;
        int row = 1;
        int x = cp.BOX_SIZE;
        int y = cp.BOX_SIZE;

        while (col < cp.maxScreenCol && row < cp.maxScreenRow - 1){
            if (row%2!=0 && col%2==0){
                g2.setColor(new Color(77, 38, 26));
                g2.fillRect(x, y, cp.BOX_SIZE, cp.BOX_SIZE);
                //g2.drawImage(whiteAsset[0].image,x, y, cp.BOX_SIZE, cp.BOX_SIZE,null);
            } else if (row%2!=0 && col%2!=0) {
                g2.setColor(new Color(233, 241, 241));
                g2.fillRect(x, y, cp.BOX_SIZE, cp.BOX_SIZE);
            } else if (row%2==0 && col%2==0) {
                g2.setColor(new Color(233, 241, 241));
                g2.fillRect(x, y, cp.BOX_SIZE, cp.BOX_SIZE);
            } else if (row%2==0 && col%2!=0) {
                g2.setColor(new Color(77, 38, 26));
                g2.fillRect(x, y, cp.BOX_SIZE, cp.BOX_SIZE);
            }
            col++;
            x += cp.BOX_SIZE;
            //System.out.println(" col = " + col + " row = " + row );
            if (col == cp.maxScreenCol - 1){
                col = 1;
                x = cp.BOX_SIZE;
                row++;
                y += cp.BOX_SIZE;
            }

        }
        initTile(g2);
    }
}
