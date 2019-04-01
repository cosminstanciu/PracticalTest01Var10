package ro.pub.cs.systems.eim.practicaltest01var10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var10MainActivity extends AppCompatActivity {
    private EditText next_term = null;
    private Button add_btn = null;
    private TextView all_terms = null;
    private Button compute_btn = null;

    private buttonClickListener  btnClickListener = new buttonClickListener();
    public static final int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
    private class buttonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.add_btn:
                    String term = (next_term.getText()).toString();
                    if (term.length() != 0) {
                        String my_terms = all_terms.getText().toString();
                        if (my_terms.length() == 0) {
                            my_terms = term ;
                        } else {
                            my_terms += "+" + term;
                        }

                        all_terms.setText(my_terms);
                        next_term.setText("");
                    }

                    break;
                case R.id.compute_btn:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var10SecondaryActivity.class);
                    intent.putExtra("ALL_TERMS", all_terms.getText().toString());
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
            }



        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var10_main);
        next_term = (EditText)findViewById(R.id.next_term_edit_text);
        add_btn = (Button)findViewById(R.id.add_btn);
        all_terms = (TextView)findViewById(R.id.all_terms_text_view);
        compute_btn = (Button)findViewById(R.id.compute_btn);

        all_terms.setText("");
        add_btn.setOnClickListener(btnClickListener);
        compute_btn.setOnClickListener(btnClickListener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "Sum =  " + resultCode, Toast.LENGTH_LONG).show();
        }
    }


}
