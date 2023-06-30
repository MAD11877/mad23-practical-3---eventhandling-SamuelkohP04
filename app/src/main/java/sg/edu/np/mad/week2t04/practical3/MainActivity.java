package sg.edu.np.mad.week2t04.practical3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //private TextView nameHol;
    //private TextView description;

    private User user;
    private Button followButton;
    private Button messageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeToolbar();
        // Instantiating buttons and placeholders
        //_________________________________________________________________________________________
        TextView nameHolder = findViewById(R.id.textView);
        TextView descHolder= findViewById(R.id.lorem_ipsum_textview);
        followButton = findViewById(R.id.btn2);
        messageButton = findViewById(R.id.btn3);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String desc = intent.getStringExtra("Desc");
        int id = intent.getIntExtra("Id", 0);

        // Load data from the User object
        //_________________________________________________________________________________________
        user = new User(name, desc, id, false); // User object is instantiated as empty, on purpose
        nameHolder.setText(user.getName());
        descHolder.setText(user.getDescription());


        // Set the text of the Follow button based on the value of the followed variable
        //_________________________________________________________________________________________
        if (user.isFollowed()) {
            String unfollow = "Unfollow";
            followButton.setText(unfollow);
        } else {
            String follow = "Follow";
            followButton.setText(follow);
        }

        // Set an OnClickListener for the Follow button
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the value of the followed variable
                user.setFollowed(!user.isFollowed());

                // Update the text of the Follow button
                updateFollowButton();
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });
    }

    //Method for updating follow button
    //_________________________________________________________________________________________
    private void updateFollowButton(){
        if (user.isFollowed()) {
            Toast.makeText(MainActivity.this,"Followed!",Toast.LENGTH_SHORT).show();
            String unfollow = "Unfollow";
            followButton.setText(unfollow);

        } else {
            Toast.makeText(MainActivity.this,"Unfollowed!",Toast.LENGTH_SHORT).show();
            String follow = "Follow";
            followButton.setText(follow);
        }
    }

    private void makeToolbar(){
        //Toolbar
        //________________________________________________________
        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        // Set the title text color to white
        toolbar.setTitleTextColor(Color.WHITE);
    }
}
