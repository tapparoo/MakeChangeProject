package com.skilldistillery.makechange;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton button;
    private JTextArea textArea;

    CashRegisterGUI() {
	rightPanel = new JPanel();
	Font font = new Font("Courier New", Font.PLAIN, 13);
	textArea = new JTextArea(15, 35);
	textArea.setFont(font);
	rightPanel.add(textArea);

	labelPrice = new JLabel(" Purchase Price: ");
	labelPayment = new JLabel("Cash Tendered: ");

	inputTextBox1 = new JTextField(5);
	inputTextBox2 = new JTextField(5);
	button = new JButton("Calculate");

	leftPanel = new JPanel();
	GroupLayout layout = new GroupLayout(leftPanel);
	leftPanel.setLayout(layout);
	layout.setAutoCreateGaps(true);
	layout.setAutoCreateContainerGaps(true);
	
	GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
	hGroup.addGroup(layout.createParallelGroup().addComponent(labelPrice).addComponent(labelPayment));
	hGroup.addGroup(layout.createParallelGroup().addComponent(inputTextBox1).addComponent(inputTextBox2).addComponent(button));
	
	GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
	vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(labelPrice).addComponent(inputTextBox1));
	vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(labelPayment).addComponent(inputTextBox2));
	vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(button));
	
	layout.setVerticalGroup(vGroup);
	layout.setHorizontalGroup(hGroup);
	
	ActionListener listener = new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		double totalPrice, cashTendered;
		CashRegister register;
		
		try {
			totalPrice = Double.parseDouble(inputTextBox1.getText());
			cashTendered = Double.parseDouble(inputTextBox2.getText());
			register = new CashRegister(totalPrice, cashTendered);
			textArea.setText(register.makeChange());
		    } catch (Exception error) {
			textArea.setText("Invalid input.");
			System.out.println(error);
		    }
	    }
	};
	
	button.addActionListener(listener);
	inputTextBox1.addActionListener(listener);
	inputTextBox2.addActionListener(listener);
    }

    public void init() {
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
