package com.example.temporary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Height ,Weight ,Heightinch;
    Button  Submit ;
    ImageView BMI_image ;
    TextView Result ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Height = findViewById(R.id.Height);
        Weight = findViewById(R.id.Weight);
        Heightinch = findViewById(R.id.Heightinch);
        Submit = findViewById(R.id.Submit);
        BMI_image = findViewById(R.id.BMI_image);
        Result = findViewById(R.id.Result);
        Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   int inch ;

                    if(Heightinch.getText().toString().equals(""))
                    {
                        inch = 0;
                    }
                    else
                    {
                        inch = Integer.parseInt(Heightinch.getText().toString());
                    }
                    if(Height.getText().toString().equals("") || Weight.getText().toString().equals(""))
                    {
                        BMI_image.setImageResource(R.drawable.bmi);
                        if(Weight.getText().toString().equals("")&&Height.getText().toString().equals(""))
                        {
                            Result.setText("Enter some height and weight");
                        }
                        else if(Height.getText().toString().equals(""))
                        {
                            Result.setText("Enter some height");

                        }
                        else
                        {
                            Result.setText("Enter some Weight");

                        }
                    }
                    else
                    {
                        int ht = Integer.parseInt(Height.getText().toString()) ;
                        int wt = Integer.parseInt(Weight.getText().toString());
                        int heightInInches = ht*12 + inch;
                        if((heightInInches>108 || heightInInches<36) || (wt >650 || wt<10))
                        {
                            Result.setText("Invalid Input");
                            BMI_image.setImageResource(R.drawable.bmi);
                        }
                        else {
                            double total_M = (heightInInches * 2.53) / 100;
                            double BMI = wt / (total_M * total_M);
                            if (BMI <= 18.5) {
                                Result.setText("You are Underweight");
                                BMI_image.setImageResource(R.drawable.underweight);
                            } else if (BMI <= 24.9) {
                                Result.setText("You are Healthy and fit");
                                BMI_image.setImageResource(R.drawable.healthy);
                            } else if (BMI == 25) {
                                Result.setText("You are Overweighted");
                            } else if (BMI <= 29.9) {
                                Result.setText("You are in Obesity-I");
                                BMI_image.setImageResource(R.drawable.obesity1);
                            } else if (BMI <= 40) {
                                Result.setText(("Your are in Obesity-II"));
                                BMI_image.setImageResource(R.drawable.obesity2);
                            } else {
                                Result.setText("You are in Obesity-III");
                                BMI_image.setImageResource(R.drawable.obesity3);
                            }
                        }
                   }
                }
            });
        };
    }