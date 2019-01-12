package com.skilldistillery.makechange;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CashRegisterGUI {
    private JPanel rightPanel, leftPanel;
    private JTextField inputTextBox1, inputTextBox2;
    private JLabel labelPrice, labelPayment;
    private JButton goButton;
    private JTextArea textArea;

    CashRegisterGUI() {
	rightPanel = new JPanel();
	textArea = new JTextArea(10, 20);
	rightPanel.add(textArea);

	labelPrice = new JLabel(" Purchase Price: ");
	labelPayment = new JLabel("Cash Tendered: ");

	inputTextBox1 = new JTextField(5);
	inputTextBox2 = new JTextField(5);
	goButton = new JButton("Calculate");

	leftPanel = new JPanel();
	GroupLayout layout = new GroupLayout(leftPanel);
	leftPanel.setLayout(layout);
	layout.setAutoCreateGaps(true);
	layout.setAutoCreateContainerGaps(true);
	
	GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
	hGroup.addGroup(layout.createParallelGroup().addComponent(labelPrice).addComponent(labelPayment));
	hGroup.addGroup(layout.createParallelGroup().addComponent(inputTextBox1).addComponent(inputTextBox2).addComponent(goButton));
	
	GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
	vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(labelPrice).addComponent(inputTextBox1));
	vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(labelPayment).addComponent(inputTextBox2));
	vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(goButton));
	
	layout.setVerticalGroup(vGroup);
	layout.setHorizontalGroup(hGroup);
    }

    public void useGUI() {
	JFrame frame = new JFrame();
	frame.setTitle("Cash Register");
	frame.getContentPane().add(BorderLayout.EAST, rightPanel);
	frame.getContentPane().add(BorderLayout.CENTER, leftPanel);
	frame.setSize(500, 300);
	frame.pack();
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
