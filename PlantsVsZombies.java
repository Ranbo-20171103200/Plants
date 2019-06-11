package me.tikiwong.PlantsVsZombies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlantsVsZombies extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] ages) {
		new PlantsVsZombies();
	}
	
	public PlantsVsZombies() {
		JPanel p = new JPanel();
		JButton b = new JButton("×ßÄã");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Timer().schedule(new TimerTask() {

					@Override
					public void run() {
						onInject();
						
					}
					
				}, 0,200);
				
			}
			
		});
		p.add(b);
		this.add(p);
		this.setTitle("¶ñÄ§ÃÃÃÃÃþßäßä");
		this.setSize(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void onInject() {
		/**
		 * »ùÖÊ 006a9ec0
		 * 
		 * ÓÎÏ·Æ«ÒÆ 768
		 * 
		 * Ñô¹âÆ«ÒÆ 5560
		 * 
		 * ÎÞcd  144 70+i*50
		 * 00488F41 C7 47 49 01 00 00 00
		 */
		int processId = Memory.DprocessId("PlantsVsZombies.exe");
		int baseAddress=Memory.readMemory(processId,0x6a9ec0);
		baseAddress=Memory.readMemory(processId,baseAddress+0x768);
		Memory.writeMemory(processId, baseAddress+0x5560, 999999);
		for (int i = 0; i<8; i ++) {
			int kc = i*0x50+0x70;
			int b2 = Memory.readMemory(processId,baseAddress+0x144);
			Memory.writeMemory(processId, b2+kc, 1);
		}
		
	}
}
