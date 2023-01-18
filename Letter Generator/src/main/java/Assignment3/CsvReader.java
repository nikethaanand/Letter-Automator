package Assignment3;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;

/**
 * @author nikethaanand
 * class csv Reader
 */
public class CsvReader {

    /**
     * @param fileName gets the name of the file
     * @return returns a string list of the csv file
     * readFileAsList function loads the csvfile using buffer reader and stores the whole file as string list
     * and returns it for processing
     */
    List<String> listFile = new ArrayList();
    String delimiter = ",";
    String line;
    public List <String> readFileAsList(String fileName) {
        try {
            listFile = new ArrayList();
            BufferedReader br = new BufferedReader(new InputStreamReader((new FileInputStream(fileName)), "UTF8")) ;
            while((line=br.readLine())!=null)
            {
                Arrays.asList(line.split(delimiter));
                listFile.add(line);
            }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        System.out.println(listFile);
            return listFile;
        }
    List<String> processingList = new ArrayList<>();
    /**
     * processingSet is the value returned by processlist csv to the main mail generator
     */
    Set<Map<String, String>> processingSet = new HashSet<>();
    /**
     * Stores first column details and checks
     */
    List<String> headingColumn = new ArrayList<>();
    /**
     * other columns other than the first row
     */
    List<String> listProcessing = new ArrayList<>();

    /**
     * @param fileName  filename
     * @return set of a hashmap
     * processListCsv loads the csv file and each [[ ]] values are mapped together by calling processLines function,
     * key being the column heading and value being the value in the csvFile for each row
     */
    public Set<Map<String, String>> processListCsv (String fileName) {
        processingList = readFileAsList(fileName);
        headingColumn = processLines(processingList.get(0));
        for (int i = 1; i < processingList.size(); i++) {
            listProcessing = processLines(processingList.get(i));
            Map<String, String> tempMap = new HashMap<>();
            for (int j = 0; j < headingColumn.size(); j++) {
                tempMap.put("[["+headingColumn.get(j) +"]]",listProcessing.get(j));
            }
            processingSet.add(tempMap);
        }
        return processingSet;
    }
    String contents;
    /**
     *
     * @param fileName filename
     * @return String
     * Reads the file provided via filename and lods the data into a string and stores it
     */
    public String readFileReadList(String fileName) {
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
    String[] splitString;
    List<String> processList =new ArrayList<>();

    /**
     *
     * @param a String value passed
     * @return list
     * Loads a line of a csv file as input string a and validation takes place and list is returned
     */
    public List<String> processLines(String a) {
        splitString = a.split(",(?=(?:[^\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
        List<String> processStringList = new ArrayList<String>(Arrays.asList(splitString));
        processList = new ArrayList<>();
        for (String str : processStringList) {processList.add(str.replace("\"", "")); }
        return processList;
    }

}
