package com.skilldistillery.jetproject.entities;

import java.util.*;
import java.io.*;

public class Airfield {
	public  Scanner scanner = new Scanner(System.in);
	private List<Jet> jets;
	private Set<Pilot> pilots;

	public Airfield() {// creates list of jets and hashset (for variety) of pilots
		jets = new ArrayList<>();
		pilots = loadPilots();

	}

	public void loadJets(String fileName, List<Jet> jetSet) {
		jets.removeAll(jets);
		pilots = loadPilots();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] importPieces = line.split("\t");
				Pilot pilot;
				try { // in case the pilot set somehow runs out, I believe it's deprecated since I
						// switch pilots to a set
					pilot = assignPilot();
				} catch (IndexOutOfBoundsException e) {
					loadPilots();
					pilot = assignPilot();
				}
				// af.getPilots().remove(0); assigning pilot method autoremoves pilot from pool

				String model = importPieces[1];
				Double speed = Double.parseDouble(importPieces[2]);
				Double price = Double.parseDouble(importPieces[3]);
				Integer range = Integer.parseInt(importPieces[4]);
				Integer altitude = 0;
				Integer oxygen = 0;
				Double cargo = 0.;
				Double cloakEfficiency = 0.;
				Integer cloakEndurance = 0;
				if (!importPieces[5].equals("NA")) {
					altitude = Integer.parseInt(importPieces[5]);
				}
				if (!importPieces[6].equals("NA")) {
					oxygen = Integer.parseInt(importPieces[6]);
				}
				if (!importPieces[7].equals("NA")) {
					cargo = Double.parseDouble(importPieces[7]);
				}
				if (!importPieces[8].equals("NA")) {
					cloakEfficiency = Double.parseDouble(importPieces[8]);
				}
				if (!importPieces[9].equals("NA")) {
					cloakEndurance = Integer.parseInt(importPieces[9]);
				}
				switch (importPieces[0]) {
				case "SpacePlane":
					jetSet.add(new SpacePlane(pilot, model, speed, price, range, altitude, oxygen));
					break;
				case "CargoJet":
					jetSet.add(new CargoJet(pilot, model, speed, price, range, cargo));
					break;
				case "StealthReconJet":
					jetSet.add(new StealthReconJet(pilot, model, speed, price, range, cloakEfficiency, cloakEndurance));
					break;
				case "OrbitalSpyPlane":
					jetSet.add(new OrbitalSpyPlane(pilot, model, speed, price, range, altitude, oxygen, cloakEfficiency,
							cloakEndurance));
					break;
				case "JetImpl":
					jetSet.add(new JetImpl(pilot, model, speed, price, range));
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
	}

	public void addJet(Jet jet) { 
		jets.add(jet);
	}

	public void addNewJet() {
		// initializing all the base values
//		Scanner scanner = new Scanner(System.in);
		String model = null;
		double speed = 0;
		double price = 0;
		int range = 0;
		double cargo = 0;
		int orbit = 0;
		int o2 = 0;
		double cloakEfficiency = 0;
		int cloakEndurance = 0;
		int input = 0;
		boolean misTyped = true;
		do {
			System.out.println("Which type of jet would you like to add to the fleet?"
					+ "\n1. Passenger\n2. Cargo\n3. Space Plane\n4. Orbital Spy Plane\n5. Stealth Recon Jet");
			input = scanner.nextInt();
			scanner.nextLine();
			if (input < 1 || input > 5) {
				misTyped = true;
				System.out.println("\nIncorrect entry.  Please Try Again.\n");
			} else
				misTyped = false;
		} while (misTyped); // Initially takes in all the common fields then switches to specialty fields
							// based on selection above
		Pilot pilot = assignPilot();
		System.out.println("Please enter the model:");
		model = scanner.nextLine();
		System.out.println("Please enter the speed in MPH:");
		speed = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Please enter the price:");
		price = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Please enter the range in miles:");
		range = scanner.nextInt();
		scanner.nextLine();
		if (input == 1) {
			addJet(new JetImpl(pilot, model, speed, price, range));
			System.out.println("New Passenger Jet " + model + " added.");
		} else if (input == 2) {
			System.out.println("Please enter the cargo capacity in tons:");
			cargo = scanner.nextDouble();
			scanner.hasNextLine();
			addJet(new CargoJet(pilot, model, speed, price, range, cargo));
			System.out.println("New Cargo Jet " + model + " added.");
		} else if (input == 3) {
			System.out.println("Please enter the maximum orbital height in miles:");
			orbit = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please enter the available oxygen in hours:");
			o2 = scanner.nextInt();
			scanner.nextLine();
			addJet(new SpacePlane(pilot, model, speed, price, range, orbit, o2));
			System.out.println("New Space Plane " + model + " added.");
		} else if (input == 4) {
			System.out.println("Please enter the maximum orbital height in miles:");
			orbit = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please enter the available oxygen in hours:");
			o2 = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please enter the cloak efficiency:");
			cloakEfficiency = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Please enter the cloak endurance in hours:");
			cloakEndurance = scanner.nextInt();
			scanner.nextLine();
			addJet(new OrbitalSpyPlane(pilot, model, speed, price, range, orbit, o2, cloakEfficiency, cloakEndurance));
			System.out.println("New Orbital Spy Plane " + model + " added.");
		} else if (input == 5) {
			System.out.println("Please enter the cloak efficiency:");
			cloakEfficiency = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Please enter the cloak endurance in hours:");
			cloakEndurance = scanner.nextInt();
			scanner.nextLine();
			addJet(new StealthReconJet(pilot, model, speed, price, range, cloakEfficiency, cloakEndurance));
			System.out.println("New Stealth Recon Jet " + model + " added.");
		}
	}

	public void removeJet() {
		scanner.nextLine();
		System.out.println("Please enter the number or model of the jet you'd like to remove:\n");
		for (int i = 0; i < jets.size(); i++) {
			System.out.println((i + 1) + "=> " + jets.get(i));

		}
		String jetChoice = scanner.nextLine();
		try {
			Integer jetToRemove = Integer.parseInt(jetChoice) - 1;
			System.out.println(jetToRemove);
			Pilot p = jets.get(jetToRemove.intValue()).getPilot();
			pilots.add(p);
			System.out.println("Jet removed.  Pilot " + p.getName() + " returned to the briefing room.");
			jets.remove(jetToRemove.intValue());
		} catch (NumberFormatException e) {
			for (int i = 0; i < jets.size(); i++) {
				if (jets.get(i).getModel().equalsIgnoreCase(jetChoice)) {
					Pilot p = jets.get(i).getPilot();
					pilots.add(p);
					System.out.println("Jet removed.  Pilot " + p.getName() + " returned to the briefing room.");
					jets.remove(i);
				} else {
					System.out.println("That is not a correct selection.  Please try again.");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("That is not a correct selection.  Please try again.");
		}
	}
	
	public Jet findRangestJet() {
		int rangest = 0;
		Jet rangestJet = null;
		for (Jet jet : jets) {
			if (jet.getRange() > rangest) {
				rangestJet = jet;
				rangest = rangestJet.getRange();
			}
		}
		return rangestJet;
	}
	
	public Jet findFastestJet() {
		double fastestSpeed = 0.0;
		Jet fastestJet = null;
		for (Jet jet : jets) {
			if (jet.getSpeed() > fastestSpeed) {
				fastestJet = jet;
				fastestSpeed = fastestJet.getSpeed();
			}
		} return fastestJet;
	}
	public Pilot assignPilot() { // practice with iterators. I kind of totally dig them.
		Iterator<Pilot> it = pilots.iterator();
		if (it.hasNext()) {
			Pilot p = it.next();
			it.remove();
			return p;
		} else {
			pilots = loadPilots();
			Pilot p = it.next();
			it.remove();
			return p;
		}
	}

	public void displayPilots() {
		Iterator<Pilot> it = pilots.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void assignedPilots() {
		for (Jet jet : jets) {
			System.out.println(jet.getPilot().getName() + ", callsign " + jet.getPilot().getCallsign());
			System.out.println("Assigned to the " + jet.getModel());
			System.out.println("--------------------------------");
		}
	}

	public Set<Pilot> loadPilots() {
		pilots = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new FileReader("pilots.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] importPieces = line.split(",");
				pilots.add(new Pilot(importPieces[0], importPieces[1]));
			}
		} catch (FileNotFoundException e) {

		} catch (Exception e) {

		}
		return pilots;
	}

	public List<Jet> getJets() {
//		Set<Jet> safeJets = new LinkedHashSet<>(); was going to make a defensive copy of jet list but it made no sense since the point of this app is to modify that list
//		safeJets.addAll(jets); also jets were originally in a set instead of list.
//		return safeJets;
		return jets;
	}

	public Set<Pilot> getPilots() {
		return pilots;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Airfield [jets=");
		builder.append(jets);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(jets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airfield other = (Airfield) obj;
		return Objects.equals(jets, other.jets);
	}

}
