import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
public class color extends JFrame implements AdjustmentListener{
	private JRadioButtonMenuItem fire,note;
	JScrollBar s1;
	JScrollBar s2;
	JScrollBar s3;
	int r=0,g=0,b=0;
	JFrame f = new JFrame("color");
	Container contentPane = f.getContentPane();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel("r,g,b",JLabel.CENTER);
	public color()
	{
		JPanel p1 = new JPanel(new GridLayout(4,1));
		JPanel p2 = new JPanel(new GridLayout(1,1));
		JPanel p3 = new JPanel(new GridLayout(1,1));
		JPanel p4 = new JPanel(new GridLayout(2,1));
		JPanel p5 = new JPanel(new GridLayout(3,1));

		label1.setBackground(new Color(r,g,b));
		label1.setOpaque(true);
		label2.setForeground(Color.WHITE);
		p2.add(label1);
		p3.add(label1);
		s1 = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);
		// value, extent, min, max
		p5.add(s1);
		s1.addAdjustmentListener(this);
		s2 = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);
		p5.add(s2);
		s2.addAdjustmentListener(this);
		s3 = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);
		p5.add(s3);
		s3.addAdjustmentListener(this);
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		p1.add(p5);
		contentPane.add(p1);
		contentPane.add(label2, BorderLayout.NORTH);
		f.setSize(new Dimension(400,400));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setLocation(400, 200);
	}
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		if ((JScrollBar)e.getSource() == s1)
		{
			r = e.getValue();
		}
		if ((JScrollBar)e.getSource() == s2)
		{
			g = e.getValue();
		}
		if ((JScrollBar)e.getSource() == s3)
		{
			b = e.getValue();
		}
		label1.setBackground(new Color(r, g, b));
		label2.setText("r"+r+" g"+g+" b"+b);

		if(r==255&&g==167&&b==79){
			String str;
			str="你點燃了火把，\n在桌上發現了一張紙";
			UIManager UI=new UIManager();
			UI.put("OptionPane.background",new Color(255,167,79));
			UI.put("Panel.background",new Color(255,167,79));
			UI.put("OptionPane.messageForeground", Color.black);
			JOptionPane.showMessageDialog(null,str,"message", JOptionPane.PLAIN_MESSAGE);
			f.dispose();
		}
	}
	public static void main(String[] arg){
		new color();
	}
}