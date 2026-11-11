import java.util.Scanner;
import net.sf.clipsrules.jni.*;

public class FirstAid {
    //private static net.sf.clipsrules.jni.Environment clips;
    public static void main(String[] agrc) {
        
        try {
            Environment clips = new Environment();
            clips.load("C:\\Users\\Raghad\\Documents\\NetBeansProjects\\FirstAidResponse\\FirstAidRules.CLP");	
            clips.reset();
            
            System.out.println("CLIPS file loaded successfully.");
            System.out.println("CLIPSJNI Version: " + clips.getVersion());
            // Display the menu and get user input
            menu();
            int input = user_choice();
            
            
            // Process user input based on the selected injury type
            switch (input) {
                case 1:
                    Bleedings(clips);
                    break;
                case 2:
                    Burns(clips);
                    break;
                case 3:
                    Fractures(clips);
                    break;
                case 4:
                    HeadInjury(clips);
                    break;
                case 5:
                    Choking(clips);
                    break;
                case 6:
                    Shock(clips);
                    break;
                case 7:
                    Hypothermia(clips);
                    break;
                case 8:
                    Heatstroke(clips);
                    break;
                case 9:
                    Poisoning_Overdose(clips);
                    break;
                case 10:
                    Seizure(clips);
                    break;
                default:
                    System.out.println("Wrong Option From The Menu.");
                    //return; // Exit early if invalid input
            }
                
        } catch (CLIPSException e) {
            System.out.println("Error with CLIPS environment: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error loading CLIPS file: " + e.getMessage());
        }
    }
    
    static void menu(){
        System.out.println("Menu:\n");
        System.out.println("1]Bleeding\n");
        System.out.println("2]Burn\n");
        System.out.println("3]Fracture\n");
        System.out.println("4]Head Injury\n");
        System.out.println("5]Choking\n");
        System.out.println("6]Shock\n");
        System.out.println("7]Hypothermia\n");
        System.out.println("8]Heatstroke\n");
        System.out.println("9]Poisoning/Overdose\n");
        System.out.println("10]Seizure\n");
    }
    
    static int user_choice(){
        System.out.println("Select number from menu");
        Scanner userInput = new Scanner(System.in);
        int input = userInput.nextInt();
        return input;
    }
    
    
    static void Bleedings(Environment clips) throws CLIPSException{
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println("Is there an embedded object?\nType (y/n) only");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Is the bleeding continuous?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response2.equals("y") && !response2.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        
        }
        
        if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(bleeding-continuous (present yes))");
            clips.assertString("(object-embedded (present yes))");
            clips.assertString("(severity (severity severe))");
        } else if(response1.equals("n") && response2.equals("n")){
            clips.assertString("(object-embedded (present no))");
            clips.assertString("(bleeding-continuous (present no))");
            clips.assertString("(severity (severity mild))");
        } else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(object-embedded (present yes))");
            clips.assertString("(bleeding-continuous (present no))");
            clips.assertString("(severity (severity severe))");  
        } else if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(object-embedded (present no))");
            clips.assertString("(bleeding-continuous (present yes))");
            clips.assertString("(severity (severity severe))");  
        }
        clips.run();
        
    }
    
    static void Burns(Environment clips) throws CLIPSException{
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println("Does the burn cover a large area of the body?");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Is there blistering or charring?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response2.equals("y") && !response2.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        }
        
        if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(large-area-burn (present yes))");
            clips.assertString("(blister-charring (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(large-area-burn (present yes))");
            clips.assertString("(blister-charring (present no))");
            clips.assertString("(severity (severity mild))");
        }
        else if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(large-area-burn (present no))");
            clips.assertString("(blister-charring (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("n") && response2.equals("n")){
            clips.assertString("(large-area-burn (present no))");
            clips.assertString("(blister-charring (present no))");
            clips.assertString("(severity (severity mild))");
        }
        clips.run();
    }
    
    static void Fractures(Environment clips) throws CLIPSException{
        
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println("Is the bone protruding through the skin (open fracture)?\nType (y/n) only");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Is there significant swelling or deformity?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response2.equals("y") && !response2.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        }
        
        if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(bone-protruding (present yes))");
            clips.assertString("(swelling (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("n") && response2.equals("n")){
            clips.assertString("(bone-protruding (present no))");
            clips.assertString("(swelling (present no))");
            clips.assertString("(severity (severity mild))");
        }
        else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(bone-protruding (present yes))");
            clips.assertString("(swelling (present no))");
            clips.assertString("(severity (severity ambiguous))");
        }
        else if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(bone-protruding (present no))");
            clips.assertString("(swelling (present yes))");
            clips.assertString("(severity (severity ambiguous))");
        }
        
        clips.run();
        
    }
    
    static void HeadInjury(Environment clips) throws CLIPSException{
        
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println(" Did the casualty lose consciousness?\nType (y/n) only");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Is there bleeding or fluid leaking from the nose or ears?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response2.equals("y") && !response2.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        }
        
        if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(consciousness-lost (present yes))");
            clips.assertString("(bleeding-fluid (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("n") && response2.equals("n")){
            clips.assertString("(consciousness-lost (present no))");
            clips.assertString("(bleeding-fluid (present no))");
            clips.assertString("(severity (severity mild))");
        }
        else if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(consciousness-lost (present no))");
            clips.assertString("(bleeding-fluid (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(consciousness-lost (present yes))");
            clips.assertString("(bleeding-fluid (present no))");
            clips.assertString("(severity (severity severe))");
        }
        
        clips.run();
        
    }
    
    static void Choking(Environment clips) throws CLIPSException{
        
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println("Is the person able to cough or speak?\nType (y/n) only");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Are they gasping for air or turning blue?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        }
        
        if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(can-cough (present no))");
            clips.assertString("(gasping-turnBlue (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(can-cough (present yes))");
            clips.assertString("(gasping-turnBlue (present no))");
            clips.assertString("(severity (severity mild))");
        }
        else if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(can-cough (present yes))");
            clips.assertString("(gasping-turnBlue (present yes))");
            clips.assertString("(severity (severity ambiguous))");
        }
        else if(response1.equals("n") && response2.equals("n")){
            clips.assertString("(can-cough (present no))");
            clips.assertString("(gasping-turnBlue (present no))");
            clips.assertString("(severity (severity ambiguous))");
        }
        
        clips.run();
        
    }
    
    static void Shock(Environment clips) throws CLIPSException{
        
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println("Is the casualty pale and cold?\nType (y/n) only");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Are they becoming unresponsive?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        }
        if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(pale-cold (present yes))");
            clips.assertString("(unresponsive (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(pale-cold (present yes))");
            clips.assertString("(unresponsive (present no))");
            clips.assertString("(severity (severity mild))");
        }
        else if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(pale-cold (present no))");
            clips.assertString("(unresponsive (present yes))");
            clips.assertString("(severity (severity ambiguous))");
        }
        else if(response1.equals("n") && response2.equals("n") ){
            clips.assertString("(pale-cold (present no))");
            clips.assertString("(unresponsive (present no))");
            clips.assertString("(severity (severity ambiguous))");
        }
        
        clips.run();
    }
    
    static void Hypothermia(Environment clips) throws CLIPSException{
        
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println("Is the casualty shivering or confused?\nType (y/n) only");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Are they becoming unresponsive or unable to communicate?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        }
        
        if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(shivering-confused (present no))");
            clips.assertString("(unresponsive (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(shivering-confused (present yes))");
            clips.assertString("(unresponsive (present no))");
            clips.assertString("(severity (severity mild))");
        }
        else if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(shivering-confused (present yes))");
            clips.assertString("(unresponsive (present yes))");
            clips.assertString("(severity (severity ambiguous))");
        }
        else if(response1.equals("n") && response2.equals("n")){
            clips.assertString("(shivering-confused (present no))");
            clips.assertString("(unresponsive (present no))");
            clips.assertString("(severity (severity ambiguous))");
        }
        
        clips.run();
        
    }
    
    static void Heatstroke(Environment clips) throws CLIPSException{
        
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println("Is the casualty sweating or has their skin become hot and dry?\nType (y/n) only");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Are they confused or unresponsive?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        }
        
        if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(sweating-hotDrySkin (present yes))");
            clips.assertString("(confused-unresponsive (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(sweating-hotDrySkin (present yes))");
            clips.assertString("(confused-unresponsive (present no))");
            clips.assertString("(severity (severity mild))");
        }
        else if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(sweating-hotDrySkin (present no))");
            clips.assertString("(confused-unresponsive (present yes))");
            clips.assertString("(severity (severity ambiguous))");
        }
        else if(response1.equals("n") && response2.equals("n")){
            clips.assertString("(sweating-hotDrySkin (present no))");
            clips.assertString("(confused-unresponsive (present no))");
            clips.assertString("(severity (severity ambiguous))");
        }
        
        clips.run();
        
        
    }
    
    static void Poisoning_Overdose(Environment clips) throws CLIPSException{
        
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println("Is the casualty experiencing mild nausea or dizziness?\nType (y/n) only");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Is the casualty unresponsive or having difficulty breathing?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        }
        
        if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(nausea-dizziness (present no))");
            clips.assertString("(difficultyBreathing-unresponsive (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(nausea-dizziness (present yes))");
            clips.assertString("(difficultyBreathing-unresponsive (present no))");
            clips.assertString("(severity (severity mild))");
        }
        else if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(nausea-dizziness (present yes))");
            clips.assertString("(difficultyBreathing-unresponsive (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("n") && response2.equals("n")){
            clips.assertString("(nausea-dizziness (present no))");
            clips.assertString("(difficultyBreathing-unresponsive (present no))");
            clips.assertString("(severity (severity ambiguous))");
        }
        
        clips.run();
        
        
    }
    
    static void Seizure(Environment clips) throws CLIPSException{
        
        String response1;
        String response2;
        Scanner input = new Scanner(System.in);
        System.out.println("Does the person look like they are unaware and unresponsive but awake?\nType (y/n) only");
        response1 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response1 = input.nextLine().toLowerCase();
        }
        System.out.println("Is the person having convulsions or muscle spasms?\nType (y/n) only");
        response2 = input.nextLine().toLowerCase();
        while (!response1.equals("y") && !response1.equals("n")){
            System.out.println("Please enter a valid answer (y/n)");
            response2 = input.nextLine().toLowerCase();
        }
        
        if(response1.equals("n") && response2.equals("y")){
            clips.assertString("(awake-absentminded (present no))");
            clips.assertString("(shaking-convulsions (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("y") && response2.equals("n")){
            clips.assertString("(awake-absentminded (present yes))");
            clips.assertString("(shaking-convulsions (present no))");
            clips.assertString("(severity (severity mild))");
        }
        else if(response1.equals("y") && response2.equals("y")){
            clips.assertString("(awake-absentminded (present yes))");
            clips.assertString("(shaking-convulsions (present yes))");
            clips.assertString("(severity (severity severe))");
        }
        else if(response1.equals("n") && response2.equals("n")){
            clips.assertString("(awake-absentminded (present no))");
            clips.assertString("(shaking-convulsions (present no))");
            clips.assertString("(severity (severity ambiguous))");
        }
        
        clips.run();
        
    }  
    
}


