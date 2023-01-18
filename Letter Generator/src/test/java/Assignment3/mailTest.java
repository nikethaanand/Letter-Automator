package Assignment3;

import org.junit.jupiter.api.Test;

class mailTest {

    @Test
    void mainCreateEmail() throws Exception {
        Mail m=new Mail();
        String csv="insurance-company-members2.csv";
        String outputDir="email";
        String templateName="letter-template.txt";
        String email="letter";
        m.mainCreateEmail(csv,outputDir,email,templateName);
    }
}