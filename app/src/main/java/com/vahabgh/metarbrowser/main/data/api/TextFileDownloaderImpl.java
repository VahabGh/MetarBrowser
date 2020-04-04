package com.vahabgh.metarbrowser.main.data.api;


import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

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

        if (textFileDownloadListener == null)
            throw new IllegalArgumentException("Text file downloader should text file download listener");


        if (!isPathValid()) {
            textFileDownloadListener.onError(new Exception("the path is not set properly"));
            return;
        }

        new DownloadTask(path).execute();
    }

    private boolean isPathValid() {
        return !path.equals("");
    }

    private void startDownload(String path) {

        int count;

        try {

            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            connection.setReadTimeout(10000);//ten seconds
            connection.connect();
            InputStream is = url.openStream();
            byte data[] = new byte[1024];
            StringBuilder text = new StringBuilder();

            while ((count = is.read(data)) != -1)
                text.append(new String(data));

            is.close();

            textFileDownloadListener.onComplete(text.toString());

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
