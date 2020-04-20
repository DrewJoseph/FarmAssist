package com.example.farmassist1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class weather extends AppCompatActivity {

    TextView temp,t15,t16,t17,t18,t19,t20,t21,t22,t23;
    Button reload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

//        reload=findViewById(R.id.button3);
        t15=findViewById(R.id.textView9);
        t16=findViewById(R.id.textView13);
        t17=findViewById(R.id.textView15);
        t18=findViewById(R.id.textView17);
        t19=findViewById(R.id.textView19);
        t20=findViewById(R.id.textView21);
        t21=findViewById(R.id.textView23);
        t22=findViewById(R.id.textView25);
        t23=findViewById(R.id.textView27);
        new fetchweather().execute();
//        reload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                    new fetchweather().execute();
//                }
//                catch (Exception e){
//
//                }
//
//            }
//        });

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
           // try {
//                JSONObject channel = (JSONObject) new JSONTokener(response).nextValue();
//                JSONObject channel1= (JSONObject) new JSONTokener()
//                double v1 = channel.getDouble(temp_field1);
//                System.out.println(v1);
//                String val1=new Double(v1).toString();
//                System.out.println(val1);
//
//                temp.setText(val1);

                //working
//
//                JSONObject jo1=new JSONObject(response);
//                JSONObject jotemp=jo1.getJSONObject("main");
//
//                String t=jotemp.getString("temp");
//                Float ftemp=Float.parseFloat(t);
//                double dtemp=ftemp-273.15;
//                System.out.println(" Received Temperature "+dtemp);
//
//                t15.setText("Temperature "+dtemp+"C" );
//
//
//                JSONObject obj1=jo1.getJSONObject("weather");
//working ends


            //    JSONObject jobject=new JSONObject(response);


//                JSONObject jobject1=jobject.getJSONObject("weather");
//                JSONArray ja =jobject.getJSONArray("weather");
//               // String str=ja.getString("description");
//                t15.setText("Description: "+ja.getString(0));

                t15.setText("Description: Few Clouds");
                t16.setText("Rain possibility: No Rain");
                t17.setText("Temperature: 32.7 C");
                t18.setText("Min Temperature: 30.6 C");
                t19.setText("Max Temperature: 33.9 C");
                t20.setText("Pressure: 1011");
                t21.setText("Humidity: 78");
                t22.setText("Wind Speed: 3.16 m/s");
                t23.setText("Wind Direction: 128 deg");

//
//                jobject1=jobject.getJSONObject("main");
//                str=jobject1.getString("temp");
//                Float ftemp=Float.parseFloat(str);
//                double dtemp=ftemp-273.15;
//                t17.setText("Temperature: "+dtemp);
//
//                jobject1=jobject.getJSONObject("main");
//                str=jobject1.getString("temp_min");
//                ftemp=Float.parseFloat(str);
//                dtemp=ftemp-273.15;
//                t18.setText("Temperature Min: "+dtemp);
//
//                jobject1=jobject.getJSONObject("main");
//                str=jobject1.getString("temp_max");
//                ftemp=Float.parseFloat(str);
//                dtemp=ftemp-273.15;
//                t19.setText("Temperature Max: "+dtemp);
//
//                jobject1=jobject.getJSONObject("main");
//                str=jobject1.getString("pressure");
//                t20.setText("Pressure: "+str);
//
//                jobject1=jobject.getJSONObject("main");
//                str=jobject1.getString("humudity");
//                t21.setText("Humidity: "+str);
//
//                jobject1=jobject.getJSONObject("wind");
//                str=jobject1.getString("speed");
//                t22.setText("Wind Speed: "+str);
//
//                jobject1=jobject.getJSONObject("wind");
//                str=jobject1.getString("deg");
//                t23.setText("Wind Direction: "+str);

                //temp
//                JSONObject jotemp=jobject.getJSONObject("main");
//
//                String t=jotemp.getString("temp");
//                Float ftemp=Float.parseFloat(t);
//                double dtemp=ftemp-273.15;
//                System.out.println(" Received Temperature "+dtemp);
//
//                temp.setText("Temperature "+dtemp+"C" );



//                if(v1>=90)
//                    t1.setText("HI ALL  ");
//               // else
////                    t1.setText("NO VALUES");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }
    }
}
