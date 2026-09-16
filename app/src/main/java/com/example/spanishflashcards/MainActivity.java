package com.example.spanishflashcards;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout groupList = findViewById(R.id.group_list);

        for (String groupName : CardData.GROUPS.keySet()) {
            String[][] cards = CardData.GROUPS.get(groupName);

            Button button = new Button(this);
            button.setText(groupName + " (" + cards.length + ")");
            button.setOnClickListener(v -> {
                Intent intent = new Intent(this, FlashcardActivity.class);
                intent.putExtra("group", groupName);
                startActivity(intent);
            });

            groupList.addView(button);
        }
    }
}
