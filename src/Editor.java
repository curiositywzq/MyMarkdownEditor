import com.petebevin.markdown.MarkdownProcessor;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by Wu on 2016/12/6.
 */
public class Editor extends JScrollPane{
    private JTextPane editor;
    private MarkdownProcessor processor;
    private JScrollBar scrollBar;
    public Editor(Player player,Structure structure){
        this.editor = new JTextPane();
        this.processor = new MarkdownProcessor();
        this.setBounds(10,20,380,530);
        this.getViewport().add(editor);
        this.scrollBar = this.getVerticalScrollBar();

        this.editor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setHtml(player);
                updateStruct(structure);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setHtml(player);
                updateStruct(structure);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setHtml(player);
                updateStruct(structure);
            }
        });
        structure.getMyList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = structure.getMyList().getSelectedIndex();
                if(index <0) return;
                scrollBar.setValue((Integer)structure.getMyPlaces().get(index)*16);
            }
        });
    }

    public void setHtml(Player player){
        player.setContent(this.processor.markdown(this.editor.getText()));
    }
    public String getContent(){ return this.editor.getText();}
    public void setContent(String content){ this.editor.setText(content);}
    public void updateStruct(Structure structure){structure.refreshStructure(this.editor.getText());}
}