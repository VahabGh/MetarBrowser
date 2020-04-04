package com.vahabgh.metarbrowser.main.data.api;

import java.util.List;

public interface TextFileDownloadListener {

    void onStart();

    void onComplete(String text);

    void onError(Exception exp);

}
