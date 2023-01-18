package Assignment3;

import org.junit.jupiter.api.Test;

class templateProcessingTest {
    @Test
    void parseTemplate() {
        TemplateProcessing p=new TemplateProcessing();
        String fileName="letter-template.txt";
        p.mainTemplateGenerator(fileName);
    }
}