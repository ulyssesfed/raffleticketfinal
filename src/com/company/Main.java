package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        int a = 0;
        String[] prizeList = new String[]{"New house","New car","new phone","concert tickets","amazon gift card","xbox","playstation","nintendo switch","fujifilm x-t4","canon OES R6","sony A7R IV","montblanc le grand 146","montegrappa extra otto lapis","visconti medici rose gold","caran d'Ache Astrographer"};
        ArrayList prizes = new ArrayList();
        prizes.addAll(Arrays.asList(prizeList));
        System.out.println("the available prizes are "+ prizes);
        ArrayList primes = new ArrayList();
        ArrayList usedTickets = new ArrayList();
        ArrayList ticketsTotal = new ArrayList();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        Random randPrize = new Random();
        while (a == 0) {
            System.out.println("would you like to buy or a check a ticket?");
            String option = bufferedreader.readLine();
            switch (option) {
                case "buy":
                    System.out.println("how many would you like?");
                    int ticketNum = Integer.parseInt(bufferedreader.readLine());
                    for (int i = 0; i < ticketNum; i++) {

                        System.out.println("what is your name");
                        String name = bufferedreader.readLine();
                        int newTicket = random.nextInt(900) + 100;
                        if(IntStream.range(2, newTicket).noneMatch(x -> newTicket % x == 0)) {
                            primes.add(newTicket);
                        }
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
                    System.out.println(name2 + " " + ticket);
                    if (ticketsTotal.contains(name2 + ticket) && !usedTickets.contains(ticket))
                {
                    System.out.println("this ticket exists!");
                    usedTickets.add(ticket);
                    if (primes.contains(ticket)){
                        int h = randPrize.nextInt(14);
                        System.out.println("Congratulations your number is a prime, you won a " + prizes.get(h));
                    }else System.out.println("unfortunately it isnt prime");
                }else{
                    System.out.println("invalid ticket");
                }

                break;
                case "exit":
                    a++;
            }
        }
    }
}
