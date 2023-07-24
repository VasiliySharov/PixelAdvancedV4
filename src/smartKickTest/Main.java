package smartKickTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		JFrame frame = new JFrame("Two Fields Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel gp1 = main.new GreenPanel();
        JPanel gp2 = main.new GreenPanel();
        JPanel interruprtCD = main.new GreenPanel();
        
        JButton interrupt = new JButton("I");
        interrupt.setPreferredSize(new Dimension(50, 30));
        JButton cast = new JButton("C");
        cast.setPreferredSize(new Dimension(50, 30));
        

        
        frame.add(gp1);
        frame.add(gp2);
        frame.add(interruprtCD);
        frame.add(interrupt);
        frame.add(cast);
        
        interrupt.addActionListener(e-> {
        	if(gp1.getBackground().equals(Color.WHITE)) {
        		gp1.setBackground(Color.GREEN);
        		gp2.setBackground(Color.WHITE);
        		interruprtCD.setBackground(Color.GREEN);
        	}
        	SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    Thread.sleep(2000);
                    return null;
                }

                @Override
                protected void done() {
                    // This code will be executed after the delay
                    gp1.setBackground(Color.WHITE);
                }
            };
            
        	SwingWorker<Void, Void> worker1 = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                	
                    Thread.sleep(6000);
                    return null;
                }

                @Override
                protected void done() {
                    // This code will be executed after the delay
                	interruprtCD.setBackground(Color.WHITE);
                }
            };

            worker.execute(); // Start the SwingWorker
            worker1.execute();
        });
        
        cast.addActionListener(e-> {
        	if(gp2.getBackground().equals(Color.WHITE)) {
        		gp2.setBackground(Color.GREEN);
        	} else {
        		gp2.setBackground(Color.WHITE);
        	}
        });
        
        frame.setLocation(0, 730);
        frame.setSize(300, 100);
        frame.setVisible(true);
        

	}

	class GreenPanel extends JPanel {
		
        GreenPanel() {
            setPreferredSize(new Dimension(30, 30));
            setBackground(Color.WHITE); // Set the background color here
        }
	}
	protected void sleep(int millis){
		try {Thread.sleep(millis);} catch (InterruptedException e) {e.printStackTrace();}
	}
}
