package maike_hilda.github.dice_game_544;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String playerInputString = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView errorBox = findViewById(R.id.outputBox);
        TextView pRoll1 = findViewById(R.id.pRoll1);
        TextView pRoll2 = findViewById(R.id.pRoll2);
        TextView cRoll1 = findViewById(R.id.cRoll1);
        TextView cRoll2 = findViewById(R.id.cRoll2);

        // convert player input to int
        int playerRollOne = Integer.parseInt(playerInputString);

        if (playerRollOne > 0 && playerRollOne < 7) {
            System.out.println("You are in the bounds");

            Random rand = new Random();

            // Generate a number between 1 and 6 for player's second roll
            int playerRollTwo = rand.nextInt(6) + 1;

            // Generate Computer's rolls
            int computerRollOne = rand.nextInt(6) + 1;
            int computerRollTwo = rand.nextInt(6) + 1;

            // Capture the layout's TextView and set the string as its text
            pRoll1.setText(playerInputString);
            //playerRollView1
            pRoll2.setText(Integer.toString(playerRollTwo));
            cRoll1.setText(Integer.toString(computerRollOne));
            cRoll2.setText(Integer.toString(computerRollTwo));
        } else {
            System.out.println("else");
            errorBox.setText("Input out of bounds");
        }
    }
}
