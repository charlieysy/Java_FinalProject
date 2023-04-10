import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.UIManager;
public class GuessNum extends JFrame {
	private JSlider sliderV;
	private JSlider sliderH;
	private JLabel lb1;
	private JLabel lb2;
	public static int r=0;
	public int v1=0;
	public int v2=0;
	public static int v3=0;
	public int A=0;
	public int B=0;
	public int c=0;
	public int[] ans = new int[4];
	public GuessNum() {
		final JFrame frame = new JFrame("guess");
		JButton guess = new JButton("START");
		guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				r = (int)(Math.random()*9999)+1;	//產生亂數
				String str;
				str="r="+r;
				JOptionPane.showMessageDialog(null,str,"How to play", JOptionPane.PLAIN_MESSAGE);
				for (int i = 3; i >= 0; i --){
					ans[i] = r%10;
					r/=10;
				}
			}
		});
		//create a slider
		lb1 = new JLabel("5000");
		lb2 = new JLabel("0A0B");
		sliderV = new JSlider(JSlider.VERTICAL,0,100,50);
		sliderV.setPaintTicks(true);
		sliderV.setMinorTickSpacing(5);
		sliderH = new JSlider(JSlider.HORIZONTAL,0,100,50);
		sliderH.setPaintTicks(true);
		sliderH.setMinorTickSpacing(5);
		sliderV.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				JSlider s1 = (JSlider)evt.getSource();
				if ( !s1.getValueIsAdjusting() ) {
					v1 = (int)s1.getValue();
					lb1.setText(Integer.toString(100*v1+v2));
					v3=100*v1+v2;
				}
				sliderH.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent evt) {
						JSlider s2 = (JSlider)evt.getSource();
						if ( !s2.getValueIsAdjusting() ) {
							v2 = (int)s2.getValue();
							lb1.setText(Integer.toString(100*v1+v2));
							//System.out.print(100*v1+v2);
							v3=100*v1+v2;
						}
						//v3=100*v1+v2;
						int[] num = new int[4];
						for (int i = 3; i >= 0; i --){
							num[i] = v3%10;
							v3/=10;
						}
						for(int i=0;i<4;i++){
						   if(ans[i]==num[i])
						   A++;
						}
						for(int i=0;i<4;i++){
							for(int j=0;j<4;j++){
								if(ans[j]==num[i]){
									B++;
									break;
								}
							}
						}
						if(A==4){
							//System.out.print("win");
							lb2.setText("Win");
							String str="恭喜你解開了密碼，\n你逃出了這裡";
							Object[] buttons = {"exit"};
							int res = JOptionPane.showOptionDialog(null,
										str,"Congratulations!",
										JOptionPane.NO_OPTION, JOptionPane.NO_OPTION, null,buttons , buttons[0]);
							frame.dispose();
							System.exit(0);
						}
						else{
							c=B-A;
							//System.out.print(A+"A"+c+"B");
							String result;
							result=A+"A"+c+"B";
							lb2.setText(result);
							A=0;B=0;c=0;
						}
					} 
				});
			}
		});
		frame.getContentPane().add(sliderV);
		frame.add(lb1, BorderLayout.CENTER);	//num
		frame.add(guess,BorderLayout.CENTER);	//button
		frame.add(lb2, BorderLayout.CENTER);	//AB
		frame.getContentPane().add(sliderH);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.setLocation(400, 200);
	}
	public static void main(String[] args) {
		new GuessNum();
	}
}