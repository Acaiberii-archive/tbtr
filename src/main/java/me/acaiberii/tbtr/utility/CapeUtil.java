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
    private HashSet<UUID> inkUuids = new HashSet<>();

    public CapeUtil() {
        getCapes();
    }

    private void getCapes() {
        try {
            URL regGithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/reg-uuids");
            URL inkineGithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/inkine-uuids");
            BufferedReader regReader = null;
            BufferedReader inkineReader = null;
            try {
                regReader = new BufferedReader(new InputStreamReader(regGithubFile.openStream()));
                inkineReader = new BufferedReader(new InputStreamReader(inkineGithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String regLine;
            while ((regLine = regReader.readLine()) != null) {
                regUuids.add(UUID.fromString(regLine));
            }

            String inkineLine;
            while ((inkineLine = inkineReader.readLine()) != null) {
                inkUuids.add(UUID.fromString(inkineLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasRegCape(UUID uuid) {
        return regUuids.contains(uuid);
    }
    public boolean hasInkCape(UUID uuid) {
        return inkUuids.contains(uuid);
    }
}
