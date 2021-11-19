package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList ticketsTotal = new ArrayList();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        System.out.println("would you like to buy or a check a ticket?");
        String option = bufferedreader.readLine();
        switch (option){
            case "buy":
                System.out.println("how many would you like?");
                int ticketNum = Integer.parseInt(bufferedreader.readLine());
                for (int i = 0; i < ticketNum; i++) {

                    System.out.println("what is your name");
                    String name = bufferedreader.readLine();
                    int newTicket = random.nextInt(900) + 100;
                    System.out.println("your ticket is... " + name + " " + newTicket);
                    ticketsTotal.add(name + newTicket);
                    System.out.println(ticketsTotal);
                }
                break;
            case "check":
                System.out.println("what is your name?");
                String name2 = bufferedreader.readLine();
                System.out.print("what is your number");
                int ticket = Integer.parseInt(bufferedreader.readLine());
                System.out.println(name2+" "+ticket);
                ticketsTotal.contains(name2+ticket);
                break;

        }
    }
}

