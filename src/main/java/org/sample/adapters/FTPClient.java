package org.sample.adapters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FTPClient {
    boolean connected;

    @Value("${ftpclient.server}")
    String server;

    @Value("${ftpclient.folder}")
    String folder;

    public FTPClient() {
        System.out.println("FTP client initialize ");
    }

    public void connect()
    {
        System.out.println("Connecting to FTP Server :" + server);
        connected = true;
    }

    public void disconnect()
    {
        System.out.println("Disconnecting from FTP");
        connected = false;
    }

    public boolean getStatus()
    {
        return connected;
    }
}
