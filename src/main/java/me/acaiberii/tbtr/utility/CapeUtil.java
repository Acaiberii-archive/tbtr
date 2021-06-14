package me.acaiberii.tbtr.utility;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

/*
This is from Gav06's GavHack, taken from Gamesense. :)
*/

public class CapeUtil {
    private HashSet<UUID> regUuids = new HashSet<>();

    public CapeUtil() {
        getRegCapes();
    }

    private void getRegCapes() {
        try {
            URL regGithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/reg-uuids");

            BufferedReader regReader = null;
            try {
                regReader = new BufferedReader(new InputStreamReader(regGithubFile.openStream()));

            } catch (IOException e) {
                e.printStackTrace();
            }

            String regLine;
            while ((regLine = regReader.readLine()) != null) {
                regUuids.add(UUID.fromString(regLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasRegCape(UUID uuid) {
        return regUuids.contains(uuid);
    }
}
