package com.example.multi.diferente;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    Button curso;
    Button formu;
    Button evento;
    ImageView img;

    boolean isImageFitToScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            siguiente =(Button) findViewById(R.id.button);

            siguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, Politicas.class);
                    startActivity(i);


                }
            });

        curso = (Button) findViewById(R.id.button3);
        curso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(MainActivity.this, Cursos.class);
                startActivity(g);
            }
        });

        formu = (Button) findViewById(R.id.button4);
        formu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h = new Intent(MainActivity.this, Formulario.class);
                startActivity(h);
            }
        });

        evento = (Button) findViewById(R.id.button5);
        evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this, Eventos.class);
                startActivity(j);
            }
        });


        //para que imagen se muestre

        img = (ImageView) findViewById(R.id.imageView2);

           img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isImageFitToScreen) {
                        isImageFitToScreen = false;
                        img.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                        img.setAdjustViewBounds(true);

                    }else{
                        isImageFitToScreen=true;
                        img.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
                        img.setScaleType(ImageView.ScaleType.FIT_XY);
                        siguiente.setVisibility(View.INVISIBLE);
                        curso.setVisibility(View.INVISIBLE);
                        formu.setVisibility(View.INVISIBLE);
                        evento.setVisibility(View.INVISIBLE);




                    }



                    img = (ImageView) findViewById(R.id.imageView2);
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent ima = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(ima);

                        }
                    });


                }

            });




    }
}
