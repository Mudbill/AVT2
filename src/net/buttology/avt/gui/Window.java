package net.buttology.avt.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.buttology.avt.main.EProgressionType;
import net.buttology.avt.main.EventHandler;
import net.buttology.avt.main.Main;
import net.buttology.avt.main.VideoToolOptions;

public class Window {

	private JFrame frmAmnesiaVideoTool;
	private JTextField inputFilePrefix;

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ToolTipManager.sharedInstance().setDismissDelay(10000);
		
		frmAmnesiaVideoTool = new JFrame();
		frmAmnesiaVideoTool.setMinimumSize(new Dimension(306, 390));
		frmAmnesiaVideoTool.setTitle(Main.APP_NAME + " v" + Main.APP_VERSION);
		frmAmnesiaVideoTool.setBounds(100, 100, 429, 395);
		frmAmnesiaVideoTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblFileSetup = new JLabel("File setup");
		lblFileSetup.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAnimation = new JLabel("Animation");
		lblAnimation.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblExportOptions = new JLabel("Export options");
		lblExportOptions.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton buttonGenerate = new JButton("Generate files");

		GroupLayout groupLayout = new GroupLayout(frmAmnesiaVideoTool.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(lblFileSetup)
						.addComponent(lblAnimation)
						.addComponent(lblExportOptions)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(buttonGenerate, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFileSetup)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAnimation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblExportOptions)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonGenerate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		
		JCheckBox checkMaterial = new JCheckBox("Material files (*.mat)");
		checkMaterial.setToolTipText("Export mat files for your sequence (required to display in-game)");
		
		JCheckBox checkEntity = new JCheckBox("Entity files (*.ent)");
		checkEntity.setToolTipText("Export ent files for your sequence (required to display in-game)");
		
		JCheckBox checkScript = new JCheckBox("Level script file (*.hps)");
		checkScript.setToolTipText("Export a script file containing the required script to use to run your animation in-game.");
		
		JCheckBox checkVideoFiles = new JCheckBox("Video placeholder files (.dae, .msh, .mat, .dds)");
		checkVideoFiles.setToolTipText("Export the required video files. You need at least 1 set of these in the same folder as your animation for it to work in-game.");
		
		JCheckBox checkMini = new JCheckBox("Minimalized");
		checkMini.setToolTipText("Check this if you want the script to be shortened to 1 line. Useful if you don't want the script cluttering your hps file. Do not check this if you want editable and documented script.");
		checkMini.setEnabled(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(checkEntity, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
						.addComponent(checkMaterial, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
						.addComponent(checkVideoFiles)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(checkScript)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(checkMini, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(checkMaterial)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(checkEntity)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(checkScript)
						.addComponent(checkMini))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(checkVideoFiles)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNumberOfFrames = new JLabel("Number of frames total");
		
		JSpinner spinnerFrameCount = new JSpinner();
		spinnerFrameCount.setModel(new SpinnerNumberModel(1, 1, 99999, 1));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNumberOfFrames)
					.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
					.addComponent(spinnerFrameCount, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfFrames)
						.addComponent(spinnerFrameCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		inputFilePrefix = new JTextField();
		inputFilePrefix.setToolTipText("Suffix for your image file sequence.");
		inputFilePrefix.setHorizontalAlignment(SwingConstants.RIGHT);
		inputFilePrefix.setText("frame_");
		inputFilePrefix.setColumns(10);
		
		JComboBox<String> comboFileExtension = new JComboBox<String>();
		comboFileExtension.setToolTipText("File extension for your image sequence.");
		comboFileExtension.setModel(new DefaultComboBoxModel<String>(new String[] {"jpg", "png", "gif", "tga", "dds"}));
		
		JComboBox<EProgressionType> comboFileProgression = new JComboBox<EProgressionType>();
		comboFileProgression.setToolTipText("The type of number progression used for frames. x+ is normal, others use x amount of digits (preceding zeros).");
		comboFileProgression.setModel(new DefaultComboBoxModel<EProgressionType>(EProgressionType.values()));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(inputFilePrefix, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(comboFileProgression, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboFileExtension, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputFilePrefix, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboFileProgression, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboFileExtension, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmAmnesiaVideoTool.getContentPane().setLayout(groupLayout);
		
		checkScript.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				checkMini.setEnabled(checkScript.isSelected());
			}
		});
		
		buttonGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VideoToolOptions options = new VideoToolOptions(
						inputFilePrefix.getText(),
						(EProgressionType) comboFileProgression.getSelectedItem(),
						comboFileExtension.getSelectedItem().toString(),
						(int) spinnerFrameCount.getValue(),
						checkMaterial.isSelected(),
						checkEntity.isSelected(),
						checkScript.isSelected(),
						checkMini.isSelected(),
						checkVideoFiles.isSelected()
					);
				
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(fc.showSaveDialog(frmAmnesiaVideoTool) == JFileChooser.APPROVE_OPTION) {
					String path = fc.getSelectedFile().getAbsolutePath();
					
					int fileCount = 0;
					if(options.isExportMaterial()) fileCount += options.getFrameCount();
					if(options.isExportEntity()) fileCount += options.getFrameCount();
					if(options.isExportScript()) fileCount++;
					if(options.isVideoFiles()) fileCount += 4;
					
					int result = JOptionPane.showConfirmDialog(frmAmnesiaVideoTool, "This will write "+fileCount+" files to the following directory:\n\n"+path+"\n\nFiles may be overwritten. Are you sure you wish to continue?", "Confirm", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION) {						
						EventHandler.generate(path, options);
					}
				}
			}
		});
	}
	
	public JFrame getFrame() {
		return frmAmnesiaVideoTool;
	}
}
