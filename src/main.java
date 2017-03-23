import javax.swing.*;
import java.awt.*;

/**
 * Created by Wu on 2016/12/6.
 */
public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyMarkdownEditor");
        Player player = new Player();
        Structure structure = new Structure();
        Editor editor = new Editor(player,structure);
        MyMenu menu = new MyMenu(editor,player);
        frame.setJMenuBar(menu);

        frame.setLayout(new GridLayout(1,3));

        JPanel left_editor = new JPanel();
        JPanel center_player = new JPanel();
        JPanel right_structure = new JPanel();
        left_editor.setLayout(null);
        center_player.setLayout(null);
        right_structure.setLayout(null);

        left_editor.setBorder(BorderFactory.createTitledBorder("Editor"));
        center_player.setBorder(BorderFactory.createTitledBorder("Player"));
        right_structure.setBorder(BorderFactory.createTitledBorder("Structure"));

        left_editor.add(editor);
        center_player.add(player);
        right_structure.add(structure);

        frame.add(right_structure);
        frame.add(left_editor);
        frame.add(center_player);


        frame.setSize(1200,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
