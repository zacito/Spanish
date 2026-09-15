# Spanish Flashcards App
A simple, no-frills Android flashcard app for learning beginner Spanish.
40 common words and phrases with English translations.

- **Tap the card** (or the Flip button) to flip between Spanish and English
- **← Prev / Next →** to move through the deck (wraps around)
- **Shuffle** to randomize the deck order

Same build setup as the Media Remote app, so the same GitHub Actions workflow produces the APK.

## Getting the APK (the usual flow)

1. Create a new repo on GitHub (public or private) for this project.
2. Push this project's files to the repo's `main` branch.
3. The **Build APK** workflow (`.github/workflows/build-apk.yml`) runs automatically on push. You can also trigger it manually from the Actions tab.
4. When the run finishes, open it in the Actions tab and download the **spanish-flashcards-apk** artifact (you must be signed in to GitHub to download artifacts).
5. Install `app-debug.apk` on your phone.

## Adding more cards

Edit the `CARDS` array in `app/src/main/java/com/example/spanishflashcards/MainActivity.java` — each entry is `{"spanish", "english"}`. Commit and push; the workflow rebuilds the APK automatically.
