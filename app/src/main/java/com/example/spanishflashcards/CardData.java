package com.example.spanishflashcards;

import java.util.LinkedHashMap;
import java.util.Map;

public class CardData {

    public static final Map<String, String[][]> GROUPS = new LinkedHashMap<>();

    static {
        GROUPS.put("Greetings & Phrases", new String[][]{
            {"hola", "hello"},
            {"adiós", "goodbye"},
            {"gracias", "thank you"},
            {"por favor", "please"},
            {"sí", "yes"},
            {"no", "no"},
            {"¿Cómo estás?", "How are you?"},
            {"¿Cuánto cuesta?", "How much does it cost?"},
            {"¿Dónde está...?", "Where is...?"},
            {"Lo siento", "I'm sorry"},
            {"De nada", "You're welcome"}
        });

        GROUPS.put("People", new String[][]{
            {"hombre", "man"},
            {"mujer", "woman"},
            {"niño", "boy"},
            {"niña", "girl"},
            {"amigo", "friend"},
            {"familia", "family"}
        });

        GROUPS.put("Adjectives", new String[][]{
            {"bueno", "good"},
            {"malo", "bad"},
            {"grande", "big"},
            {"pequeño", "small"},
            {"nuevo", "new"},
            {"viejo", "old"}
        });

        GROUPS.put("Everyday Words", new String[][]{
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
            {"trabajo", "work"},
            {"escuela", "school"},
            {"ciudad", "city"},
            {"país", "country"}
        });

        GROUPS.put("Colors", new String[][]{
            {"rojo", "red"},
            {"azul", "blue"},
            {"verde", "green"},
            {"amarillo", "yellow"},
            {"naranja", "orange"},
            {"morado", "purple"},
            {"rosa", "pink"},
            {"negro", "black"},
            {"blanco", "white"},
            {"gris", "gray"},
            {"marrón", "brown"}
        });

        GROUPS.put("Days of the Week", new String[][]{
            {"lunes", "Monday"},
            {"martes", "Tuesday"},
            {"miércoles", "Wednesday"},
            {"jueves", "Thursday"},
            {"viernes", "Friday"},
            {"sábado", "Saturday"},
            {"domingo", "Sunday"}
        });

        GROUPS.put("Months", new String[][]{
            {"enero", "January"},
            {"febrero", "February"},
            {"marzo", "March"},
            {"abril", "April"},
            {"mayo", "May"},
            {"junio", "June"},
            {"julio", "July"},
            {"agosto", "August"},
            {"septiembre", "September"},
            {"octubre", "October"},
            {"noviembre", "November"},
            {"diciembre", "December"}
        });

        GROUPS.put("Numbers", new String[][]{
            {"uno", "1"},
            {"dos", "2"},
            {"tres", "3"},
            {"cuatro", "4"},
            {"cinco", "5"},
            {"seis", "6"},
            {"siete", "7"},
            {"ocho", "8"},
            {"nueve", "9"},
            {"diez", "10"},
            {"once", "11"},
            {"doce", "12"},
            {"trece", "13"},
            {"catorce", "14"},
            {"quince", "15"},
            {"dieciséis", "16"},
            {"diecisiete", "17"},
            {"dieciocho", "18"},
            {"diecinueve", "19"},
            {"veinte", "20"}
        });
    }
}
