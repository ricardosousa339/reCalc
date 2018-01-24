package com.ccomp.ricardo.recalc;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String expressao;
    static StringBuilder strBuilder = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

       /*
        Button igual = (Button) findViewById(R.id.buttonIgual);
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.sound);
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {

                        mp.release();
                    }

                });
                mp.start();


            }
        });
*/


    }

    public void onClick(View v){



        switch(v.getId()){
            case R.id.buttonAdicao :{
                strBuilder.append("+");

                break;
            }
            case R.id.buttonDivisao:{
                strBuilder.append("÷");
                break;
            }
            case R.id.buttonMultiplicacao:{
                strBuilder.append("×");
                break;
            }
            case R.id.buttonSubtracao:{
                strBuilder.append("–");
                break;
            }
            case R.id.buttonUm:{
                strBuilder.append("1");
                break;
            }
            case R.id.buttonDois:{
                strBuilder.append("2");
                break;
            }
            case R.id.buttonTres:{
                strBuilder.append("3");
                break;
            }
            case R.id.buttonQuatro:{
                strBuilder.append("4");
                break;
            }
            case R.id.buttonCinco:{
                strBuilder.append("5");
                break;
            }
            case R.id.buttonSeis:{
                strBuilder.append("6");
                break;
            }
            case R.id.buttonSete:{
                strBuilder.append("7");
                break;
            }
            case R.id.buttonOito:{
                strBuilder.append("8");
                break;
            }
            case R.id.buttonNove:{
                strBuilder.append("9");
                break;
            }
            case R.id.buttonZero:{
                strBuilder.append("0");
                break;
            }
            case R.id.buttonClean:{
                strBuilder.delete(0,strBuilder.length());
                break;
            }
            case R.id.buttonDel:{
                strBuilder.deleteCharAt(strBuilder.length());
                break;
            }
            case R.id.buttonMaisMenos:{

                break;
            }
            case R.id.buttonPonto:{
                strBuilder.append(".");
                break;
            }
            case R.id.buttonPorcentagem: {

                break;
            }
            case R.id.buttonIgual:{

                String s = strBuilder.toString();

                float resultado = eval(s);

                strBuilder.replace(0,strBuilder.length(),resultado+"");

                s = strBuilder.toString();

                s.replace(".0", "");

                strBuilder.replace(0,strBuilder.length(),s);
                break;
            }
        }

        final TextView visor = (TextView) findViewById(R.id.visor);

        visor.setText(strBuilder.toString());

        HorizontalScrollView scrVisor = (HorizontalScrollView)findViewById(R.id.scrollViewvisor);

        scrVisor.scrollBy(visor.getWidth(),visor.getWidth());


    }


    public float eval(String expr) {

        if(expr.equals("")){
            return 0;
        }
        float resultado = 0;

        int indiceOperador = expr.indexOf("+");
        int indiceOperador1 = expr.indexOf("–");
        int indiceOperador2 = expr.indexOf("×");
        int indiceOperador3 = expr.indexOf("÷");
        if(indiceOperador == -1 && indiceOperador1 == -1 && indiceOperador2 == -1 && indiceOperador3 == -1 ) {
            resultado = Float.parseFloat(expr);
        } else {
            if(indiceOperador2 != -1) {
                resultado = eval(expr.substring(0, indiceOperador2)) * eval(expr.substring(indiceOperador2 + 1, expr.length()));
            }
            if(indiceOperador3 != -1) {
                resultado = eval(expr.substring(0, indiceOperador3)) / eval(expr.substring(indiceOperador3 + 1, expr.length()));
            }
            if(indiceOperador != -1) {
                resultado = eval(expr.substring(0, indiceOperador)) + eval(expr.substring(indiceOperador + 1, expr.length()));
            }
            if(indiceOperador1 != -1) {
                resultado = eval(expr.substring(0, indiceOperador1)) - eval(expr.substring(indiceOperador1 + 1, expr.length()));
            }
        }

        return resultado;
    }




}
