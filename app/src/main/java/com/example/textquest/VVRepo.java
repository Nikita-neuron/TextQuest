package com.example.textquest;

import android.util.Log;

import java.util.ArrayList;

public class VVRepo implements IRepository {
	String[] locTexts;

	@Override
	public Location getLocation(int id) {
		String[] desc = c(locTexts[id]).split("\\|");
		Action[] actions = new Action[(desc.length - 2) / 2];
		for (int i = 0; i < actions.length; i++) {
			actions[i] = new Action(desc[i + 2], Integer.parseInt(desc[i + 2 + actions.length]));
		}
		return new Location(desc[1], actions);
	}

	public VVRepo() {
		locTexts = makeTexts();
	}

	private String[] makeTexts() {
		ArrayList<String> texts = new ArrayList<>();
		texts.add(" 0|�� �������� � ������ ����. �� ������ ��������� ������ ����. ���� �� ������|�� �����|� ����|1|5");
		texts.add(" 1|�� ����� �� �����. ����� ��� �����.|��������� ����|�������� � ����|2|5");
		texts.add(" 2|� ���� ��� �����. �� ����� �������� ��� �����, ��� ����� ������. ������?|��|���|3|5");
		texts.add(
				" 3|����� ����������� ������� ���������. �� ���������� ��������� ���������� �� ������ ������ ����� ��������� �������� � ��������.\n����� ���������� �������� � ������� ���� ��� ���� �������.|��� �� ������?|4");
		texts.add(" 4|������ �� ����� � ����������! :) ����������.|�����|20");
		texts.add(
				" 5|�� ��������� � ����. ����� ������� � ����. �������� ��������. ������ ��� � �����. ���� �������?|�����|�� �����|6|14");
		texts.add(
				" 6|����� �����, �� �������� ���� ����. �� ����� ������ - ������ ��������, ��� ������� ����� �����.|������� ���|������ �� �����|13|7");
		texts.add(
				" 7|�� �������� �� ����� � ������, ��� ����� ������ �����. ���� �������� � �������, �� �� �������� ���� ��������� ���������.\n�� ������, ��� �� ����� ����� ��������� ������� �������, � ������� ��� ������������ �����-�� ������.|������ ���� �� ���|����������|10|8");
		texts.add(
				" 8|�� ����� �������� � ���, �� �� ���� �� �����. ����� ������� ���������. ���� ��� �������. ���� ��������� ��� ������...|������|9");
		texts.add(
				" 9|������ �� �� ����� �����. ������ ������ ��� ���� ����� ���������. ��� ������� ���� �� �������� ���� ��������, � ������ ������������� ��� ����� �����, � �� ������� ��������� ������� �����������.\n���� ������������� ����! :)|�����|20");
		texts.add(
				"10|�� ��������� � �������� � ��������� ���������� �������. ����� ���� �������� ������������ ������, �� �� �������������� ���������� ���� �����. �� �������, �� �� �������� ������� ������� ��������...|������|11");
		texts.add(
				"11|��������� ����� ������ ���� ��� �������� �������� � ������� ����� ������� ��������� � ������� ������������. ���� ��������� � � ����� \"������ � ��������\":\n � � �������� ����� \n ������ ���������� �� ���\n �� ���� ��������� �����\n ������ ���, ������ ���...|������|12");
		texts.add("12|����������, �� - ���������!|�����|20");
		texts.add(
				"13|�� ����� ��� ������ ����������� ������������ � �������� �� �����. ������, ��� � ���� ���� ������, �������� ��������� � ���� - ����� ��� ������ �����, �������� �� �������� ������. ��� ������������ � ����, ������� ������� ��� ������������ �����...\n���-�� ��� ���� ������, ��� ���� ������� ��� � ������� ����-��...\n��� �������� ������ � ���� �������� �� ����� :) ����������!|�����|20");
		texts.add(
				"14|�� ��������� �� �����. ������, ������� � �� ���������� �������������. ������� ����, ������.\n��� �������� ���������� �������� ����� �������� �������� �����. ������� �������, �� ���������, ��� ��� ���� �� ��� ����� ������-���������, ��� ��������� ���� � ������� ����.|�������� � ����|��������� �� �����|15|20");
		texts.add(
				"15|������� ���������� ���� ��������� ����������� ����. \n������ ����� ��� �� �����, �� ��� �������������� ���� �������� �������! :) \n���������|��|���|16|20");
		texts.add(
				"16|������� ���������� ����, ��� ���������� ���������� � ��� ��������. �� �������� ������ � �������� � ����� � ������, ��������� �������.|������|17");
		texts.add(
				"17|����� �� �������������, ��� ���� ��� ��� �������. ��� �������� ������ �����. ���� �������� � ������ � ���. \n������ ������:\n- �� �������! ��� ����� ���������� � ������ ��� �� ���������� ������.\n�� ��������� ��� � ���������� �� �� ����.|������|18");
		texts.add("18|��� �������. �� ������� ���������); ��� �� �����, �� �����! ����������!|������|19");
		texts.add(
				"19|�������� ���������� �����. ������� �������� ��� � ��������� �� ���� ������. ���� ����� ����� � ���� � �������.\n������� ������ ����������, ���-�� ������ � ����...\n���� ������ � �����...\n����������! ������ �� - ����� �����!|�����|20");
		texts.add(
				"20|--- STAFF ---\n\nHaruki Murakami\nJackie Chan\nSong by Yiruma\n\n(c) Konami, 1985|����������� ��� ���|0");
		
String[] arr = {};
		return texts.toArray(arr);
	}

	private String c(String message) {
		StringBuilder result = new StringBuilder();
		for (char character : message.toCharArray()) {
			if (character >= '�' && character <= '�') {
				int newChar = ((int) character - '�' - 2 + 32) % 32 + '�';
				result.append((char) (newChar));
			} else if (character >= '�' && character <= '�') {
				int newChar = ((int) character - '�' - 2 + 32) % 32 + '�';
				result.append((char) (newChar));
			} else {
				result.append(character);
			}
		}
		Log.d("loc", result.toString());
		return result.toString();
	}
}
