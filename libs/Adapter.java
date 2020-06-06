/*
 * Maxwell Goulding-Miles
 * CS 410
 * Sara Farag
 * Spring 2020
 * 
 * NOTES: I had to code in the classification for the status because it was not returning
 * the right values, other classmates had similar issues
 */
package libs;

import sensor.*;
import java.awt.Color;

public class Adapter implements AdapterInterface{
	public PressureSensor pSensor = new PressureSensor();
	public RadiationSensor rSensor = new RadiationSensor();
	public TemperatureSensor tSensor = new TemperatureSensor();
	
	// Pressure Sensor variables
	public double presReading;
	public String presStatus;
	public String presName;
	public Color presColor;
	
	// Radiation Sensor variables	
	public double radReading;
	public String radStatus;
	public String radName;
	public Color radColor;
	
	// Temperature Sensor variables
	public double tempReading;
	public String tempStatus;
	public String tempName;
	public Color tempColor;
	
	public Adapter() {
		pSensor = new PressureSensor();
		presReading = 0.0;
		radReading = 0.0;
		tempReading = 0.0;
		presStatus = "";
		radStatus = "";
		tempStatus = "";
		presName = "";
		radName = "";
		tempName = "";
		presColor = null;
		radColor = null;
		tempColor = null;
	}
	
	@Override
	public double getPresReading() {
//		presReading = pSensor.readValue();
		return presReading;
	}
	
	@Override
	public String getPresStatus() {
		//presStatus = pSensor.getReport();
		return presStatus;
	}
	
	@Override
	public String getPresName() {
//		presName = pSensor.getSensorName();
		return presName;
	}
	
	@Override
	public Color getPresColor() {
		return presColor;
	}
	
	public void setPressure() {
		presName = pSensor.getSensorName();
		presStatus = pSensor.getReport();
		presReading = pSensor.readValue();
		
		if (presReading < 5.0) {
			presStatus = "OK";
		} else if (presReading >= 3.0 && presReading <= 6.58) {
			presStatus = "CRITICAL";
		} else if (presReading > 6.58) {
			presStatus = "DANGER";
		}
		
		if (presStatus == "OK") presColor = Color.GREEN;
		else if (presStatus == "CRITICAL") presColor = Color.YELLOW;
		else if (presStatus == "DANGER") presColor = Color.RED;
	}
	
	@Override
	public double getRadReading() {
//		radReading = rSensor.getRadiationValue();
		return radReading;
	}
	
	@Override
	public String getRadStatus() {
//		radStatus = rSensor.getStatusInfo();
		return radStatus;
	}
	
	@Override
	public String getRadName() {
//		radName = rSensor.getName();
		return radName;
	}
	
	@Override
	public Color getRadColor() {
		return radColor;
	}
	
	public void setRadiation() {
		radName = rSensor.getName();
		radStatus = rSensor.getStatusInfo();
		radReading = rSensor.getRadiationValue();
		
		if (radReading < 3.0) {
			radStatus = "OK";
		} else if (radReading >= 3.0 && radReading <= 4.0) {
			radStatus = "CRITICAL";
		} else if (radReading > 4.0) {
			radStatus = "DANGER";
		}

		if (radStatus == "OK") radColor = Color.GREEN;
		else if (radStatus == "CRITICAL") radColor = Color.YELLOW;
		else if (radStatus == "DANGER") radColor = Color.RED;
	}
	
	@Override
	public double getTempReading() {
//		tempReading = tSensor.senseTemperature();
		return tempReading;
	}
	
	@Override
	public String getTempStatus() {
//		tempStatus = tSensor.getTempReport();
		return tempStatus;
	}
	
	@Override
	public String getTempName() {
//		tempName = tSensor.getSensorType();
		return tempName;
	}
	
	@Override
	public Color getTempColor() {
		return tempColor;
	}

	public void setTemperature() {
		tempName = tSensor.getSensorType();
		tempStatus = tSensor.getTempReport();
		tempReading = tSensor.senseTemperature();
		
		if (tempReading < 235.0) {
			tempStatus = "OK";
		} else if (tempReading >= 235.0 && tempReading <= 300.0) {
			tempStatus = "CRITICAL";
		} else if (tempReading > 300.0) {
			tempStatus = "DANGER";
		}
		
		if (tempStatus == "OK") tempColor = Color.GREEN;
		else if (tempStatus == "CRITICAL") tempColor = Color.YELLOW;
		else if (tempStatus == "DANGER") tempColor = Color.RED;
	}

}

