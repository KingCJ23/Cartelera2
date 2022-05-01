package com.example.cartelera2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

public class peli_uno extends AppCompatActivity {
    private TextView texto;
    private Button bntSinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peli_uno);
        this.bntSinopsis = findViewById(R.id.btnSinopsis);

        bntSinopsis.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                try {
                    mostrarPopUp(view,
                    "The Amazing Spider-Man es la historia " +
                            "de Peter Parker (Garfield), un chico de instituto " +
                            "algo marginado que fue abandonado por sus padres cuando era niño, " +
                            "por lo que le criaron su Tío Ben (Sheen) y su Tía May (Field). " +
                            "Como muchos adolescentes, " +
                            "Peter quiere averiguar quién es y cómo llegó a ser la persona que " +
                            "es en la actualidad.")
                    ;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });




    }
    /**
     * Metodo que crea el popUp
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void mostrarPopUp(View view, String titulo){
        try{
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup_window, null);
            PopupWindow pw = new PopupWindow(popupView, 1200, 1800, true);
            ((TextView)pw.getContentView().findViewById(R.id.lblSinopsis)).setText(titulo);
            pw.setElevation(40);
            pw.showAtLocation(view, Gravity.CENTER, 0, 0);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}