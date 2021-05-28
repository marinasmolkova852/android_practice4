package ru.mirea.smolkova.mireaproject.ui.browser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.smolkova.mireaproject.R;

public class BrowserFragment extends Fragment{

    WebView web;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_browser, container, false);
        web = root.findViewById(R.id.ww);
        web.setWebViewClient(new WebViewClient());
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.ru/"));
        Uri data = intent.getData();
        web.loadUrl(data.toString());
        return root;
    }
}
