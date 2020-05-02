package uk.newcastle.reader.xpp3;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Xpp3Demo {
    @Test
    public void testXpp3Read() throws IOException, XmlPullParserException {
        File pom = new File("src\\main\\resources\\xml\\pom.xml");
        MavenXpp3Reader pomReader = new MavenXpp3Reader();
        Model model = pomReader.read(new FileReader(pom));
        String s = model.toString();
        System.out.println(s);
    }

    
}
