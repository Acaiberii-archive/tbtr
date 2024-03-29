package me.acaiberii.tbtr.utility.get;

import me.acaiberii.tbtr.storage.Info;
import me.acaiberii.tbtr.storage.Versions;
import me.acaiberii.tbtr.utility.act.Actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import static me.acaiberii.tbtr.tbtr.logger;

public class Version {
    public static void getVersion() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-resources/main/latest");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(url.openStream()));
            String Line;
            Line = bfr.readLine();
            if (!Versions.version.equals(Line)) {
                Info.isOutdated = true;
                Versions.latestVersion = Line;
            }
            else {
                Info.isOutdated = false;
                Versions.latestVersion = Line;
            }
        } catch (Exception e) {
            logger.error(Actions.formatError("getting version"));
            e.printStackTrace();
        }
    }
}
