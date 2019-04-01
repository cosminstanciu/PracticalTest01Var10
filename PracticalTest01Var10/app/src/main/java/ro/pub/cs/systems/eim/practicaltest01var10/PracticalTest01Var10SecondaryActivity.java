package ro.pub.cs.systems.eim.practicaltest01var10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PracticalTest01Var10SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var10_secondary);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("ALL_TERMS")) {
            String all_terms = intent.getStringExtra("ALL_TERMS");
            String[] terms = all_terms.split("\\+");
            int sum = 0;
            for (int i = 0; i < terms.length; i++) {
                int term = Integer.parseInt(terms[i]);
                sum += term;
            }
            setResult(sum);
            finish();
        }
    }
}
