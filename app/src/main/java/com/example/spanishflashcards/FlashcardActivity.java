package com.example.spanishflashcards;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlashcardActivity extends AppCompatActivity {

    private String[][] cards;
    private final List<Integer> order = new ArrayList<>();
    private int position = 0;
    private boolean showingFront = true;

    private TextView cardText;
    private TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        String groupName = getIntent().getStringExtra("group");
        cards = CardData.GROUPS.get(groupName);
        if (cards == null) {
            groupName = CardData.GROUPS.keySet().iterator().next();
            cards = CardData.GROUPS.get(groupName);
        }
        setTitle(groupName);

        for (int i = 0; i < cards.length; i++) {
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
        cardText.setText(showingFront ? cards[cardIndex][0] : cards[cardIndex][1]);
        counterText.setText((position + 1) + " of " + cards.length);
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
