package com.skilldistillery.jetproject.entities;

import java.util.Objects;

public class SpacePlane extends JetImpl implements SpaceCapable{

	private int maxOrbitalAltitude;
	private int oxygenSupplyInHours;
	
	public SpacePlane() {

	}
	public SpacePlane(Pilot pilot, String model, double speed, double price, int range, int altitude, int oxygen) {
		super(pilot, model, speed, price, range);
		this.maxOrbitalAltitude = altitude;
		this.oxygenSupplyInHours = oxygen;
	}
	
	@Override
	public String fileFormat() {
		return "SpacePlane\t" + this.getModel() + "\t" + this.getSpeed() + "\t" + this.getPrice() + "\t"
				+ this.getRange() + "\t" +this.maxOrbitalAltitude+"\t"+this.oxygenSupplyInHours +"\tNA\tNA\tNA";
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Space Plane [model=");
		builder.append(getModel());
		builder.append(", Speed=");
		builder.append(getSpeed());
		builder.append(" MPH, Price=$");
		builder.append(getPrice());
		builder.append(", Range=");
		builder.append(getRange());
		builder.append(" Miles, maxOrbitalAltitude=");
		builder.append(maxOrbitalAltitude);
		builder.append(" Miles, oxygenSupplyInHours=");
		builder.append(oxygenSupplyInHours);
		builder.append("]");
		builder.append("\nPilot: ");
		builder.append(this.getPilot().getName());
		return builder.toString();
	}
	@Override
	public void activateRockets() {
		System.out.println("\n"+this.getModel()+" is taking flight.  Activating rocket engines.  Climbing to orbital altitude of "+maxOrbitalAltitude+" miles.");
		System.out.println("Oxygen endurance is "+ oxygenSupplyInHours+" hours.");
		System.out.println(this.getPilot().getCallsign()+" is in command!");
	}
	@Override
	public void deOrbitBurn() {
		System.out.println("Activating retrograde engines.  Atmospheric contact in "+((int)(Math.random()*11)+15)+" minutes.");
	}
	public int getMaxOrbitalAltitude() {
		return maxOrbitalAltitude;
	}
	public void setMaxOrbitalAltitude(int maxOrbitalAltitude) {
		this.maxOrbitalAltitude = maxOrbitalAltitude;
	}
	public int getOxygenSupplyInHours() {
		return oxygenSupplyInHours;
	}
	public void setOxygenSupplyInHours(int oxygenSupplyInHours) {
		this.oxygenSupplyInHours = oxygenSupplyInHours;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(maxOrbitalAltitude, oxygenSupplyInHours);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpacePlane other = (SpacePlane) obj;
		return Double.doubleToLongBits(maxOrbitalAltitude) == Double.doubleToLongBits(other.maxOrbitalAltitude)
				&& Double.doubleToLongBits(oxygenSupplyInHours) == Double.doubleToLongBits(other.oxygenSupplyInHours);
	}
	
	
	
	
}
