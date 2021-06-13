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
    private HashSet<UUID> uuids = new HashSet<>();

    public CapeUtil() {
        getCapes();
    }

    private void getCapes() {
        try {
            URL githubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/uuids");
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(githubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String line;
            while ((line = reader.readLine()) != null) {
                uuids.add(UUID.fromString(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasCape(UUID uuid) {
        return uuids.contains(uuid);
    }
}
