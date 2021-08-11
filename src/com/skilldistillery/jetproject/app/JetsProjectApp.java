package com.skilldistillery.jetproject.app;

import java.io.*;
import java.util.*;

import com.skilldistillery.jetproject.entities.*;

public class JetsProjectApp {

	private Airfield af = new Airfield();
	private static Scanner scanner = new Scanner(System.in);
	private static String fileName = "jets.txt";

	public static void main(String[] args) {

		JetsProjectApp jpa = new JetsProjectApp();
		// initialize jets list and load menu
		jpa.af.loadJets(fileName, jpa.af.getJets());
		jpa.mainMenu();
		scanner.close();
		jpa.af.scanner.close();
	}

	// gets input, checking for correct type
	private void mainMenu() {
		System.out.println("Welcome to the Jet Command and Control Center");
		System.out.println("Ruling the skies since 1988\n");
		System.out.println("                     __|__");
		System.out.println("            __|__ *---o0o---*");
		System.out.println("   __|__ *---o0o---*");
		System.out.println("*---o0o---*\n\nPress Enter to Continue...");
		scanner.nextLine();
		boolean hasQuit = false;
		while (!hasQuit) {
			System.out.println("\nPlease Make a Selection:" + "\n1. List Fleet" + "\n2. Fly a Jet" + "\n3. Fly All Jets"
					+ "\n4. View Fastest Jet" + "\n5. View Jet With Longest Range"
					+ "\n6. Launch All Spaceworthy Jets Into Orbit" + "\n7. Cloak All Stealth Jets"
					+ "\n8. Add a Jet to Fleet" + "\n9. Remove a Jet From Fleet" + "\n10. Save Fleet to a File"
					+ "\n11. Load a Different Fleet From File"
					+ "\n12. Hire a New Pilot\n13. List Available Pilots\n14. List Assigned Pilots" + "\n15. Quit\n");
			String menuChoice = scanner.nextLine();
//			scanner.nextLine();
			try { // to catch anything not an int
				Integer selection = Integer.parseInt(menuChoice);
				hasQuit = processInput(selection);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number");
			}
		}

	}

	private boolean processInput(int selection) {
		boolean hasQuit = false;
		switch (selection) {// longest switch I've written, I can't wait until I know a better way to do
							// this!
		case 1:
			displayAllJets();
			break;
		case 2:
			flyAJet();
			break;
		case 3:
			flyAll();
			break;
		case 4:
			findFastestJet();
			break;
		case 5:
			findRangestJet();
			break;
		case 6:
			launchOrbitalShips();
			break;
		case 7:
			cloakStealthJets();
			break;
		case 8:
			af.addNewJet();
			break;
		case 9:
			af.removeJet();
			break;
		case 10:
			saveFleet();
			break;
		case 11:
			loadFleet();
			break;
		case 12:
			hirePilot();
			break;
		case 13:
			af.displayPilots();
			break;
		case 14:
			af.assignedPilots();
			break;
		case 15:
			hasQuit = true;
			quit();
			System.out.println("\nThank you for using this service.");
			break;
		default:
			System.out.println("Incorrect entry, please try again.");

		}
		return hasQuit;
	}

	private void quit() {
		System.out.println("              ______");
		System.out.println("            _\\ _~-\\___");
		System.out.println("    =  = ==(____AA____D");
		System.out.println("                \\_____\\___________________,-~~~~~~~`-.._");
		System.out.println("                /     o O o o o o O O o o o o o o O o  |\\_");
		System.out.println("                `~-.__        ___..----..                  )");
		System.out.println("                      `---~~\\___________/------------`````");
		System.out.println("                      =  ===(_________D");
	}

	private void hirePilot() {
		System.out.println("Please enter the name of the pilot you'd like to hire:");
		String name = scanner.nextLine();
		System.out.println("Please enter the pilot's callsign:");
		String callsign = scanner.nextLine();
		af.getPilots().add(new Pilot(name, callsign));
		System.out.println(name + " has been hired and added to the roster!");
	}

	private void flyAJet() {
		System.out.println("Please enter the number of the jet you'd like to fly:\n");
		for (int i = 0; i < af.getJets().size(); i++) {
			System.out.println((i + 1) + "=> " + af.getJets().get(i));
		}
		String input = scanner.nextLine();
		try {
			af.getJets().get(Integer.parseInt(input) - 1).fly();
		} catch (Exception e) {
			System.out.println("Incorrect entry.  Please try again");
		}
	}

	private void flyAll() {
		for (Jet jet : af.getJets()) {
			jet.fly();
		}
	}

	private void loadFleet() {
		System.out.println("Please enter the file name that contains the fleet:");
		String file = scanner.nextLine() + ".txt";
		af.loadJets(file, af.getJets());

	}

	private void saveFleet() {
		System.out.println("Please enter a file name to save the fleet:");
		String newFile = scanner.nextLine();
		if (newFile.equals("jets")) {
			System.out.println("Cannot override default list.  Please try again!");
			return;
		}
		newFile = ("." + File.separator + newFile + ".txt");
		File f = new File(newFile);
		try (PrintWriter pw = new PrintWriter(new FileOutputStream(f))) {
			for (Jet jet : af.getJets()) {
				pw.println(jet.fileFormat());
			}
		} catch (IOException e) {

		}
		System.out.println("New file saved: " + newFile);
	}

	private void cloakStealthJets() { // So'wI' yIchu'!
		for (Jet jet : af.getJets()) {
			if (jet instanceof StealthCapable) {
				((StealthCapable) jet).activateCloakingDevice();
			}
		}
	}

	private void launchOrbitalShips() {
		for (Jet jet : af.getJets()) {
			if (jet instanceof SpaceCapable) {
				((SpaceCapable) jet).activateRockets();
			}
		}
	}

	private void findRangestJet() {
		System.out.println("The jet with the longest range:\n----------------------------------\n"+af.findRangestJet());
	}

	private void findFastestJet() {
		System.out.println("The jet with the fastest speed:\n----------------------------------\n"+af.findFastestJet());
	}

	private void displayAllJets() {
		System.out.println();
		for (Jet jet : af.getJets()) {
			System.out.println("\n" + jet);
		}

	}

}
