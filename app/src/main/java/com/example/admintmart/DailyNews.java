package com.example.admintmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class DailyNews extends AppCompatActivity {

    private EditText header,contents;
    private ImageView select_image;
    private Button publish;
    private TextView date;
    private int yy;
    private int mm,dd;

    private String title,content,month_name;
    private String saveCurrentDate,saveCurrentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_news);

        header=(EditText)findViewById(R.id.header);
        contents=(EditText)findViewById(R.id.contents);
        date=(TextView)findViewById(R.id.date);
        publish=findViewById(R.id.publish);



        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        month_name = month_date.format(cal.getTime());

        final Calendar c = Calendar.getInstance();
        yy = c.get(Calendar.YEAR);
        mm = c.get(Calendar.MONTH);
        dd = c.get(Calendar.DAY_OF_MONTH);


        // set current date into textview
        date.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(dd).append(" ").append(month_name).append(",")
                .append(yy));

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate();
            }
        });

    }

    private void Validate() {
        title=header.getText().toString();
        content=contents.getText().toString();

        if(TextUtils.isEmpty(title))
        {
            header.setError("This field is required");
            header.requestFocus();
        }
       else if (TextUtils.isEmpty(content))
        {
            contents.setError("This field is required");
            contents.requestFocus();
        }
        else
        {
            StoreNews();
        }

    }

    private void StoreNews() {

        Calendar calendar=Calendar.getInstance();

        SimpleDateFormat currentdate=new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate=currentdate.format(calendar.getTime());

        SimpleDateFormat currenttime=new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime=currenttime.format(calendar.getTime());


        DatabaseReference db= FirebaseDatabase.getInstance().getReference().child("Daily News").child(saveCurrentDate);

        HashMap<String,Object> dailynews=new HashMap<>();
        dailynews.put("Title",title);
        dailynews.put("Content",content);
        dailynews.put("Date",saveCurrentDate);
        dailynews.put("Time",saveCurrentTime);

        db.updateChildren(dailynews).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(DailyNews.this, "News Published", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DailyNews.this,Home.class);
                startActivity(i);
                finish();
            }
        });


    }


}
