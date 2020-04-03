package com.vahabgh.metarbrowser.main.data.api;

public interface TextFileDownloader {

     void start();

    void setPath(String path);

    void setTextFileDownloadListener(TextFileDownloadListener textFileDownloadListener);
}
