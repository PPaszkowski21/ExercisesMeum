package com.example.projektsm.ui.motivation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.projektsm.ui.MainActivity;
import com.example.projektsm.R;

public class MotivationFragment extends Fragment {

    private Button GetMotivationFromApi;
    private TextView QuoteText;
    private TextView AuthorText;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_motivation, container, false);
        QuoteText = root.findViewById(R.id.quoteTextView);
        AuthorText = root.findViewById(R.id.authorTextView);
        GetMotivationFromApi = root.findViewById(R.id.requestButton);
        GetMotivationFromApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.LoadQuoteFromApi(MainActivity.JSON_URL);
                QuoteText.setText(MainActivity.quote.Content);
                AuthorText.setText((MainActivity.quote.Author));
            }
        });
        if(savedInstanceState != null)
        {
            QuoteText.setText(savedInstanceState.getString("quote"));
            AuthorText.setText(savedInstanceState.getString("author"));
        }
        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("quote", (String) QuoteText.getText());
        outState.putString("author", (String) AuthorText.getText());
    }
}