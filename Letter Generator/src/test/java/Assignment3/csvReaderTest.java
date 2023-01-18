package Assignment3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class csvReaderTest {
    CsvReader o=new CsvReader();
    private String file;
    private String file1;
    private List<String> csvList;
    @BeforeEach
    void setup()
    {
        file="insurance-company-members2.csv";
    }
    @Test
    void readFile()  {
        csvList= o.readFileAsList(file);
        for(int i=0;i<csvList.size();i++)
        {
            System.out.println(csvList.get(i));
        }
    }
    @Test
    public void noFile() {
        file1="insurance-company-members empty.csv";
        csvList= o.readFileAsList(file1);
    }

    @Test
    void readFileAsList() {
        file="insurance-company-members2.csv";
        csvList= o.readFileAsList(file);
        for(int i=0;i<csvList.size();i++)
        {
            System.out.println(csvList.get(i));
        }
    }

    @Test
    void processListCsv() {
        Set<Map<String, String>> processingSet = new HashSet<>();
        file="insurance-company-members2.csv";
        processingSet= o.processListCsv(file);
        System.out.println(processingSet);
    }

    @Test
    void processLines() {
        String a="[first_name, last_name, company_name, address, city, county, state, zip, phone1, phone2, email, web, hobby]";
        o.processLines(a);
    }
}