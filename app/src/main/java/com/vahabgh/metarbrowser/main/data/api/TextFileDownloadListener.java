package com.vahabgh.metarbrowser.main.data.api;

import java.util.List;

public interface TextFileDownloadListener {

    void onStart();

    void onComplete(List<String> lines);

    void onError(Exception exp);

}
