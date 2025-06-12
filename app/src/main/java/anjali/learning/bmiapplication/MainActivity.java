package anjali.learning.bmiapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button calculatebmi;
    TextView resultText;
    EditText heightInput,weightInput;
    RelativeLayout relativelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatebmi=findViewById(R.id.calculatebtn);
        resultText=findViewById(R.id.resultText);
        heightInput=findViewById(R.id.heightinput);
        weightInput=findViewById(R.id.weightinput);
        relativelayout=findViewById(R.id.relativelayout);

        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String HeightInput=heightInput.getText().toString();
                String WeightInput=weightInput.getText().toString();
                if(HeightInput.isEmpty()){
                    heightInput.setError("Please Enter Your Height");

                }else if(WeightInput.isEmpty()){
                    weightInput.setError("Please Enter Your Weight");
                }
                float heightCMFloat=Float.parseFloat(HeightInput);
                float weightKGFloat=Float.parseFloat(WeightInput);
                float height=heightCMFloat/100; //to convert centimeter into meter
                float bmi=weightKGFloat/(height*height);
                String weightstatus;
                if(bmi<18.5){
                    weightstatus="UnderWeight";
                    relativelayout.setBackgroundColor(Color.parseColor("#70B9E6"));
                }else if(bmi<25){
                    weightstatus="Perfect ";
                    relativelayout.setBackgroundColor(Color.parseColor("#70E6BB"));

                }else{
                    weightstatus="OverWeight";
                    relativelayout.setBackgroundColor(Color.parseColor("#edbc0c"));
                }
                resultText.setText("Your BMI is "+bmi+"\n"+"You Are "+weightstatus );

            }
        });

    }
}