package com.example.multi.diferente;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import objetos.Referencias;
import objetos.links;

public class Politicas extends AppCompatActivity {

    ListView listview;
    ArrayList<links> list=new ArrayList<links>();
    ArrayAdapter<links> adapter;

    ImageView image;

    boolean isImageFitToScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politicas);
        FirebaseDatabase baseDatos = FirebaseDatabase.getInstance();
        DatabaseReference myRef = baseDatos.getReference(Referencias.POLITICA_REFERENCE);

        listview = (ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<links>(this,android.R.layout.simple_dropdown_item_1line,list);
        listview.setAdapter(adapter);

        /*links a = new links("https://www.facebook.com/","Facebook");
        list.add(a);
        a = new links("https://www.google.com","Google");
        list.add(a);
        a = new links("https://www.youtube.com", "youtube");
        list.add(a);*/


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                links valor = dataSnapshot.getValue(links.class);
                list.add(valor);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                links valor = dataSnapshot.getValue(links.class);
                list.remove(valor);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = adapter.getItem(i).ruta;
                Uri web = Uri.parse(url);
                Intent xx = new Intent(Intent.ACTION_VIEW,web);
                try {
                    startActivity(xx);
                    Toast.makeText(getApplicationContext(),"Cargando Link...",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Ups Link roto!", Toast.LENGTH_SHORT).show();
                };



            }
        });

        //para que imagen se muestre

        image = (ImageView) findViewById(R.id.imageView14);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isImageFitToScreen) {
                    isImageFitToScreen = false;
                    image.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                    image.setAdjustViewBounds(true);

                }else{
                    isImageFitToScreen=true;
                    image.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
                    image.setScaleType(ImageView.ScaleType.FIT_XY);

                }


                image = (ImageView) findViewById(R.id.imageView14);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent ima = new Intent(Politicas.this,Politicas.class);
                        startActivity(ima);

                    }
                });


            }

        });


    }
}
