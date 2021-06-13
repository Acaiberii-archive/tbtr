package me.acaiberii.tbtr.utility;

import org.json.simple.JSONObject;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.UUID;

public class CapeUtil {
    public void addCape(UUID uuid) {
        try {
            HttpURLConnection urlConn;
            URL mUrl = new URL("https://TBTRCapes.acaiberii.repl.co/");
            urlConn = (HttpURLConnection) mUrl.openConnection();
            urlConn.addRequestProperty("Content-Type", "application/" + "POST");
            urlConn.setDoOutput(true);
            JSONObject queryBeforeString = new JSONObject();
            queryBeforeString.put("method", "append");
            queryBeforeString.put("uuid", uuid.toString());
            String query = queryBeforeString.toJSONString();
            if (!Objects.isNull(query)) {
                urlConn.setRequestProperty("Content-Length", Integer.toString(query.length()));
                urlConn.getOutputStream().write(query.getBytes("UTF8"));
            }
        } catch (Exception e) {

        }
    }

    public boolean hasCape(UUID uuid) {
        try {
            String message = "";
            HttpURLConnection urlConn;
            URL mUrl = new URL("https://TBTRCapes.acaiberii.repl.co/");
            urlConn = (HttpURLConnection) mUrl.openConnection();
            urlConn.addRequestProperty("Content-Type", "application/" + "POST");
            urlConn.setDoOutput(true);
            JSONObject queryBeforeString = new JSONObject();
            queryBeforeString.put("method", "read");
            String query = queryBeforeString.toJSONString();
            if (!Objects.isNull(query)) {
                urlConn.setRequestProperty("Content-Length", Integer.toString(query.length()));
                urlConn.getOutputStream().write(query.getBytes("UTF8"));
                message = urlConn.getResponseMessage();
            }
            boolean returnStatement = false;
            for (String inUuid : message.split(",")) {
                if (returnStatement) { }
                else if (!returnStatement) {
                    if (inUuid == uuid.toString()) returnStatement = true;
                    else returnStatement = false;
                }
            }
            return returnStatement;
        } catch (Exception e) {
            return false;
        }
    }
}
