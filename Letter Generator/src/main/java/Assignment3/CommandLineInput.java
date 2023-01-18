package Assignment3;
import Assignment3.exceptions.InvalidException;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.JCommander;

/**
 * @author nikethaanand
 * class command Line input
 * Run the whole class after input is entered
 */
public class CommandLineInput {
    Mail emailCreate = new Mail();
    /**
     * J commander is used to process input data received from the user via command line arguments
     */
    /**
     * email stores email value as boolean incase value is entered by user
     */
    @Parameter(names = "--email", description = "Debug mode")
    private boolean email;
    /**
     * csvFile stores name of csv File to be processed
     */
    @Parameter(names={"--csv-file","-csv"},arity =1)
    String csvFile;
    /**
     * letterTemplate stores the letterTemplate file to process
     */
    @Parameter(names={"--letter-template","-letterTemp"},arity =1)
    String letterTemplate;
    /**
     * outputDir stores the location to store the newly generated file
     */
    @Parameter(names={"--output-dir","-dir"},arity =1)
    String outputDir;
    /**
     * emailTemplate stores the emailTemplate file to process
     */
    @Parameter(names={"--email-template","-emailTemp"},arity =1)
    String emailTemplate;

    /**
     * letter stores letter value as boolean incase value is entered by user
     */
    @Parameter(names = "--letter",description = "Debug mode")
    private boolean letter;

    /**
     *
     * @param argv receives arguments from the user
     * The method calls the runcommandline() function which is below
     */
    public static void main(String ... argv) {
        CommandLineInput commandLineInput = new CommandLineInput();
        JCommander.newBuilder()
                .addObject(commandLineInput)
                .build()
                .parse(argv);
        commandLineInput.runCommandLine();

        }

    /**
     * Method runcommandLine() checks if the arguments are correct and then calls
     * mainCreateEmail which is the main function to generate emails
     */

    public void runCommandLine() {

       if(csvFile==null)
        {
           String s= "Missing command for csv file";
           throw new InvalidException(s);
        }
        if(outputDir==null)
        {
           String s="Missing command for input directory folder";
           throw new InvalidException(s);
        }
        if((email)&&(emailTemplate==null))
        {
            String s="Missing command for email template processing";
            throw new InvalidException(s);
        }
        if((letter)&&(letterTemplate==null))
        {
            String s="Missing command for letter template processing";
            throw new InvalidException(s);
        }
        try {
            if (email == true) {
                emailCreate.mainCreateEmail( csvFile, outputDir,"email", emailTemplate);
            }
            if (letter == true) {
                emailCreate.mainCreateEmail( csvFile, outputDir,"letter", letterTemplate);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
