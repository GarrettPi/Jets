package com.skilldistillery.jetproject.entities;

import java.util.Objects;

public class CargoJet extends JetImpl {

	private double cargoCapInTons;

	@Override
	public String fileFormat() {
		return ("CargoJet\t"+this.getModel() + "\t" + this.getSpeed() + "\t" + this.getPrice() + "\t" + this.getRange() + "\t"
				+ "NA\tNA\t" + this.getCargoCapInTons() + "\tNA\tNA");
	}

	public double getCargoCapInTons() {
		return cargoCapInTons;
	}

	public void setCargoCapInTons(double cargoCapInTons) {
		this.cargoCapInTons = cargoCapInTons;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cargo Jet [model=");
		builder.append(getModel());
		builder.append(", speed=");
		builder.append(getSpeed());
		builder.append(" MPH, price=$");
		builder.append(getPrice());
		builder.append(", range=");
		builder.append(getRange());
		builder.append(" Miles, cargoCapInTons=");
		builder.append(cargoCapInTons);
		builder.append("]");
		builder.append("\nPilot: ");
		builder.append(this.getPilot().getName());
		return builder.toString();
	}

	public CargoJet() {
	}

	public CargoJet(Pilot pilot, String model, double speed, double price, int range, double cargoCap) {
		super(pilot, model, speed, price, range);
		this.cargoCapInTons = cargoCap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cargoCapInTons);
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
		CargoJet other = (CargoJet) obj;
		return Double.doubleToLongBits(cargoCapInTons) == Double.doubleToLongBits(other.cargoCapInTons);
	}

}
