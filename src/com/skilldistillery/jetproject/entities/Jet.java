package com.skilldistillery.jetproject.entities;

import java.util.Objects;

public abstract class Jet {

	private String model;
	private double speed, price;
	private int range;
	private Pilot pilot;
	
	
	
	public Jet(Pilot pilot, String model, double speed, double price, int range) {
		super();
		this.pilot = pilot;
		this.model = model;
		this.speed = speed;
		this.price = price;
		this.range = range;
	}
	
	public Jet() {
		
	}
	
	public void fly() {
//		System.out.println(this);
		System.out.println("\n"+this.model +" can fly for "+ (double)((int)((this.range/this.speed)*10))/10+" hours.");
		System.out.println(this.pilot.getName()+", callsign "+this.pilot.getCallsign()+", is at the stick.\n");
	}
	
	public String fileFormat() { // to properly format the entry in the text file to save fleet
		return ("JetImpl\t"+this.getModel() + "\t" + this.getSpeed() + "\t" + this.getPrice() + "\t" + this.getRange() + "\tNA\tNA\tNA\tNA\tNA");
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	
	public Pilot getPilot() {
		return pilot;
	}
	
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Passenger Jet [model=");
		builder.append(model);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(" MPH, price=$");
		builder.append(price);
		builder.append(", range=");
		builder.append(range);
		builder.append(" Miles]");
		builder.append("\nPilot: ");
		builder.append(pilot.getName());
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}
	
	
	
}
