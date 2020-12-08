package com.example.textquest;

public class Main {
	public static void main(String[] args) {
		IRepository repo = new VVRepo();
		System.out.println(repo.getLocation(0));
	}
}
