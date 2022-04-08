package com.example.activty3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainlayout =  new LinearLayout(this);
        mainlayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout tvetlayout = new LinearLayout(this);

        tvetlayout.setPadding(20,20,0,10);

        TextView tvOne = new TextView(this);
        tvOne.setText("Text View");
        tvOne.setTextSize(25);
        tvOne.setWidth(400);

        EditText etOne = new EditText(this);
        etOne.setHint("EditText");
        etOne.setTextSize(25);
        etOne.setWidth(1020);

        tvetlayout.addView(tvOne);
        tvetlayout.addView(etOne);
        tvetlayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout btn1layout = new LinearLayout(this);
        LinearLayout btn2layout = new LinearLayout(this);

        Button btOne = new Button(this);
        btOne.setText("BUTTON");
        btOne.setTextSize(20);
        btOne.setWidth(1050);

        ImageView igOne =  new ImageView(this);
        igOne.setImageResource(R.drawable.imgvw);
        igOne.setLayoutParams(new FrameLayout.LayoutParams(150,150));


        Button btTwo = new Button(this);
        btTwo.setText("ENABLE");
        btTwo.setTextSize(15);
        btTwo.setWidth(1050);

        btn1layout.addView(btOne);
        btn2layout.addView(btTwo);

        LinearLayout checklayout = new LinearLayout(this);
        checklayout.setOrientation(LinearLayout.VERTICAL);

        CheckBox chkbx1 = new CheckBox(this);
        chkbx1.setText("Checkbox1");
        chkbx1.setTextSize(20);

        CheckBox chkbx2 = new CheckBox(this);
        chkbx2.setText("Checkbox2");
        chkbx2.setTextSize(20);

        checklayout.addView(chkbx1);
        checklayout.addView(chkbx2);

        LinearLayout radiolayout = new LinearLayout(this);
        radiolayout.setOrientation(LinearLayout.VERTICAL);

        RadioButton radio1 = new RadioButton(this);
        RadioButton radio2 = new RadioButton(this);
        radio1.setText("RadioButton1");
        radio1.setTextSize(20);
        radio2.setText("RadioButton2");
        radio2.setTextSize(20);

        RadioGroup radioG = new RadioGroup(this);
        radioG.addView(radio1);
        radioG.addView(radio2);

        radiolayout.addView(radioG);

        LinearLayout datelayout = new LinearLayout(this);
        datelayout.setOrientation(LinearLayout.VERTICAL);

        EditText etDate = new EditText(this);
        etDate.setHint("Date");
        etDate.setTextSize(25);
        etDate.setWidth(1020);

        EditText etTime = new EditText(this);
        etTime.setHint("Time");
        etTime.setTextSize(25);
        etTime.setWidth(1020);

        datelayout.addView(etDate);
        datelayout.addView(etTime);

        mainlayout.addView(tvetlayout);
        mainlayout.addView(btn1layout);
        mainlayout.addView(igOne);
        mainlayout.addView(btn2layout);
        mainlayout.addView(checklayout);
        mainlayout.addView(radiolayout);
        mainlayout.addView(datelayout);

        LinearLayout xmllayout = (LinearLayout) findViewById(R.id.mainlayout);
        xmllayout.addView(mainlayout);

        etDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        etDate.setText(i1 + "/" + i2 + "/" +i);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        etTime.setText(i + ":" +i1);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);
                timePickerDialog.show();
            }
        });
    }
}