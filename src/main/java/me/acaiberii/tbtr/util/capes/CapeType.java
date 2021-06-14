package me.acaiberii.tbtr.util.capes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.UUID;

public class CapeType {
    private final URL url;
    private final CapeEnum capeEnum;

    public CapeType(URL url, CapeEnum capeEnum) {
        this.url = url;
        this.capeEnum = capeEnum;
    }

    public URL getUrl() {
        return url;
    }

    public CapeEnum getCapeEnum() {
        return capeEnum;
    }

    public HashSet<UUID> getCapes() {
        HashSet<UUID> regUuids = new HashSet<>();
        try {
            BufferedReader capeReader = null;
            try {
                capeReader = new BufferedReader(new InputStreamReader(url.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String brokLine;
            while ((brokLine = capeReader.readLine()) != null) {
                regUuids.add(UUID.fromString(brokLine));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return regUuids;
    }
}
