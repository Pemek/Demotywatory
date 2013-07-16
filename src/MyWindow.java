import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;


public class MyWindow extends JFrame{
	
	private JFrame jFrame1;
	private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTextArea textArea;
    
    private int rowsCount = 0;
	
	public MyWindow() {
		jLabel1 = new JLabel("Log");
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        textArea.setColumns(20);
//        textArea.setLineWrap(true);
//        textArea.setRows(5);
//        textArea.setWrapStyleWord(true);
        
        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
         
        jScrollPane1 = new JScrollPane(textArea);
         
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
         
        //Create a parallel group for the horizontal axis
        ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        //Create a sequential and a parallel groups
        SequentialGroup h1 = layout.createSequentialGroup();
        ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
        //Add a scroll panel and a label to the parallel group h2
        h2.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE);
        h2.addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE);
         
    //Add a container gap to the sequential group h1
        h1.addContainerGap();
        // Add the group h2 to the group h1
        h1.addGroup(h2);
        h1.addContainerGap();
        //Add the group h1 to hGroup
        hGroup.addGroup(Alignment.TRAILING,h1);
        //Create the horizontal group
        layout.setHorizontalGroup(hGroup);
         
    //Create a parallel group for the vertical axis
        ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        //Create a sequential group
        SequentialGroup v1 = layout.createSequentialGroup();
        //Add a container gap to the sequential group v1
        v1.addContainerGap();
        //Add a label to the sequential group v1
        v1.addComponent(jLabel1);
        v1.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        //Add scroll panel to the sequential group v1
        v1.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE);
        v1.addContainerGap();
        //Add the group v1 to vGroup
        vGroup.addGroup(v1);
        //Create the vertical group
        layout.setVerticalGroup(vGroup);
        setMinimumSize(new Dimension(500, 500));
        
        
        
        
        pack();

	}
	
	
	public void addToLog(String log)
	{
		rowsCount++;
		if(rowsCount == 100)
		{
			rowsCount = 0;
			FileEditor.addToFile(textArea.getText()); 
			textArea.setText( new Date().toString()+ " " + log + "\n");
		}
		else {
			textArea.setText(textArea.getText() + new Date().toString()+ " " + log + "\n");
		}
		
	}
	
	private void deleteLine()
	{
		textArea.replaceRange(null, 0, textArea.getText().indexOf("\n")+1);
		rowsCount--;
	}
}
