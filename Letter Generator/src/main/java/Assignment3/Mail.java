package Assignment3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
* @author nikethaanand
* Class main generates email files
 */
    public class Mail {


    private Map<Integer, String> mapTemplategen =new HashMap<>();
    private Set<Map<String, String>> setCsv =new HashSet<>();
    private Set<Integer> setTemplategen =new HashSet<>();
    private Map<Integer, String> matchTemplate;
;
    private String finalOutputTemplate;

    private String outputFileName="[[first_name]]";

    /**
     *
     * @param csvFile csv file
     * @param outputDir output directory to be printed
     * @param email email/letter entered by user
     * @param templateName template format given by the user
     * @throws Exception e thrown
     */
    public void mainCreateEmail(String csvFile, String outputDir,String email, String templateName) throws Exception {
        TemplateReader tr = new TemplateReader();
        CsvReader csv = new CsvReader();
        TemplateProcessing tp = new TemplateProcessing();
        setCsv = csv.processListCsv(csvFile);
        mapTemplategen = tp.mapMainTemplateGenerator(templateName);
        setTemplategen = tp.setMainTemplateGenerator(templateName);

        for (Map<String,String> currentVal: setCsv) {  matchTemplate = new HashMap<>(mapTemplategen);
            for (Integer index: setTemplategen)
            {
                String pos=matchTemplate.get(index);
                matchTemplate.put(index, currentVal.get(pos));
            }
            finalOutputTemplate=tr.combineStringMap(matchTemplate);
            String outputFileName=currentVal.get(this.outputFileName)+".txt";
            BufferedWriter br=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputDir + File.separator + outputFileName)));

            br.write(finalOutputTemplate);
            br.flush();
            br.close();
            }
        System.out.println("Email is generated");
        }
    }