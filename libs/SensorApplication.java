/*
 * Maxwell Goulding-Miles
 * CS 410
 * Sara Farag
 * Spring 2020
 */
package libs;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SensorApplication extends JFrame {
	
	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		
		Adapter pAdaptor = new Adapter();
		
		pAdaptor.setPressure();
		pAdaptor.setRadiation();
		pAdaptor.setTemperature();

		// Create JPanel for Pressure, Radiation, and Temp sensors
		JPanel pressurePnl = new JPanel();
		JPanel radiationPnl = new JPanel();
		JPanel temperaturePnl = new JPanel();
		
		JLabel pressureLabel = new JLabel(pAdaptor.presStatus + "-->" + pAdaptor.presReading);
		JLabel radiationLabel = new JLabel(pAdaptor.radStatus + "-->" + pAdaptor.radReading);
		JLabel temperatureLabel = new JLabel(pAdaptor.tempStatus + "-->" + pAdaptor.tempReading);
		
		// Title sensor border and add to JFrame
		pressurePnl.setBorder(new TitledBorder(pAdaptor.getPresName()));
		pressurePnl.add(pressureLabel);
		pressurePnl.setBackground(pAdaptor.presColor);
		add(pressurePnl);
		
		radiationPnl.setBorder(new TitledBorder(pAdaptor.getRadName()));
		radiationPnl.add(radiationLabel);
		radiationPnl.setBackground(pAdaptor.radColor);
		add(radiationPnl);
		
		temperaturePnl.setBorder(new TitledBorder(pAdaptor.getTempName()));
		temperaturePnl.add(temperatureLabel);
		temperaturePnl.setBackground(pAdaptor.tempColor);
		add(temperaturePnl);		
		
		setPreferredSize(new Dimension(300,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}

}
