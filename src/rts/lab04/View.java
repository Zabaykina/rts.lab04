package rts.lab04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class View {

	private JFrame frame;
	private JTextField textFieldCountReader;
	private JTextField textFieldCountWriter;
	private JTextArea textArea = new JTextArea();
	private Controller controller;
	private JButton btnStart = new JButton("Start");
	JButton btnStop = new JButton("Stop");

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 308, 138, 0 };
		gridBagLayout.rowHeights = new int[] { 262, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(5, 10, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);

		scrollPane.setViewportView(textArea);

		JPanel controlPanel = new JPanel();
		GridBagConstraints gbc_controlPanel = new GridBagConstraints();
		gbc_controlPanel.anchor = GridBagConstraints.WEST;
		gbc_controlPanel.fill = GridBagConstraints.VERTICAL;
		gbc_controlPanel.gridx = 1;
		gbc_controlPanel.gridy = 0;
		frame.getContentPane().add(controlPanel, gbc_controlPanel);
		GridBagLayout gbl_controlPanel = new GridBagLayout();
		gbl_controlPanel.columnWidths = new int[] { 60, 32, 0 };
		gbl_controlPanel.rowHeights = new int[] { 14, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_controlPanel.columnWeights = new double[] { 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_controlPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		controlPanel.setLayout(gbl_controlPanel);

		JLabel lblCountReader = new JLabel("Количество читателей:");
		GridBagConstraints gbc_lblCountReader = new GridBagConstraints();
		gbc_lblCountReader.gridwidth = 2;
		gbc_lblCountReader.insets = new Insets(5, 0, 5, 5);
		gbc_lblCountReader.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCountReader.gridx = 0;
		gbc_lblCountReader.gridy = 0;
		controlPanel.add(lblCountReader, gbc_lblCountReader);

		textFieldCountReader = new JTextField();
		textFieldCountReader.setText("3");
		GridBagConstraints gbc_textFieldCountReader = new GridBagConstraints();
		gbc_textFieldCountReader.gridwidth = 2;
		gbc_textFieldCountReader.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCountReader.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCountReader.gridx = 0;
		gbc_textFieldCountReader.gridy = 1;
		controlPanel.add(textFieldCountReader, gbc_textFieldCountReader);
		textFieldCountReader.setColumns(10);

		JLabel lblCountWriter = new JLabel("Количество писателей:");
		GridBagConstraints gbc_lblCountWriter = new GridBagConstraints();
		gbc_lblCountWriter.anchor = GridBagConstraints.WEST;
		gbc_lblCountWriter.gridwidth = 2;
		gbc_lblCountWriter.insets = new Insets(0, 0, 5, 5);
		gbc_lblCountWriter.gridx = 0;
		gbc_lblCountWriter.gridy = 2;
		controlPanel.add(lblCountWriter, gbc_lblCountWriter);

		textFieldCountWriter = new JTextField();
		textFieldCountWriter.setText("3");
		GridBagConstraints gbc_textFieldCountWriter = new GridBagConstraints();
		gbc_textFieldCountWriter.gridwidth = 2;
		gbc_textFieldCountWriter.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCountWriter.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCountWriter.gridx = 0;
		gbc_textFieldCountWriter.gridy = 3;
		controlPanel.add(textFieldCountWriter, gbc_textFieldCountWriter);
		textFieldCountWriter.setColumns(10);

		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 8;
		controlPanel.add(btnStart, gbc_btnStart);

		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.gridx = 1;
		gbc_btnStop.gridy = 8;
		controlPanel.add(btnStop, gbc_btnStop);

		controller = new Controller(textArea);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnStop.setEnabled(true);
				btnStart.setEnabled(false);
				controller.start(
						Integer.valueOf(textFieldCountReader.getText()),
						Integer.valueOf(textFieldCountWriter.getText()));
			}
		});
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();
				btnStop.setEnabled(false);
				btnStart.setEnabled(true);
			}
		});
		btnStop.setEnabled(false);
		frame.setVisible(true);
	}

}
