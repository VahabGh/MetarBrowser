package com.vahabgh.metarbrowser.main.data.api;


import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class TextFileDownloaderImpl implements TextFileDownloader {

    private TextFileDownloadListener textFileDownloadListener;
    private String path;

    public void setTextFileDownloadListener(TextFileDownloadListener textFileDownloadListener) {
        this.textFileDownloadListener = textFileDownloadListener;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void start() {

        if (!isPathValid()) {
            textFileDownloadListener.onError(new Exception("the path is not set properly"));
            return;
        }

        new DownloadTask(path);
    }

    private boolean isPathValid() {
        return !path.equals("");
    }

    private void startDownload(String path) {

        List<String> lines = new ArrayList<>();
        int count;

        try {

            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            connection.setReadTimeout(3000);
            connection.connect();
            InputStream is = url.openStream();
            byte data[] = new byte[1024];
            String text = "";

            while ((count = is.read(data)) != -1)
                text = new String(data);

            is.close();

            for (String item : text.split("\\R"))
                lines.add(item);
            textFileDownloadListener.onComplete(lines);

        } catch (Exception exp) {
            textFileDownloadListener.onError(exp);
        }

    }


    class DownloadTask extends AsyncTask<Void, String, Void> {

        String query;

        public DownloadTask(String query) {
            this.query = query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            startDownload(query);
            return null;
        }
    }


}
