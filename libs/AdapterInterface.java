/*
 * Maxwell Goulding-Miles
 * CS 410
 * Sara Farag
 * Spring 2020
 */
package libs;

import java.awt.Color;

public interface AdapterInterface {
	public double getPresReading();
	public String getPresStatus();
	public String getPresName();
	public Color getPresColor();
	
	public double getRadReading();
	public String getRadStatus();
	public String getRadName();
	public Color getRadColor();
	
	public double getTempReading();
	public String getTempStatus();
	public String getTempName();
	public Color getTempColor();
}