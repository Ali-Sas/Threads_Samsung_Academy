package com.example.threads_samsung_academy;
import static com.example.threads_samsung_academy.DATA.DATA.Ed1;
import static com.example.threads_samsung_academy.DATA.DATA.Ed2;
import static com.example.threads_samsung_academy.DATA.DATA.Ed3;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import com.example.threads_samsung_academy.Threads.Thread1;
import com.example.threads_samsung_academy.Threads.Thread2;
import com.example.threads_samsung_academy.Threads.Thread3;
import com.example.threads_samsung_academy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static Handler handler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            handler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    String str = binding.textView.getText()+ String.valueOf(msg.obj);
                    binding.textView.setText(str);
                }
            };
            binding.But.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    convertEditTextToString(binding.ed1, binding.ed2, binding.ed3);
                }
            });
        }

    private void convertEditTextToString(EditText ed1, EditText ed2, EditText ed3){
        Ed1 = ed1.getText().toString();
        Ed2 = ed2.getText().toString();
        Ed3 = ed3.getText().toString();
        new Thread1().start();
        new Thread2().start();
        new Thread3().start();
    }
}