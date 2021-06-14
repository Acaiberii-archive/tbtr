package me.acaiberii.tbtr.utility;

import me.acaiberii.tbtr.util.capes.CapeEnum;
import me.acaiberii.tbtr.util.capes.CapeType;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/*
This is from Gav06's GavHack, taken from Gamesense. :)
*/

public class CapeUtil {
    public HashSet<CapeType> capes = new HashSet<>();

    public CapeUtil() {
        try {
            CapeType berii = new CapeType(new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/berii-uuids"), CapeEnum.BERII);
            capes.add(berii);
            CapeType stella = new CapeType(new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/stella-uuids"), CapeEnum.STELLA);
            capes.add(stella);
            CapeType brok = new CapeType(new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/brok-uuids"), CapeEnum.BROOK);
            capes.add(stella);
            CapeType regular = new CapeType(new URL("https://raw.githubusercontent.com/AcaiBerii/tbtr-capes/main/reg-uuids"), CapeEnum.REGULAR);
            capes.add(regular);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public boolean hasCape(CapeEnum capeEnum, UUID uuid) {
        CapeType thisCape = getNullCape();
        thisCape = getCape(capeEnum);
        return thisCape.getCapes().contains(uuid);
    }

    public CapeType getCape(CapeEnum capeEnum) {
        for (CapeType cape : capes) {
            if (cape.getCapeEnum() == capeEnum) {
                return cape;
            }
        }
        return getNullCape();
    }

    public CapeType getNullCape() {
        return new CapeType(null, null);
    }
}
