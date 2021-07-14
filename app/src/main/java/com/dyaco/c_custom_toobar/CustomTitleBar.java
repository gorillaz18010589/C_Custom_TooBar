package com.dyaco.c_custom_toobar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomTitleBar extends ConstraintLayout {
    private LinearLayout linLeftLayout, linRightLayout;
    private ImageView imgLeft, imgRight;
    private TextView tvLeft, tvRight;
    private TextView tvTitle;
    private View view;


    public CustomTitleBar(@NonNull Context context) {
        super(context);
    }

    public CustomTitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTitleBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomTitleBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        //1.initLayout
        view =  LayoutInflater.from(context).inflate(R.layout.custom_title_bar_layout, this,true);


        //2.findVieById
        initView(view);

        //3.init obtainStyledAttributes
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);//取得在屬性設置的屬性陣列
        int count = typedArray.getIndexCount(); //取得設定的屬性總數
        for (int i = 0; i < count; i++) {
            int attr = typedArray.getIndex(i); //取得屬性(int index)
            switch (attr) {
                case R.styleable.CustomTitleBar_leftTextColor:
                    setLeftTextColor(typedArray.getColor(attr, Color.BLACK)); //設定左邊文字顏色(1.你設定的屬性,2.預設屬性)
                    break;
                case R.styleable.CustomTitleBar_leftDrawable:
                    this.imgLeft.setImageResource(typedArray.getResourceId(attr, 0));
                    break;
                case R.styleable.CustomTitleBar_leftText:
                    this.tvLeft.setText(typedArray.getString(attr));
                    break;

            }
        }

        //4.TypedArray.recycle()
        typedArray.recycle();

//        setLeftTextColor()
    }

    private void initView(View view) {
        this.linLeftLayout = view.findViewById(R.id.linLeftLayout);
        this.linRightLayout = view.findViewById(R.id.linRightLayout);
        this.imgLeft = view.findViewById(R.id.imgLeft);
        this. imgRight = view.findViewById(R.id.imgRight);
        this. tvLeft = view.findViewById(R.id.tvLeft);
        this. tvRight = view.findViewById(R.id.tvRight);
        this.tvTitle = view.findViewById(R.id.tvTitle);
    }

    private void setImgLeft(int res){
        imgLeft.setImageResource(res);
    }


    public void setLeftTextColor(int color){
        tvLeft.setTextColor(color);
    }
}
