package com.dzkj.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SendmailRandomTime {
	//�������6 λ��֤��
	public static String Random() {
		String rancode="";
		Random ran=new Random();
		for (int i = 0; i < 6; i++) {
			rancode+=ran.nextInt(9);
		}
		return rancode;
	}
}
