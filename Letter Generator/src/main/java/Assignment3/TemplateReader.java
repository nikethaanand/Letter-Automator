package Assignment3;
import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @author nikethaanand
 * class TemplateReader
 */
public class TemplateReader {
    private String contents;
    StringBuilder sb = new StringBuilder();

    /**
     *
     * @param fileName filename
     * @return String
     * Reads the file provided via filename and lods the data into a string and stores it
     */
    public String readFileAsList(String fileName) {
        try {
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            StringBuilder sb = new StringBuilder();

            while ((strLine = br.readLine()) != null)   {
                sb.append(strLine);
            }
            contents = sb.toString();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return contents;
    }

    String text;

    /**
     * @param stringMap stringMap
     * @return String
     * @throws Exception
     * Gets map as input and converts it to string using string builder.
     */
    public String combineStringMap(Map<Integer, String> stringMap) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringMap.size(); i++) {
            sb.append(stringMap.get(i));
        }
        text=sb.toString();
        return text;


    }

    List<Integer> openValue=new ArrayList<>();
    String open = "[[";
    List<Integer> closeValue=new ArrayList<>();
    String close = "]]";
    List<Integer[]> finalReturnList = new ArrayList<>();
    String s,a; int flag=0;  int start=1; int end=2;

    /**
     * @param templateName  template  is loaded in a string and given as input to process
     * @return list of Integer which stores the start position and the end position of each occurrence in
     * the template file loaded by the users.It finds the position where [[ and ]] are found in the template.
     * If found the value is loaded into an array list.Later both the start position place values are added together in an array list and returned
     */
    public List<Integer[]> positionFinderInTemplate(String templateName) {
        for (int i = 0; i < templateName.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(templateName.charAt(i));
            sb.append(templateName.charAt(i + 1));
            s = sb.toString();
            if (s.equals(open))
            {
                openValue.add(i);
            }
            s = "";
        }
        for (int i = 0; i < templateName.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(templateName.charAt(i));
            sb.append(templateName.charAt(i + 1));
            a = sb.toString();
            if (a.equals(close))
            {
                closeValue.add(i + end);
            }
            a = "";
        }
        for (int i = 0; i < closeValue.size(); i++) {
            Integer a[] = new Integer[end];
            a[flag] = openValue.get(i);
            a[start] = closeValue.get(i);
            finalReturnList.add(a);
        }
        for (int i = 0; i < finalReturnList.size(); i++) {
            //System.out.println(Arrays.deepToString(finalReturnList.get(i)));
        }
        return finalReturnList;
    }

    String lineProcessor;

    /**
     *
     * @param templateFileList template list
     * @return String
     * templatelist is generally one line is loaded and
     */
    public String templateLineProcessor(List<String> templateFileList){
        StringBuilder sb = new StringBuilder();
        if ( !templateFileList.isEmpty() & templateFileList != null) {
            for (int i = 0; i < templateFileList.size(); i++)
            {sb.append(templateFileList.get(i)).append(System.lineSeparator());}
            sb.deleteCharAt(sb.length() - 1);
        }
        lineProcessor= sb.toString();


        return lineProcessor;


    }

}
