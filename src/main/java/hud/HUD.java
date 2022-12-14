package hud;

import game.main.Game;
import game.main.moves.Move;
import game.pieces.Color;
import game.pieces.Piece;
import launcher.DesktopLauncher;

import javax.swing.*;
import java.awt.*;

public class HUD extends JScrollPane
{
    private final JTextArea textArea;

    public HUD()
    {
        textArea = new JTextArea();
        init();
    }

    private void init()
    {
        this.setViewportView(textArea);
        this.setPreferredSize(new Dimension(6 * Game.SQUARE_SIZE + Game.SQUARE_SIZE / 2, DesktopLauncher.WINDOW_HEIGHT));
        this.setBorder(null);

        textArea.setEditable(false);
        textArea.setFont(Game.basicFont);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    public void update()
    {
        Move move = Game.moveManager.getMove(Move.moveNum - 1);
        Piece piece = move.piece();

        String ch = piece.getColor() == Color.White ? piece.getSymbols()[0] : piece.getSymbols()[1];
        String m = move.toString();
        String moveNum = piece.getColor() == Color.White ? Move.moveNum / 2 + 1 + ". " : "";
        textArea.setText(textArea.getText() + moveNum + ch + m.substring(1, m.indexOf("-") + 1) + ch + m.substring(m.indexOf("-") + 2) + "     ");
        if(Move.moveNum != 0 && Move.moveNum % 2 == 0)
        {
            textArea.setText(textArea.getText() + "\n");
        }
    }
}