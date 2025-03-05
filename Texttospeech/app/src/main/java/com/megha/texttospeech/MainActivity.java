package com.megha.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    EditText editText;
    Button btn;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit1);
        btn = findViewById(R.id.btn);


        // Initialize TextToSpeech
        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            // Set language
            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Language not supported
            } else {
                // TTS is ready, speak something
                speakText("Hello, this is a text-to-speech test!");
            }
        }
    }

    private void speakText(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @Override
    protected void onDestroy() {
        // Shutdown TextToSpeech to free up resources
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
