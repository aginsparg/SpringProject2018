package edu.luc.cs271.linkedstack;

import java.util.Map;
import java.util.Scanner;

public class Main {

    /** Amount of time between servicing patients in milliseconds. Amount of time equivalent to 45 seconds between serving patients. */
    static final int TIME_BETWEEN_PATIENTS = 45000;



    public static void main(String [] args) throws InterruptedException{

        System.out.println("WARNING: Due to usage in an Emergency Room, as a safety feature program does not terminate unless specifically " +
                "told to do so, through typing a \"-1\" instead of a new patient's name or age!");

        final Object lock = new Object();
        final LinkedQueue<Patient> ERline = new LinkedQueue();

        Patient starting = new Patient();
        ERline.offer(starting);

// background activity for calling patients. If the queue is not empty it calls the next patient and displays its information,
// if it is empty it displays the message "no one waiting"
        final Thread patient =
                new Thread(
                        () -> {
                            while (true) {
                                Patient current;

                                synchronized (lock) {
                                    current = ERline.poll();

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

//while user has not inputted a -1 to terminate the program, the user can add new patients to the queue.
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

