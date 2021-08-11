package com.skilldistillery.jetproject.entities;

import java.util.Objects;

public class StealthReconJet extends JetImpl implements StealthCapable {

	private double cloakEfficiency;
	private int cloakEndurance;

	@Override
	public void activateCloakingDevice() {
		System.out.println("\n"+this.getModel() + " is activating its cloaking device.");
		System.out.println("The cloak will last for " + cloakEndurance + " hours.");
		System.out.println(this.getPilot().getCallsign()+" is in command!");

	}

	@Override
	public void deactivateCloakingDevice() {
		System.out.println("So'wI' yIchu'Ha'!");

	}

	@Override
	public String fileFormat() {
		return "StealthReconJet\t" + this.getModel() + "\t" + this.getSpeed() + "\t" + this.getPrice() + "\t"
				+ this.getRange() + "\tNA\tNA\tNA\t" + this.getCloakEfficiency() + "\t" + this.getCloakEndurance();
	}

	public StealthReconJet() {

	}

	public StealthReconJet(Pilot pilot, String model, double speed, double price, int range, double cloakEfficiency,
			int cloakEndurance) {
		super(pilot, model, speed, price, range);
		this.cloakEfficiency = cloakEfficiency;
		this.cloakEndurance = cloakEndurance;
	}

	public double getCloakEfficiency() {
		return cloakEfficiency;
	}

	public void setCloakEfficiency(double cloakEfficiency) {
		this.cloakEfficiency = cloakEfficiency;
	}

	public int getCloakEndurance() {
		return cloakEndurance;
	}

	public void setCloakEndurance(int cloakEndurance) {
		this.cloakEndurance = cloakEndurance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stealth Recon Jet [model=");
		builder.append(getModel());
		builder.append(", speed=");
		builder.append(getSpeed());
		builder.append(" MPH, price=$");
		builder.append(getPrice());
		builder.append(", range=");
		builder.append(getRange());
		builder.append(" Miles, cloakEfficiency=");
		builder.append(cloakEfficiency);
		builder.append(", cloakEndurance=");
		builder.append(cloakEndurance);
		builder.append(" Hours]");
		builder.append("\nPilot: ");
		builder.append(this.getPilot().getName());
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cloakEfficiency, cloakEndurance);
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
		StealthReconJet other = (StealthReconJet) obj;
		return Double.doubleToLongBits(cloakEfficiency) == Double.doubleToLongBits(other.cloakEfficiency)
				&& cloakEndurance == other.cloakEndurance;
	}

}
