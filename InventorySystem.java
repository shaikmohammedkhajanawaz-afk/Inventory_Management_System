package com.inventory;

import java.util.Scanner;

public class InventorySystem {

	public static void main(String[] args) {
		Inventory<Item> inventory = new Inventory<>();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("\nInventory System");
			System.out.println("1. Add Item");
			System.out.println("2. Remove Item");
			System.out.println("3. View Items");
			System.out.println("4. exit");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter item name: ");
				String name = sc.nextLine();
				System.out.println("Enter item quantity: ");
				int quantity = sc.nextInt();
				System.out.println("Enter item price: ");
				double price = sc.nextDouble();
				sc.nextLine();
				Item newItem = new Item(name, quantity, price);
				inventory.addItem(newItem);
				break;
			case 2:
				System.out.println("Enter itme name to remove: ");
				String itemNameToRemove = sc.nextLine();
				Item itemToRemove = null;
				for (Item item : inventory.getItems()) {
					if (item.getName().equalsIgnoreCase(itemNameToRemove)) {
						itemToRemove = item;
						break;
					}
				}
				if (itemToRemove != null) {
					inventory.removeItem(itemToRemove);
				} else {
					System.out.println("Item not found in inventory");
				}
				break;
			case 3:
				// view items
				inventory.viewItems();
				break;
			case 4:
				// exit
				exit = true;
				System.out.println("Existing Inventory System");
				break;
			default:
				System.out.println("Invalid choice.please try again");

			}

		}
		sc.close();
	}

}
