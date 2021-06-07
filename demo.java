import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;

public class demo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final static String newline = "\n";
	read yomu = new read();
	public String start;
	public String end;
	public String output;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		read yomu = new read();
    	yomu.loadData();
		String m,n;
    	Graph g = new Graph();
    	
    	// khoi tao do thi thi du lieu da doc 
		for (int i = 0; i < yomu.vertex;i++) {
			for (int j = 0; j < yomu.vertex; j++)
			{
				if ((yomu.arr[i][j])>0) {
					m = String.valueOf(i+1);
					n = String.valueOf(yomu.arr[i][j]);
					g.addEdge(m, n);
				}
			}
		}
		/// 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo frame = new demo(g);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	/**
	 * Create the frame.
	 */
	public demo(Graph g) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 221, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Source Vertex");
		lblNewLabel.setBounds(10, 85, 113, 28);
		panel.add(lblNewLabel);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(133, 85, 72, 28);
		panel.add(lblDestination);
		
		textField = new JTextField();
		textField.setBounds(10, 112, 72, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 112, 72, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search Path");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output = "";
				start = textField.getText();
				end = textField_1.getText();
				LinkedList<String> visited = new LinkedList();
				visited.add(start);
				Search sagasu = new Search(start,end);
				sagasu.depthFirst(g,visited);
				textField_2.setText(sagasu.output);
				System.out.println(sagasu.output);
			}
		});
		btnNewButton_1.setBounds(44, 151, 122, 28);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Save Image");
		btnNewButton_2.setBounds(45, 245, 121, 28);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(220, 273, 474, 146);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 11, 454, 124);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(220, 0, 474, 273);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	}
}
