package Assignment3;

import java.util.*;

/**
 * @author nikethaanand
 * class TemplateProcessing
 */
public class TemplateProcessing {
    /**
     * List of integer object that stores the positions
     */
    List<Integer[]> listOfPosition;
    /**
     * template list that is used in traversing
     */
    List<String> templateList =new ArrayList<>();;
    String stringTemplate;
    CsvReader csv=new CsvReader();
    int flag =0;int positionZero = 0;

    Map<Integer, String> mapMainTemplate=new HashMap<>();

    /**
     *
     * @param fileName template name
     * @return return map which is processed in mainTemplateGenerator
     */
    public Map<Integer, String> mapMainTemplateGenerator(String fileName) {
        return  mainTemplateGenerator(fileName);
    }
    Set<Integer> setMainTemplate=new HashSet<>();

    /**
     *
     * @param fileName template name
     * @return return set which is processed in mainTemplateGenerator
     */
    public Set<Integer> setMainTemplateGenerator(String fileName) {
        mainTemplateGenerator(fileName);
        return setMainTemplate;
    }



    /**
     * Given a template file name, break down the template into placeholders and non-placeholders
     * @param fileName String value of the template file name.
     * @return map to mapMainTemplateGenerator
       */
    public Map<Integer, String> mainTemplateGenerator(String fileName)  {
        flag = 0;
        templateList=csv.readFileAsList(fileName);
        TemplateReader temp=new TemplateReader();
        stringTemplate=temp.templateLineProcessor(templateList);
        listOfPosition=temp.positionFinderInTemplate(stringTemplate);
        {
            mapMainTemplate.put(flag,stringTemplate.substring(positionZero,listOfPosition.get(positionZero)[0]));
            flag++;
            mapMainTemplate.put(flag,stringTemplate.substring(listOfPosition.get(positionZero)[0],listOfPosition.get(positionZero)[1]));
            setMainTemplate.add(flag);
        }
        flag++;

        for (int i=1;i<listOfPosition.size();i++) {
            int prev=listOfPosition.get(i-1)[1];
            int present=listOfPosition.get(i)[0];
            int next=listOfPosition.get(i)[1];
            {
              mapMainTemplate.put(flag,stringTemplate.substring(prev,present));
              flag++;
              mapMainTemplate.put(flag,stringTemplate.substring(present,next));
              setMainTemplate.add(flag);
            }
            flag++;
        }
        Integer processing=listOfPosition.get(listOfPosition.size()-1)[1];
        if(processing !=stringTemplate.length()) {
            mapMainTemplate.put(flag,stringTemplate.substring(processing,stringTemplate.length() - 1));
        }
        return mapMainTemplate;
    }
}
