package com.bobaemw.drawingcanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by BMW on 2017-01-31.
 */

public class CanvasView extends View {
    public final static int CURRENT_CANVAS = 0;
    public final static int NEW_CANVAS = 1;

    private Context _mContext;
    ArrayList<Dot>  _dots = new ArrayList<Dot>();

    private Paint _paint;

    public CanvasView(Context context){
        super(context);
        initPaint(CanvasView.CURRENT_CANVAS);
    }

    public CanvasView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        initPaint(CanvasView.CURRENT_CANVAS);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        initPaint(CanvasView.CURRENT_CANVAS);
    }
    public void setmContext(Context mContext){
        this._mContext=mContext;
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        for(int i=0; i < _dots.size();i++){
            if(_dots.get(i).isB()){
                canvas.drawLine(_dots.get(i-1).getX(), _dots.get(i-1).getY(),
                        _dots.get(i).getX(),_dots.get(i).getY(),_paint);
            }
        }
    }

    public void initPaint(int i){
        _dots.clear();
        _paint = null;
        _paint = new Paint();
        _paint.setColor(Color.GREEN);
        _paint.setStrokeWidth(2);
        _paint.setAntiAlias(true);

        if(i == CanvasView.NEW_CANVAS) invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            _dots.add(new Dot(event.getX(), event.getY(), false));
            return true;
        }

        if(event.getAction() == MotionEvent.ACTION_MOVE){
            _dots.add(new Dot(event.getX(), event.getY(), true));
            invalidate();
            return true;
        }
        return false;
    }


}
