package com.example.farmassist1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class weather extends AppCompatActivity {

    TextView temp;
    Button reload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        reload=findViewById(R.id.button3);
        temp=findViewById(R.id.textView9);
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    new fetchweather().execute();
                }
                catch (Exception e){

                }

            }
        });
    }



    class fetchweather extends AsyncTask<Void, Void, String> {
        protected String doInBackground(Void... urls) {
            try {
                URL url = new URL("https://api.openweathermap.org/data/2.5/weather?id=1259425&appid=276b88b1d83c03ff6925d1bb8c8dffee");
                System.out.println(url);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    // StringBuilder stringBuilder = new StringBuilder();

                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

                    StringBuilder stringBuilder = new StringBuilder();

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {

                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            System.out.println(response);
//            if(response == null) {
//                Toast.makeText(Main2Activity.this, "There was an error", Toast.LENGTH_SHORT).show();
//                return;
//            }
            try {
//                JSONObject channel = (JSONObject) new JSONTokener(response).nextValue();
//                JSONObject channel1= (JSONObject) new JSONTokener()
//                double v1 = channel.getDouble(temp_field1);
//                System.out.println(v1);
//                String val1=new Double(v1).toString();
//                System.out.println(val1);
//
//                temp.setText(val1);

                JSONObject jo1=new JSONObject(response);
                JSONObject jotemp=jo1.getJSONObject("main");

                String t=jotemp.getString("temp");
                Float ftemp=Float.parseFloat(t);
                double dtemp=ftemp-273.15;
                System.out.println(" Received Temperature "+dtemp);

                temp.setText("Temperature "+dtemp+"C" );



//                if(v1>=90)
//                    t1.setText("HI ALL  ");
//               // else
////                    t1.setText("NO VALUES");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
