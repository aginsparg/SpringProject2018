package edu.luc.cs271.linkedstack;

import java.util.Map;
import java.util.Scanner;

public class Main {

    /** Amount of time between servicing patients in milliseconds. Amount of time equivalent to 2 minutes between patients. */
    static final int TIME_BETWEEN_PATIENTS = 60000;



    public static void main(String [] args) throws InterruptedException{

        System.out.println("WARNING: Due to usage in an Emergency Room, as a safety feature program does not terminate unless specifically" +
                "told to do so, through Ctrl D, or Ctrl Z, based on running program!");
        Scanner keyboard = new Scanner(System.in);
        final Object lock = new Object();
        final LinkedQueue<Patient> ERline = new LinkedQueue();

        Patient starting = new Patient();
        ERline.offer(starting);

// background activity for serving customers
        final Thread patient =
                new Thread(
                        () -> {
                            while (true) {
                                Patient current;

                                synchronized (lock) {
                                    current = ERline.poll();// TODO try to take next name from queue

                                }
                                if (current == null) {
                                    System.out.println("no one waiting");
                                } else {
                                    System.out.println("Information of Patient currently being served:");
                                    System.out.println("Name: " + current.getName());
                                    System.out.println("Age: " + current.getAge());
                                    System.out.println("Emergency Level: " + current.emergencyrate);
                                    System.out.println("Illness needing treatment: " + current.condition);
                                    System.out.println();
                                }
                                try {
                                    Thread.sleep(TIME_BETWEEN_PATIENTS);
                                } catch (final InterruptedException ex) {
                                    return;
                                }
                            }
                        });
        patient.setDaemon(true);
        patient.start();


        boolean processed;
        while(true){

            Patient another = new Patient();

            synchronized (lock) {
                processed = ERline.offer(another);
            }

            if(processed){
                System.out.println(another.getName() + " was added to the ER waiting room");
            }

            }






    }
}

