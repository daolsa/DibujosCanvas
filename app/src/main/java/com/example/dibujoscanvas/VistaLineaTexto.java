package com.example.dibujoscanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class VistaLineaTexto extends View {

    Paint pincel;
    Paint pincelTexto;

    public VistaLineaTexto(Context context) {
        super(context);
        inicializarPincel();
        inicializarPincelTexto();
    }

    public void inicializarPincel(){
        // Definimos el pincel
        pincel = new Paint();
        pincel.setStyle(Paint.Style.FILL_AND_STROKE);
        pincel.setColor(Color.CYAN); // color por defecto
        pincel.setStrokeWidth(40f);
        pincel.setAntiAlias(true);
    }

    public void inicializarPincelTexto(){
        // Definimos el pincel
        pincelTexto = new Paint();
        pincelTexto.setStyle(Paint.Style.FILL_AND_STROKE);
        pincelTexto.setColor(Color.WHITE); // color por defecto
        pincelTexto.setAntiAlias(true);
        pincelTexto.setStrokeWidth(20f);
        pincelTexto.setTextSize(50f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        canvas.drawRect(getLeft()+100, getTop()+100,getRight()-100,getBottom()-100,pincel);
        pincel.setColor(Color.argb(0.8f,0.9f,0f,0.2f));
        canvas.drawRect(getLeft()+250, getTop()+250,getRight()-250,getBottom()-250,pincel);
        // Lo podemos hacer así o en un Path
        //canvas.drawText("Texto de prueba",getLeft()+280f,getTop()+290f,pincelTexto);
        Path trazo = new Path();
        trazo.moveTo(getLeft()+280f,getTop()+290f);
        trazo.lineTo(getRight()-280f,getBottom()-290f);
        canvas.drawPath(trazo,pincelTexto);
        pincelTexto.setStrokeWidth(1f);
        canvas.drawTextOnPath("Programación Móvil FESAC",trazo,0,-25f,pincelTexto);

    }
}
