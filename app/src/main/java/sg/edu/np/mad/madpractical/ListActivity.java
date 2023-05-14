package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    final String TITLE = "List Activity";
    User myUser = new User("Hello world","Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua", 1, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        ImageView profile = findViewById(R.id.imageView);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Profile button is pressed");
                profileClicked();
            }
        });
        Log.v(TITLE,"On Resume!");
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

    private void profileClicked(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        //builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                int id = randomNoGenerator();
                String k = String.valueOf(id);

                Intent activityName = new Intent(ListActivity.this, MainActivity.class);
                activityName.putExtra("key", k);

                Log.v(TITLE, k);
                //Log.v(TITLE, String.valueOf(myUser.getId()));
                startActivity(activityName);
            }
        });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                dialogInterface.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private int randomNoGenerator(){
        Random rand = new Random();
        int myNumber = Math.abs(rand.nextInt(2147483647));
        return myNumber;
    }
}

