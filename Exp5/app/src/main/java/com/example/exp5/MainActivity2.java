package com.example.exp5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText edt1 = findViewById(R.id.ed1);
        Button b = findViewById(R.id.b1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edt1.getText().toString();
                if (url.isEmpty()) {
                    edt1.requestFocus();
                    edt1.setError("Cannot be empty");
                } else if (!url.startsWith("http://") && !url.startsWith("https://")) {
                edt1.requestFocus();
                edt1.setError("Url is not correct");
                } else if (url.startsWith("http://") || url.startsWith("https://"))
                {
// Check if a valid domain name with TLD is present (e.g.nmims.edu)
                    int indexOfProtocol = url.indexOf("://");
                    int indexOfSlash = url.indexOf("/", indexOfProtocol + 3);
                    String domain = url.substring(indexOfProtocol + 3, indexOfSlash != -1 ? indexOfSlash : url.length());
                    if (isValidDomain(domain)) {
// URL is valid, show confirmation dialog
                        AlertDialog.Builder alertDialogBuilder = new
                                AlertDialog.Builder(MainActivity2.this);
                        alertDialogBuilder.setMessage("Do you want to continue?");
                        alertDialogBuilder.setPositiveButton("Yes", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        WebView wv1 = findViewById(R.id.wv1);
                                        wv1.loadUrl(url);
                                    }
                                });
                        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        dialog.dismiss();
                                    }
                                });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    } else {
                        edt1.requestFocus();
                        edt1.setError("Invalid URL. Please provide a complete domain name with TLD.");
                    }
                }
            }
        });
    }
    // Function to check if a domain name has a valid TLD (e.g., nmims.edu)
    private boolean isValidDomain(String domain) {
        String[] validTLDs = {"com","edu","org","net","gov", "mil","int"};
        for (String tld : validTLDs) {
            if (domain.endsWith("." + tld)) {
                return true;
            }
        }
        return false;
    }
}
