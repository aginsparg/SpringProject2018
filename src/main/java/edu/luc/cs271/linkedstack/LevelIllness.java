package edu.luc.cs271.linkedstack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**Class to rate emergency priority level of a patient*/
public class LevelIllness {

    Scanner keyboard = new Scanner(System.in);

private final Map<String, String> CheckingMap = new HashMap<>();
private String [] questions = {"Was the patient brought in an ambulance?", "Are there heart issues?", "Does the patient have an altered level of consciousness?",
         "Are there any burns?","Does the patient have facial/limb weakness?", "Is blood present?", "Does the patient have obvious physical injury?",
         "Does the patient have fever?", "Is the patient in obvious pain?", "Are there any psychological problems with patient?", "Did the patient imbibe poison/overdose?"};
private String answer = "";
private StringBuilder checkableanswer = new StringBuilder();
private String rate = null;
private int intanswer;

/**Method to fill map with possible inputs from user which map to all categories of illnesses along with their corresponding emergency level
 *  Method is called the first time rateIllness() is called.
 */
public Map fillMap(){

    CheckingMap.put("0",    "1 Brought in Ambulance");
    CheckingMap.put("11",   "1 Heart Failure");
    CheckingMap.put("12",   "1 Heart Attack");
    CheckingMap.put("13Y",  "2 Heart Palpitations - long duration");
    CheckingMap.put("13N",  "3 Heart Palpitations - short duration");
    CheckingMap.put("2Y",   "1 Unconscious");
    CheckingMap.put("2NY",  "2 Losing Conscious - long duration");
    CheckingMap.put("2NN",  "3 Losing conscious - short duration");
    CheckingMap.put("33Y",  "1 3rd degree burn - all body");
    CheckingMap.put("33N",  "2 3rd degree burn - part body");
    CheckingMap.put("32Y",  "2 2nd degree burn - all body");
    CheckingMap.put("32NY", "3 2nd degree burn - face");
    CheckingMap.put("32NN", "4 2nd degree burn - part body - not face");
    CheckingMap.put("31Y",  "4 1st degree burn - all body");
    CheckingMap.put("31N",  "5 1st degree burn - part body");
    CheckingMap.put("4Y",   "1 Stroke");
    CheckingMap.put("4N",   "2 Full Body Numbness");
    CheckingMap.put("53",   "1 Excessive Bleeding");
    CheckingMap.put("52Y",  "2 Manageable Bleeding to Head");
    CheckingMap.put("52N",  "3 Manageable Bleeding - not head");
    CheckingMap.put("51",   "5 Cut/Laceration");
    CheckingMap.put("6E",   "2 Impaled/Chemicals in eye");
    CheckingMap.put("6S",   "2 Spinal Injury");
    CheckingMap.put("6H",   "2 Head Injury");
    CheckingMap.put("6BY",  "2 Snake/Scorpion/Dog Bite");
    CheckingMap.put("6BNN", "5 Tick/Spider/Bee Bite - no allergy");
    CheckingMap.put("6BNY", "2 Tick/Spider/Bee Bite - allergic reaction");
    CheckingMap.put("6LN",  "3 Broken Limb");
    CheckingMap.put("6LY",  "5 Broken Finger/Toe");
    CheckingMap.put("6C",   "5 Cut/Laceration");
    CheckingMap.put("7YY",  "4 Child/Senior Ill >24 Hours");
    CheckingMap.put("7YN",  "5 Child/Senior Ill <24 Hours");
    CheckingMap.put("7N",   "6 Adult Ill >24 Hours");
    CheckingMap.put("83",   "3 Excruciating Pain");
    CheckingMap.put("82",   "4 Manageable Pain");
    CheckingMap.put("81",   "5 Moderate Pain");
    CheckingMap.put("9",    "4 Psychological Issues");
    CheckingMap.put("10",   "5 Poison/Overdose");
    return CheckingMap;
}


/**
 * Method asks questions of user about patient to determine illness of patient.
 * Uses StringBuilder to collect answers of questions to determine illness.
 * @return String with priority level and condition of patient
*/
public String rateIllness(){

    if(CheckingMap.isEmpty()){
        fillMap();
    }

    //for(int i = 0; i<questions.length; i++){
    int i = 0;
        while((rate == null) && (i<= 11)) {

            System.out.println(questions[i]);
            answer = keyboard.next();
            if(answer.equalsIgnoreCase("yes")||answer.equalsIgnoreCase("y")) {
                checkableanswer.append(i);

                switch (i) {
                    case 1:

                        System.out.println("Input proper heart condition code: 1 - Heart Failure; 2 - Heart Attack; 3 - Heart Palpitations");
                        intanswer = keyboard.nextInt();
                        checkableanswer.append(intanswer);

                        if (intanswer == 3) {
                            System.out.println("Have the palpitations already been a long duration?");
                            checkableanswer.append(keyboard.next().charAt(0));
                        }

                        break;

                    case 2:

                        System.out.println("Is the patient unconscious?");
                        answer = keyboard.next();
                        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                            checkableanswer.append("Y");
                        } else {
                            checkableanswer.append("N");
                            System.out.println("Has the altered level of conciousness been for a long time?");
                            checkableanswer.append(keyboard.next().charAt(0));
                        }

                        break;

                    case 3:

                        System.out.println("What degree burn does the patient have?");
                        intanswer = keyboard.nextInt();
                        checkableanswer.append(intanswer);

                        switch (intanswer) {
                            case 1:
                                System.out.println("Are the burns covering the patients whole body?");
                                checkableanswer.append(keyboard.next().charAt(0));
                                break;

                            case 2:
                                System.out.println("Are the burns covering the patients whole body?");
                                answer = keyboard.next();
                                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))
                                    checkableanswer.append(answer.charAt(0));
                                else {
                                    checkableanswer.append(answer.charAt(0));
                                    System.out.println("Are the burns on the patient's face?");
                                    checkableanswer.append(keyboard.next().charAt(0));
                                }
                                break;

                            case 3:
                                System.out.println("Are the burns covering the patients whole body?");
                                checkableanswer.append(keyboard.next().charAt(0));
                                break;
                        }
                        break;

                    case 4:

                        System.out.println("Is half the face/body numb/unresponsive?");
                        checkableanswer.append(keyboard.next().charAt(0));
                        break;

                    case 5:

                        System.out.println("Input proper blood amount code: 3 - Excessive; 2 - Moderate; 1 - Minimal - cut/laceration");
                        intanswer = keyboard.nextInt();
                        checkableanswer.append(intanswer);

                        if (intanswer == 2) {
                            System.out.println("Is the bleeding from the head?");
                            checkableanswer.append(keyboard.next().charAt(0));
                        }

                        break;

                    case 6:
                        System.out.println("Input the proper injury code that best describes the patient's injury.");
                        System.out.println("E - eye injury; S - spinal injury; H - head injury; B - bite from an animal/bug; L - broken limb; C - cut/laceration");
                        answer = keyboard.next();
                        checkableanswer.append(answer.charAt(0));

                        if (answer.equalsIgnoreCase("b")) {
                            System.out.println("Was the bite from a snake/scorpion/dog?");
                            answer = keyboard.next();
                            checkableanswer.append(answer.charAt(0));
                            if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                                System.out.println("Does the patient have an allergy to spider/tick/bee bites?");
                                checkableanswer.append(keyboard.next().charAt(0));
                            }
                        }

                        if (answer.equalsIgnoreCase("l")) {
                            System.out.println("Is the broken limb a finger or toe?");
                            checkableanswer.append(keyboard.next().charAt(0));
                        }
                        break;

                    case 7:
                        System.out.println("Is the patient a child or a Senior?");
                        answer = keyboard.next();
                        checkableanswer.append(answer.charAt(0));
                        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                            System.out.println("Has the patient been ill for more than 24 hours?");
                            checkableanswer.append(keyboard.next().charAt(0));
                        }
                        break;

                    case 8:
                        System.out.println("Rate the pain level the patient has.");
                        System.out.println("3 - excruciating pain; 2 - manageable pain; 1 - moderate pain");
                        checkableanswer.append(keyboard.next().charAt(0));
                        break;
                }

                rate = CheckingMap.get(checkableanswer.toString().toUpperCase());

            }
         else
            i=i+1;
    }


   return rate;
    }

}