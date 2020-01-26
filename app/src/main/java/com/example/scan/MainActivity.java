package com.example.scan;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener{


    TextView Txt1,Txt2,Txt3,Txt4,Txt5;
    Switch aSwitch,bSwitch,cSwitch;
    Button b1,b2,b3,b4;
    int buttonState;
    int chk,chk1,chk2;
    int spin;
    Handler mHandler;
    ImageView firstImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk=0;
        chk1=0;
        chk2=0;
        spin=0;

        final Button b1= findViewById(R.id.button1);
        final Button b2= findViewById(R.id.button2);
        final Button b3= findViewById(R.id.button3);
        final Button b4= findViewById(R.id.button4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        buttonState = 0000;


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(buttonState  == 1000){
                    buttonState = 1000;
                    b1.setBackgroundColor(getResources().getColor(R.color.BLUE));
                    b2.setBackgroundColor(getResources().getColor(R.color.GREY));
                    b3.setBackgroundColor(getResources().getColor(R.color.GREY));
                    b4.setBackgroundColor(getResources().getColor(R.color.GREY));
                    //Toast.makeText(getBaseContext(), Integer.toString(buttonState), Toast.LENGTH_SHORT).show();
                //}
                //else{
                    //b1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    //Toast.makeText(getBaseContext(), "Button background color accent", Toast.LENGTH_SHORT).show();
                //}

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(buttonState  == 1000){
                buttonState = 0100;
                b2.setBackgroundColor(getResources().getColor(R.color.BLUE));
                b1.setBackgroundColor(getResources().getColor(R.color.GREY));
                b3.setBackgroundColor(getResources().getColor(R.color.GREY));
                b4.setBackgroundColor(getResources().getColor(R.color.GREY));
                //Toast.makeText(getBaseContext(), Integer.toString(buttonState), Toast.LENGTH_SHORT).show();
                //Toast.makeText(getBaseContext(), "Button background color green", Toast.LENGTH_SHORT).show();
                //}
                //else{
                //b1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                //Toast.makeText(getBaseContext(), "Button background color accent", Toast.LENGTH_SHORT).show();
                //}

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(buttonState  == 1000){
                buttonState = 0010;
                b3.setBackgroundColor(getResources().getColor(R.color.BLUE));
                b2.setBackgroundColor(getResources().getColor(R.color.GREY));
                b1.setBackgroundColor(getResources().getColor(R.color.GREY));
                b4.setBackgroundColor(getResources().getColor(R.color.GREY));
                //Toast.makeText(getBaseContext(), "Button background color green", Toast.LENGTH_SHORT).show();
                //}
                //else{
                //b1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                //Toast.makeText(getBaseContext(), "Button background color accent", Toast.LENGTH_SHORT).show();
                //}

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(buttonState  == 1000){
                buttonState = 0001;
                b4.setBackgroundColor(getResources().getColor(R.color.BLUE));
                b2.setBackgroundColor(getResources().getColor(R.color.GREY));
                b3.setBackgroundColor(getResources().getColor(R.color.GREY));
                b1.setBackgroundColor(getResources().getColor(R.color.GREY));
                //Toast.makeText(getBaseContext(), "Button background color green", Toast.LENGTH_SHORT).show();
                //}
                //else{
                //b1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                //Toast.makeText(getBaseContext(), "Button background color accent", Toast.LENGTH_SHORT).show();
                //}

            }
        });



        firstImage= findViewById(R.id.img1);

        //int imageResource = getResources().getIdentifier("@drawable/zebraqrcode_enable",null,this.getPackageName());
        //ohjmfirstImage.setImageResource(imageResource);



        Txt1= findViewById(R.id.Text1);
        Txt3= findViewById(R.id.Text3);
        Txt4= findViewById(R.id.Text4);
        Txt5= findViewById(R.id.Text5);
        Txt1.setText("SELECT THE TYPE OF SCANNER : ");

        Txt3.setText("Disabled ");

        Txt2= findViewById(R.id.Text2);
        Txt2.setText("Tap on any of the buttons to enable/disable the scanner ");
        Spinner aSpinner= findViewById(R.id.aSpinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.Spinner_items));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aSpinner.setAdapter(myAdapter);

        aSpinner.setOnItemSelectedListener(this);

        aSwitch = findViewById(R.id.switch1);
        bSwitch = findViewById(R.id.switch2);
        cSwitch = findViewById(R.id.switch3);

        //spin = (int) aSpinner.getSelectedItem();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked==true){
                    chk=1;
                    //Toast.makeText(getBaseContext(),Integer.toString(chk),Toast.LENGTH_SHORT).show();
                    Txt3.setText("Enabled ");
                }
                else
                {   chk=0;
                    //Toast.makeText(getBaseContext(),Integer.toString(chk),Toast.LENGTH_SHORT).show();
                    Txt3.setText("Disabled ");
                }
            }
        });

        bSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked==true){
                    chk1=1;
                    //Toast.makeText(getBaseContext(),Integer.toString(chk1),Toast.LENGTH_SHORT).show();
                    Txt4.setText("Enabled ");
                }
                else
                {   chk1=0;
                    //Toast.makeText(getBaseContext(),Integer.toString(chk1),Toast.LENGTH_SHORT).show();
                    Txt4.setText("Disabled ");
                }
            }
        });

        cSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked==true){
                    chk2=1;
                    //Toast.makeText(getBaseContext(),Integer.toString(chk2),Toast.LENGTH_SHORT).show();
                    Txt5.setText("Enabled ");
                }
                else
                {   chk2=0;
                    //Toast.makeText(getBaseContext(),Integer.toString(chk2),Toast.LENGTH_SHORT).show();
                    Txt5.setText("Disabled ");
                }
            }
        });


        aSwitch.setVisibility(View.INVISIBLE);
        Txt3.setVisibility(View.INVISIBLE);
        bSwitch.setVisibility(View.INVISIBLE);
        Txt4.setVisibility(View.INVISIBLE);
        cSwitch.setVisibility(View.INVISIBLE);
        Txt5.setVisibility(View.INVISIBLE);



        mHandler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {

                firstImage.setVisibility(View.VISIBLE);

                if(buttonState==0001)
                {
                    aSwitch.setVisibility(View.INVISIBLE);
                    Txt3.setVisibility(View.INVISIBLE);
                    bSwitch.setVisibility(View.INVISIBLE);
                    Txt4.setVisibility(View.INVISIBLE);
                    cSwitch.setVisibility(View.INVISIBLE);
                    Txt5.setVisibility(View.INVISIBLE);
                }
                else
                {
                    aSwitch.setVisibility(View.VISIBLE);
                    Txt3.setVisibility(View.VISIBLE);
                    bSwitch.setVisibility(View.VISIBLE);
                    Txt4.setVisibility(View.VISIBLE);
                    cSwitch.setVisibility(View.VISIBLE);
                    Txt5.setVisibility(View.VISIBLE);
                }


                if(buttonState==0010)
                {
                    aSwitch.setVisibility(View.INVISIBLE);
                    Txt3.setVisibility(View.INVISIBLE);
                    bSwitch.setVisibility(View.INVISIBLE);
                    Txt4.setVisibility(View.INVISIBLE);
                    cSwitch.setVisibility(View.VISIBLE);
                    Txt5.setVisibility(View.VISIBLE);
                }

                if(buttonState==0100)
                {
                    aSwitch.setVisibility(View.INVISIBLE);
                    Txt3.setVisibility(View.INVISIBLE);
                    bSwitch.setVisibility(View.VISIBLE);
                    Txt4.setVisibility(View.VISIBLE);
                    cSwitch.setVisibility(View.INVISIBLE);
                    Txt5.setVisibility(View.INVISIBLE);
                }

                if(buttonState==1000)
                {
                    aSwitch.setVisibility(View.VISIBLE);
                    Txt3.setVisibility(View.VISIBLE);
                    bSwitch.setVisibility(View.INVISIBLE);
                    Txt4.setVisibility(View.INVISIBLE);
                    cSwitch.setVisibility(View.INVISIBLE);
                    Txt5.setVisibility(View.INVISIBLE);
                }




                if(spin==3 && buttonState==0001)
                    firstImage.setImageResource(R.drawable.zebra_reset);

                if(spin==3 && buttonState==0010 && chk2==0)
                    firstImage.setImageResource(R.drawable.zebradatamatrix_disable);

                if(spin==3 && buttonState==0010 && chk2==1)
                    firstImage.setImageResource(R.drawable.zebradatamatrix_enable);

                if(spin==3 && buttonState==0100 && chk1==1)
                    firstImage.setImageResource(R.drawable.zebracode93_enable);

                if(spin==3 && buttonState==0100 && chk1==0)
                    firstImage.setImageResource(R.drawable.zebracode93_disable);

                if(spin==3 && buttonState==1000 && chk==1)
                    firstImage.setImageResource(R.drawable.zebrabarcode_enable);

                if(spin==3 && buttonState==1000 && chk==0)
                    firstImage.setImageResource(R.drawable.zebrabarcode_disable);


                if(spin==2 && buttonState==0001)
                    firstImage.setImageResource(R.drawable.herojew_reset);

                if(spin==2 && buttonState==0010 && chk2==0)
                    firstImage.setImageResource(R.drawable.herojewdm_disable);

                if(spin==2 && buttonState==0010 && chk2==1)
                    firstImage.setImageResource(R.drawable.herojewdm_enable);

                if(spin==2 && buttonState==0100 && chk1==1)
                    firstImage.setImageResource(R.drawable.herojewcode93_enable);

                if(spin==2 && buttonState==0100 && chk1==0)
                    firstImage.setImageResource(R.drawable.herojewcode93_disable);

                if(spin==2 && buttonState==1000 && chk==1)
                    firstImage.setImageResource(R.drawable.herojewbarcode_enable);

                if(spin==2 && buttonState==1000 && chk==0)
                    firstImage.setImageResource(R.drawable.herojewbarcode_disable);


                if(spin==1 && buttonState==0001)
                    firstImage.setImageResource(R.drawable.heroje_reset);

                if(spin==1 && buttonState==0010 && chk2==0)
                    firstImage.setImageResource(R.drawable.herojedm_disable);

                if(spin==1 && buttonState==0010 && chk2==1)
                    firstImage.setImageResource(R.drawable.herojedm_enable);

                if(spin==1 && buttonState==0100 && chk1==1)
                    firstImage.setImageResource(R.drawable.herojecode93_enable);

                if(spin==1 && buttonState==0100 && chk1==0)
                    firstImage.setImageResource(R.drawable.herojecode93_disable);

                if(spin==1 && buttonState==1000 && chk==1)
                    firstImage.setImageResource(R.drawable.herojebarcode_enable);

                if(spin==1 && buttonState==1000 && chk==0)
                    firstImage.setImageResource(R.drawable.herojebarcode_disable);

                if(spin==0)
                    firstImage.setVisibility(View.INVISIBLE);









                //Toast.makeText(getBaseContext(),"Handler",Toast.LENGTH_SHORT).show();
                mHandler.postDelayed(this, 200);
            }
        };

        mHandler.postDelayed(r, 200);




    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position==0)
            Toast.makeText(getBaseContext(), "Please select a scanner", Toast.LENGTH_LONG).show();
        else
        //Toast.makeText(getBaseContext(), "The scanner is " +
                //parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
        spin = position;
        //Toast.makeText(getBaseContext(),Integer.toString(spin),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(getBaseContext(), "Please select a scanner", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.button1:
                //chk=1000;
                //Toast.makeText(this,Integer.toString(chk), Toast.LENGTH_SHORT).show();
                //b1.setBackgroundColor(Integer.parseInt("#fffff"));
                //b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.custom_button));
                //b1.setBackgroundColor(getResources().getColor(R.color.BLUE));
                //b1.setBackgroundResource(R.color.BLUE);

                break;

            case R.id.button2:
                //chk=0100;
                //Toast.makeText(this,Integer.toString(chk), Toast.LENGTH_SHORT).show();
                //b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.custom_button));
                //b2.setBackgroundResource(R.color.BLUE);
                break;
            case R.id.button3:
                //chk=0010;
                //Toast.makeText(this,Integer.toString(chk), Toast.LENGTH_SHORT).show();
                //b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.custom_button));
                //b3.setBackgroundResource(R.color.BLUE);
                break;
            case R.id.button4:
                //chk=0001;
                //Toast.makeText(this,Integer.toString(chk), Toast.LENGTH_SHORT).show();
                //b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.custom_button));
                //b4.setBackgroundResource(R.color.BLUE);
                break;

        }

    }
}
