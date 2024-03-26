public class UserInterface {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private Scanner input;
    private Adventure adventure;
    private boolean isProgramRunning;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    //Hvad bruges konstruktøren her til når den ikke bliver kaldt?
    public UserInterface(){
        adventure = new Adventure();
        input = new Scanner(System.in);
        input.useDelimiter("\n"); // Scanner bug solution
    }

    //***STARTPROGRAM***------------------------------------------------------------------------------------------------
    //Hvorfor er der ikke er et Adventure i vores start program/ hvordan ved programmet at der skal starte et nyt adventure?
    public void startProgram() {

        introduction();
        helpCommands();

        while (true) {
            if(isProgramRunning) {
                isProgramRunning = true;
            } else {
                userInput();
            }
        }
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void newGame() {
        System.out.println("✦✦✦✦✦✦ WELCOME TO THE ADVENTURE GAME ✦✦✦✦✦✦");
        System.out.println("_______________________________________________");
        System.out.println("|      NEW GAME      - Starts a new game      |");
        System.out.println("|      EXIT          - Exits the program      |");
        System.out.println("-----------------------------------------------");
        String userInput = input.nextLine();
        boolean exit = false; //added for at se om loopet stopper

        while (!(userInput.isEmpty())) {
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                System.exit(0); //hvorfor 0?
                exit = true;
            } else if (userInput.equalsIgnoreCase("new game")) {
                System.out.println("Starting new game...");
                startProgram();
            } else {
                System.out.println("*** Input invalid *** \nPlease enter NEW GAME to start game or EXIT to end the program");
                userInput = input.nextLine();
            }
        }
    }

    public void introduction() {
        System.out.println("Hello, and welcome to .....");

        System.out.println("  ______               ___            _ _   _                             ");
        System.out.println(" |  ____|             / _ \\          | | | | |                            ");
        System.out.println(" | |__ ___  __ _ _ __/ /_\\ \\_ __   __| | |_| |_   _ _ __   __ _  ___ _ __ ");
        System.out.println(" |  __/ _ \\/ _` | '__|  _  | '_ \\ / _` |  _  | | | | '_ \\ / _` |/ _ \\ '__|");
        System.out.println(" | | |  __/ (_| | |  | | | | | | | (_| | | | | |_| | | | | (_| |  __/ |   ");
        System.out.println(" |_|  \\___|\\__,_|_|  \\_| |_|_| |_|\\__,_|_| |_|\\__,_|_| |_|\\__, |\\___|_|   ");
        System.out.println("                                                           __/ |          ");
        System.out.println("                                                          |___/           ");

        System.out.println("This is a horror survival game");
        System.out.println("Try and survive while discovering the secrets of the tomb");
        System.out.println("▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔\n");
        System.out.println("You find yourself at the entrance of a dark tomb. You don't remember anything");
    }

    //------------------------------------------------------------------------------------------------------------------
}
