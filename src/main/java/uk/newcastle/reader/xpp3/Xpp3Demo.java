package uk.newcastle.reader.xpp3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Xpp3Demo {

    private Logger log = LogManager.getLogger(Xpp3Demo.class);

    @Test
    public void testXpp3Read() throws IOException, XmlPullParserException {
        //File pom = new File("src\\main\\resources\\xml\\pom.xml");
        File pom = new File("src\\main\\resources\\xml\\hibernate-2.1.8-atlassian-34.pom");
        //File pom = new File("src\\main\\resources\\xml\\antlr-2.7.7.redhat-7.pom");
        MavenXpp3Reader pomReader = new MavenXpp3Reader();
        Model model = pomReader.read(new FileReader(pom));

        log.info("Parent:{}",model.getParent());
        System.out.println(model.getParent());

        List<Dependency> dependencies = model.getDependencies();
        //dependencies.forEach(System.out::println);
        System.out.println(model.getDependencies());

        List<Plugin> plugins = model.getBuild().getPlugins();
        //plugins.forEach(System.out::println);
        System.out.println(model.getBuild().getPlugins());

        System.out.println(model);
        System.out.println(model.getArtifactId());
        System.out.println(model.getGroupId());
        System.out.println(model.getVersion());
    }
}
