/*
Random number guessing game: The computer thinks of a number from 1 to 1000.
The user makes guesses, and after each incorrect guess, the app hints to the
user whether the right answer is higher or lower than their guess. The game
ends when the player guesses the right number.

Todo 1: get the user input
Todo 2: ensure user input is > 0 and <= 1000
Todo 3: enable the button check when the user input is valid

 */

package mg.studio.android.guessme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView t1;
    private EditText t2;
    private Button btn1;
    int x=(int)(Math.random()*1000);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.right1);
        t2=(EditText)findViewById(R.id.edt1);
        btn1=(Button)findViewById(R.id.btn1);
        t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText=t2.getText().toString();
                int y;
                y=Integer.parseInt(inputText);
                if(y>1&&y<1000) {
                    btn1.setVisibility(View.VISIBLE);
                }
                else{
                    btn1.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
    public void right1(View view){

        String inputText=t2.getText().toString();
        int y;
        y=Integer.parseInt(inputText);
        if(x<y){
            t1.setText("the number you guess is \n bigger");
        }
        else if (x>y){
            t1.setText("the number you guess is \n smaller");
        }
        else if (x==y){
            t1.setText("the number you guess is right");

        }


    }
}
