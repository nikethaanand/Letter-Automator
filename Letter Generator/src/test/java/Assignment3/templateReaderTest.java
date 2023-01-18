package Assignment3;

import org.junit.jupiter.api.Test;

import java.util.List;

class templateReaderTest {
    TemplateReader o=new TemplateReader();
    List<Integer[]> testList;
    private String template="email-template.txt";
    private String fileName="insurance-company-members2.csv";
    @Test
    void readFileAsList() {
       System.out.println(o.readFileAsList(template));
    }
    @Test
    void combineStringMap()
    {
        CsvReader csv=new CsvReader();
        List<String> csvList;
        String template;
        List<Integer[]> placeholderPositions;
        csvList = csv.readFileAsList(fileName);
        TemplateReader temp=new TemplateReader();
        template = temp.templateLineProcessor(csvList);
        placeholderPositions = temp.positionFinderInTemplate(template);
    }
}