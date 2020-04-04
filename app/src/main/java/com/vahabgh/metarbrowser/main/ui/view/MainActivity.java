package com.vahabgh.metarbrowser.main.ui.view;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.vahabgh.metarbrowser.R;
import com.vahabgh.metarbrowser.databinding.ActivityMainBinding;
import com.vahabgh.metarbrowser.main.data.api.TextFileDownloaderImpl;
import com.vahabgh.metarbrowser.main.data.db.MetarCacheServiceImpl;
import com.vahabgh.metarbrowser.main.data.repository.Repository;
import com.vahabgh.metarbrowser.main.data.repository.RepositoryImpl;
import com.vahabgh.metarbrowser.main.ui.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViewModel();
        setSearchClickListener();
    }

    private void setSearchClickListener() {
        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = ((AppCompatEditText) findViewById(R.id.etSearch)).getText().toString().toUpperCase();
                mainViewModel.getData(query);
                hideKeyboard();
            }
        });


        findViewById(R.id.errorView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
            }
        });
    }


    private void initViewModel() {
        Repository repository = new RepositoryImpl(getApplicationContext(), new MetarCacheServiceImpl(getApplicationContext()), new TextFileDownloaderImpl());
        MainViewModel.Factory factory = new MainViewModel.Factory(repository);
        mainViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainViewModel(mainViewModel);
        binding.setLifecycleOwner(this);
    }


    public void hideKeyboard() {
        if (getCurrentFocus() == null) return;
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}
