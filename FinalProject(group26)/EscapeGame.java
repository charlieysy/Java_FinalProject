import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
public class EscapeGame extends JFrame implements ActionListener{
	private static JLabel lb1;
	Frame frame;
	Menu menu;
	MenuItem torch,note,box;
	color color;
	GuessNum guessnum;
	//FifteenPuzzle puzzle;
	public EscapeGame() {
		frame = new Frame("Escape Game");
		frame.setLayout(new FlowLayout());
		frame.setSize(300,300);  // �]�w�����ؤo
		frame.setLocation(400,200);
		frame.setBackground(Color.BLACK);
		note = new MenuItem("note");
		note.addActionListener(this);
		box = new MenuItem("box");
		box.addActionListener(this);
		torch = new MenuItem("torch");
		torch.addActionListener(this);
		menu = new Menu("menu");
		menu.add(torch);
		MenuBar menubar = new MenuBar();
		menubar.add(menu);
		frame.setMenuBar(menubar);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		MenuItem m = (MenuItem) e.getSource();
		if(m.getLabel() == "torch"){
			final JFrame f2 = new JFrame("message");
			f2.setLayout(new FlowLayout());
			f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f2.setSize(250, 150);
			f2.setVisible(true);
			f2.setLocation(700, 300);
			lb1 = new JLabel("<html>�A�`�۷L�z�����u���F�@�Ӥ���A<br/>�W����ۤT�ӼƦr<br/>255,167,79</html>");
			lb1.setForeground(Color.WHITE);
			f2.add(lb1, BorderLayout.CENTER);
			Button ok=new Button("CLOSE");
			ok.setBounds(300, 300, 50, 50);//���Z�A�W�Z�A�e�A��
			ok.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					f2.dispose();
				}
			});
			f2.add(ok);
			color=new color();
			frame.setBackground(new Color(255, 167, 79));
			menu.add(note);
		}
		if (m.getLabel() == "note") {
			final JFrame f3 = new JFrame("message");
			f3.setLayout(new FlowLayout());
			f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f3.setSize(250, 150);
			f3.setVisible(true);
			f3.setLocation(700, 300);
			lb1 = new JLabel("<html>�A�o�{�F�@�Ӳ��l�A</html>");
			lb1.setForeground(Color.WHITE);
			f3.add(lb1, BorderLayout.CENTER);
			Button ok=new Button("CLOSE");
			ok.setBounds(300, 300, 50, 50);//���Z�A�W�Z�A�e�A��
			ok.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					f3.dispose();
				}
			});
			f3.add(ok);
			menu.add(box);
		}
		if (m.getLabel() == "box") {
			final JFrame f3 = new JFrame("message");
			f3.setLayout(new FlowLayout());
			f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f3.setSize(250, 150);
			f3.setVisible(true);
			f3.setLocation(700, 300);
			lb1 = new JLabel("<html>�o�Ӳ��l�W���ӱK�X��<br>�иѶ}��</html>");
			lb1.setForeground(Color.WHITE);
			f3.add(lb1, BorderLayout.CENTER);
			Button ok=new Button("CLOSE");
			ok.setBounds(300, 300, 50, 50);//���Z�A�W�Z�A�e�A��
			ok.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					f3.dispose();
				}
			});
			f3.add(ok);
			guessnum=new GuessNum();
		}
	}
	public static void main(String[] args) {
		final Frame f=new Frame(); 
		f.setTitle("Escape Game");

		Button start=new Button("start");
		start.setBounds(100, 70, 100, 30);	//���Z�A�W�Z�A�e�A��
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String str;
				str="�A�{�b�Q�x�@�Ӷ·t���������A\n�Юھڴ��ܧ��u���}���C\n\n";
				UIManager UI=new UIManager();
				UI.put("OptionPane.background", Color.black);
				UI.put("Panel.background", Color.black);
				UI.put("OptionPane.messageForeground", Color.white);
				JOptionPane.showMessageDialog(null,str,"message", JOptionPane.PLAIN_MESSAGE);
				f.dispose();
				new EscapeGame();
				String str2;
				str2="���I��'menu'�d��\n\n";
				JOptionPane.showMessageDialog(null,str2,"How to play", JOptionPane.PLAIN_MESSAGE);
			}
		});
		Button rule=new Button("How to play");
		rule.setBounds(100, 140, 100, 30);
		rule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String str;
				str="�Юھګ��ܶi��ާ@";
				UIManager UI=new UIManager();
				UI.put("OptionPane.background", Color.black);
				UI.put("Panel.background", Color.black);
				UI.put("OptionPane.messageForeground", Color.white);
				JOptionPane.showMessageDialog(null,str,"How to play", JOptionPane.PLAIN_MESSAGE);
				final Frame f2=new Frame();
			}
		});
		Button exit=new Button("Exit");
		exit.setBounds(100, 210, 100, 30);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		f.add(start);
		f.add(rule);
		f.add(exit);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocation(400, 200);
		f.setBackground(Color.BLACK);
		f.addWindowListener(new WindowAdapter(){  //�������������@��
		public void windowClosing (WindowEvent e){System.exit(0);}});
	}
}