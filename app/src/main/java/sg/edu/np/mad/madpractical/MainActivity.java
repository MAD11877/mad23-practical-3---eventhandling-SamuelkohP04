package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User myUser = new User("MAD","Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua", 1, false);
    final String TITLE = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiating text and button objects
        TextView myTextName = findViewById(R.id.textView10);
        myTextName.setText(myUser.getName());

        TextView myTextDesc = findViewById(R.id.textView13);
        myTextDesc.setText(myUser.getDescription());

        Button followButton = findViewById(R.id.btn1);
        Button messageButton = findViewById(R.id.btn2);

        Log.v(TITLE,"On create");

        TextView name = findViewById(R.id.textView10);
        // Retrieve the intent when going back from Page 2
        Intent intent = getIntent();
        String k = intent.getStringExtra("key");
        int id = Integer.parseInt(k);

        myUser.setId(id);
        name.setText(myUser.getName() + ' ' + myUser.getId());
        //onResume();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE,"On Resume!");

        Button followButton = findViewById(R.id.btn1);
        Button messageButton = findViewById(R.id.btn2);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myUser.setFollowed(!myUser.isFollowed());
                Log.v(TITLE, "Follow button is pressed");

                //Log.v(TITLE, String.valueOf(hasFollowed));
                if (myUser.isFollowed()) {
                    followButton.setText("Unfollow");
                    Toast.makeText (getApplicationContext (),
                            "Followed", Toast.LENGTH_SHORT).show();
                    }
                else {
                    followButton.setText("Follow");
                    Toast.makeText (getApplicationContext (),
                            "Unfollowed", Toast.LENGTH_SHORT).show();}
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Message button is pressed");
            }
        });
    }


    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE, "On Stop!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TITLE,"On Pause!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy");
    }
}