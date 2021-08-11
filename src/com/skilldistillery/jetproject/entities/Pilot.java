package com.skilldistillery.jetproject.entities;

import java.util.Objects;

public class Pilot {

	private String name;
	private String callsign;

	public Pilot(String name, String callsign) {
		super();
		this.name = name;
		this.callsign = callsign;
	}

	public Pilot() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pilot [name=");
		builder.append(name);
		builder.append(", callsign=");
		builder.append(callsign);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(callsign, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pilot other = (Pilot) obj;
		return Objects.equals(callsign, other.callsign) && Objects.equals(name, other.name);
	}

}
