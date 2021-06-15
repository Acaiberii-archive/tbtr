package me.acaiberii.tbtr.util.get;

import me.acaiberii.tbtr.storage.Info;
import me.acaiberii.tbtr.storage.Versions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import static me.acaiberii.tbtr.tbtr.logger;

public class Version {
    public static void getVersion() {
        try {
            logger.info("Getting version.");
            URL url = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-resources/main/latest");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(url.openStream()));
            String Line;
            Line = bfr.readLine();
            if (!Versions.version.equals(Line)) {
                Info.isOutdated = true;
            }
            else {
                Info.isOutdated = false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
