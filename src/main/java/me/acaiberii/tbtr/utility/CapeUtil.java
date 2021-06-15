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
    private HashSet<UUID> ytUuids = new HashSet<>();
    private HashSet<UUID> pmcUuids = new HashSet<>();
    private HashSet<UUID> twitchUuids = new HashSet<>();

    public CapeUtil() {
        getRegCapes();
        getBrokCapes();
        getStellaCapes();
        getAcaiCapes();
        getYTCapes();
        getPMCCapes();
        getTwitchCapes();
    }

    private void getRegCapes() {
        try {
            URL GithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/reg-uuids");

            BufferedReader Reader = null;
            try {
                Reader = new BufferedReader(new InputStreamReader(GithubFile.openStream()));

            } catch (IOException e) {
                e.printStackTrace();
            }

            String regLine;
            while ((regLine = Reader.readLine()) != null) {
                regUuids.add(UUID.fromString(regLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getBrokCapes() {
        try {
            URL GithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/brok-uuids");

            BufferedReader Reader = null;
            try {
                Reader = new BufferedReader(new InputStreamReader(GithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String brokLine;
            while ((brokLine = Reader.readLine()) != null) {
                brokUuids.add(UUID.fromString(brokLine));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getStellaCapes() {
        try {
            URL GithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/stella-uuids");

            BufferedReader Reader = null;
            try {
                Reader = new BufferedReader(new InputStreamReader(GithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String Line;
            while ((Line = Reader.readLine()) != null) {
                stellaUuids.add(UUID.fromString(Line));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAcaiCapes() {
        try {
            URL GithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/berii-uuids");

            BufferedReader acaiReader = null;
            try {
                acaiReader = new BufferedReader(new InputStreamReader(GithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String Line;
            while ((Line = acaiReader.readLine()) != null) {
                acaiUuids.add(UUID.fromString(Line));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getYTCapes() {
        try {
            URL GithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/yt-uuids");

            BufferedReader Reader = null;
            try {
                Reader = new BufferedReader(new InputStreamReader(GithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String Line;
            while ((Line = Reader.readLine()) != null) {
                ytUuids.add(UUID.fromString(Line));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getPMCCapes() {
        try {
            URL GithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/pmc-uuids");

            BufferedReader Reader = null;
            try {
                Reader = new BufferedReader(new InputStreamReader(GithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String Line;
            while ((Line = Reader.readLine()) != null) {
                pmcUuids.add(UUID.fromString(Line));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getTwitchCapes() {
        try {
            URL GithubFile = new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/twitch-uuids");

            BufferedReader Reader = null;
            try {
                Reader = new BufferedReader(new InputStreamReader(GithubFile.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String Line;
            while ((Line = Reader.readLine()) != null) {
                twitchUuids.add(UUID.fromString(Line));
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

    public boolean hasYTCape(UUID uuid) {
        return ytUuids.contains(uuid);
    }

    public boolean hasPMCCape(UUID uuid) {
        return pmcUuids.contains(uuid);
    }

    public boolean hasTwitchCape(UUID uuid) {
        return twitchUuids.contains(uuid);
    }
}
