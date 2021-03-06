package edu.luc.cs271.linkedstack;
import java.util.*;

/**A class used for Emergeny Rooms or other emergency care facilities to contain the information of each patient*/
public class Patient extends LevelIllness {

    Scanner keyboard = new Scanner(System.in);

    private String name;
    private int age;
    public int emergencyrate;
    public String condition;

    /**
     * Constructor for Patient. It calls the methods that will set the patient's name, age, insurance, emergency rate, and medical condition.
     */
    public Patient(){
        name = inputName();
        age = inputAge();
        setEmergencyrate();
    }


/**Sets patient name*/
    private String inputName() {
        System.out.println("What is the patient's name?");
        String answer = keyboard.nextLine();
        if(answer.equals("-1"))
        {
            System.out.println("You are now exiting the program.");
            System.exit(0);
        }

        return answer;
    }
/**
 * Returns patient name. If patient name was not yet set, calls inputName() and sets and then returns name.
  */
    public String getName() {
        if (name == null) {
            return inputName();
        }
        return name;
    }

    /**Sets patient age*/
    private int inputAge() {
        System.out.println("What is the patient's age?");
        int answer = keyboard.nextInt();

        if(answer == -1)
        {
            System.out.println("You are now exiting the program.");
            System.exit(0);
        }

        return answer;
    }

    /**
     * Returns patient age. If patient age was not yet set, calls inputAge() and sets and then returns age.
     */
    public int getAge() {
        if (age == 0) {
            return inputAge();
        }
        return age;
    }


    /**Sets patient's level of emergency to prioritize care*/
    private void setEmergencyrate() {
        String emergency = rateIllness();

        emergencyrate = Integer.parseInt(emergency.substring(0, 1));
        condition = emergency.substring(2);
    }

    /** Returns String representation of emergency rate and condition of patient */
    public String toString(){

        return emergencyrate + " " + condition;
    }

  }