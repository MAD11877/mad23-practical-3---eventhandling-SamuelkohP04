package sg.edu.np.mad.week2t04.practical3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    int randomInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        makeToolbar();

        ImageView imageView = findViewById(R.id.imageView1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomInt = generateRandomNumber();
                showAlert("Profile","MADness","View","Close");
            }
        });


    }

    // Method to generate random integer
    //_____________________________________________________________________________________
    private int generateRandomNumber() {
        // Generate a random integer between 1 and 100 (inclusive)
        Random random = new Random();
        return random.nextInt(2147483647);
    }



    // Method to show alert message
    //_____________________________________________________________________________________
    private void showAlert(String title, String message, String p, String n){
        AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(p, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Launch MainActivity and pass the random integer
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("Name","MAD" + randomInt);
                intent.putExtra("Desc", "Lorem ipsum dolor sit amet, consectetur " +
                        "adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua.");
                intent.putExtra("Id", randomInt);
                startActivity(intent);

                dialog.dismiss();
            }
        });
        builder.setNegativeButton(n, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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