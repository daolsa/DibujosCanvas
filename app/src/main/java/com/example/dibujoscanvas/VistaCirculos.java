package com.example.dibujoscanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class VistaCirculos extends View {

    Paint pincel;

    public VistaCirculos(Context context) {
        super(context);
        inicializarPincel();

    }
    public void inicializarPincel(){
        // Definimos el pincel
        pincel = new Paint();
        pincel.setStyle(Paint.Style.STROKE);
        pincel.setStrokeWidth(40f);
        pincel.setAntiAlias(true);
        pincel.setColor(Color.CYAN); // Color por defecto
    }

    // Ejemplo para dibujar 8 círculos de diferentes colores y tamaños

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);

        for(int i = 100; i<=800;i+=100){
            pincel.setColor(Color.argb(1f,i/800f,i/800f,(800-i)/800f));
            canvas.drawCircle(getWidth()/2f,getHeight()/2f,i,pincel);
        }
    }
}
