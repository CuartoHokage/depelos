package com.example.depelos;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicio de la clase VideoView asociandole el fichero de Video
        video=findViewById(R.id.VideoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.opening;
        video.setVideoURI(Uri.parse(path));

        //Obtenemos los tres botones de la interfaz
        btnPlay= findViewById(R.id.buttonPlay);
        btnStop= findViewById(R.id.buttonStop);
        btnPause=findViewById(R.id.buttonPause);

        //Y les asignamos el controlador de eventos
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPause.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        switch(v.getId()){
            case R.id.buttonPlay:
                //Iniciamos el video
                video.start();
                break;
            case R.id.buttonPause:
                //Pausamos el video
                video.pause();
                break;
            case R.id.buttonStop:
                //Paramos el video y volvemos a inicializar

                video.stopPlayback();
                video.seekTo(0);
                break;
        }
    }
}
