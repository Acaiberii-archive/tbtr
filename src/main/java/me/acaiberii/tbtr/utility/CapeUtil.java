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
    private HashSet<UUID> brokUuids = new HashSet<>();
    private HashSet<UUID> stellaUuids = new HashSet<>();
    private HashSet<UUID> acaiUuids = new HashSet<>();

    public CapeUtil() {
        getRegCapes();
        getBrokCapes();
        getAcaiCapes();
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

    private void getBrokCapes() {
        try {
            URL brokGithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/brok-uuids");

            BufferedReader brokReader = null;
            try {
                brokReader = new BufferedReader(new InputStreamReader(brokGithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String brokLine;
            while ((brokLine = brokReader.readLine()) != null) {
                brokUuids.add(UUID.fromString(brokLine));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getStellaCapes() {
        try {
            URL stellaGithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/stella-uuids");

            BufferedReader stellaReader = null;
            try {
                stellaReader = new BufferedReader(new InputStreamReader(stellaGithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String stellaLine;
            while ((stellaLine = stellaReader.readLine()) != null) {
                stellaUuids.add(UUID.fromString(stellaLine));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAcaiCapes() {
        try {
            URL acaiGithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/stella-uuids");

            BufferedReader acaiReader = null;
            try {
                acaiReader = new BufferedReader(new InputStreamReader(acaiGithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String acaiLine;
            while ((acaiLine = acaiReader.readLine()) != null) {
                acaiUuids.add(UUID.fromString(acaiLine));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasRegCape(UUID uuid) {
        return regUuids.contains(uuid);
    }

    public boolean hasBrokCape(UUID uuid) {
        return brokUuids.contains(uuid);
    }

    public boolean hasStellaCape(UUID uuid) {
        return stellaUuids.contains(uuid);
    }

    public boolean hasAcaiCape(UUID uuid) {
        return acaiUuids.contains(uuid);
    }
}
