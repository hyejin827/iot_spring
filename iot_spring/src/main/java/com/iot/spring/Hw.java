package com.iot.spring;

import java.util.ArrayList;

public class Hw {

	public static void main(String[] args) {
		String a = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";
		String[] b = a.split(",");

		// 김씨와 이씨는 각각 몇 명 인가요?
		int count = 0;
		int count2 = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i].indexOf("김")==0) {
				count++;
			} else if (b[i].indexOf("이")==0) {
				count2++;
			}
		}
		System.out.println("김씨는 " + count + "명, " + "이씨는 " + count2 + "명입니다");

		// "이재영"이란 이름이 몇 번 반복되나요?
		int count3 = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i].indexOf("이재영") >= 0) {
				count3++;
			}
		}
		System.out.println("이재영은 " + count3 + "번 반복됩니다");

		// 중복을 제거한 이름을 출력하세요.
		ArrayList<String> list = new ArrayList<String>();
		for (String str : b) {
			list.add(str);
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}
		System.out.println();
		// 중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}
	}
}