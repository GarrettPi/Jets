package com.skilldistillery.jetproject.entities;

import java.util.*;

public class JetImpl extends Jet{

	
	public JetImpl() {
	}

	public JetImpl(Pilot pilot, String model, double speed, double price, int range) {
		super(pilot, model, speed, price, range);
	}
	

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	
	
}
