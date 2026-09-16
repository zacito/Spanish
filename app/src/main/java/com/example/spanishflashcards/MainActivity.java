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
package com.example.spanishflashcards;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String[][] CARDS = {
        {"hola", "hello"},
        {"adiós", "goodbye"},
        {"gracias", "thank you"},
        {"por favor", "please"},
        {"sí", "yes"},
        {"no", "no"},
        {"bueno", "good"},
        {"malo", "bad"},
        {"grande", "big"},
        {"pequeño", "small"},
        {"nuevo", "new"},
        {"viejo", "old"},
        {"hombre", "man"},
        {"mujer", "woman"},
        {"niño", "boy"},
        {"niña", "girl"},
        {"agua", "water"},
        {"comida", "food"},
        {"casa", "house"},
        {"coche", "car"},
        {"libro", "book"},
        {"perro", "dog"},
        {"gato", "cat"},
        {"día", "day"},
        {"noche", "night"},
        {"mañana", "tomorrow"},
        {"tiempo", "time"},
        {"dinero", "money"},
        {"amor", "love"},
        {"amigo", "friend"},
        {"familia", "family"},
        {"trabajo", "work"},
        {"escuela", "school"},
        {"ciudad", "city"},
        {"país", "country"},
        {"¿Cómo estás?", "How are you?"},
        {"¿Cuánto cuesta?", "How much does it cost?"},
        {"¿Dónde está...?", "Where is...?"},
        {"Lo siento", "I'm sorry"},
        {"De nada", "You're welcome"}
    };

    private final List<Integer> order = new ArrayList<>();
    private int position = 0;
    private boolean showingFront = true;

    private TextView cardText;
    private TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < CARDS.length; i++) {
            order.add(i);
        }

        cardText = findViewById(R.id.card_text);
        counterText = findViewById(R.id.counter_text);

        cardText.setOnClickListener(v -> flip());
        findViewById(R.id.flip_button).setOnClickListener(v -> flip());

        Button prevButton = findViewById(R.id.prev_button);
        prevButton.setOnClickListener(v -> {
            position = (position - 1 + order.size()) % order.size();
            showingFront = true;
            showCard();
        });

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(v -> {
            position = (position + 1) % order.size();
            showingFront = true;
            showCard();
        });

        Button shuffleButton = findViewById(R.id.shuffle_button);
        shuffleButton.setOnClickListener(v -> {
            Collections.shuffle(order);
            position = 0;
            showingFront = true;
            showCard();
        });

        showCard();
    }

    private void flip() {
        showingFront = !showingFront;
        showCard();
    }

    private void showCard() {
        int cardIndex = order.get(position);
        cardText.setText(showingFront ? CARDS[cardIndex][0] : CARDS[cardIndex][1]);
        counterText.setText((position + 1) + " of " + CARDS.length);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
        outState.putBoolean("showingFront", showingFront);
        int[] savedOrder = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            savedOrder[i] = order.get(i);
        }
        outState.putIntArray("order", savedOrder);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("position", 0);
        showingFront = savedInstanceState.getBoolean("showingFront", true);
        int[] savedOrder = savedInstanceState.getIntArray("order");
        if (savedOrder != null) {
            order.clear();
            for (int cardIndex : savedOrder) {
                order.add(cardIndex);
            }
        }
        showCard();
    }
}
