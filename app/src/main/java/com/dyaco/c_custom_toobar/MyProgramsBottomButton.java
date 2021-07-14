package com.dyaco.c_custom_toobar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MyProgramsBottomButton extends ConstraintLayout {

    private TextView mContent;
    private ImageView mIvLeft;

    public MyProgramsBottomButton(Context context) {
        this(context, null);
    }

    public MyProgramsBottomButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyProgramsBottomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyProgramsBottomButton);
        //从布局文件中获取到设置内容
        int ivLeft = typedArray.getResourceId(R.styleable.MyProgramsBottomButton_iv_left, R.drawable.ic_baseline_arrow_back_24);
        String name = typedArray.getString(R.styleable.MyProgramsBottomButton_name);
        //回收
        typedArray.recycle();

        LayoutInflater.from(context).inflate(R.layout.view_myitem, this);
        //获取控件ID
        mIvLeft = (ImageView) findViewById(R.id.iv_left);
        mContent = (TextView) findViewById(R.id.name);

        //设置获取到的内容
        mIvLeft.setImageResource(ivLeft);
        mContent.setText(name);
    }

    /**
     * 设置左边图片
     */
    public void setLeftIcon(int resourceId) {
        mIvLeft.setImageResource(resourceId);
    }

    /**
     * 设置内容
     */
    public void setContent(String name) {
        mContent.setText(name);
    }
}





//public class MyProgramsBottomButton extends ConstraintLayout {
//
//    private TextView mContent;
//    private ImageView mIvLeft;
//
//    public MyProgramsBottomButton(Context context) {
//        this(context, null);
//    }
//
//    public MyProgramsBottomButton(Context context, AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public MyProgramsBottomButton(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        initView(context, attrs);
//    }
//
//    private void initView(Context context, AttributeSet attrs) {
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyProgramsBottomButton);
//        //从布局文件中获取到设置内容
//        int ivLeft = typedArray.getResourceId(R.styleable.MyProgramsBottomButton_iv_left, R.drawable.ic_baseline_arrow_back_24);
//        String name = typedArray.getString(R.styleable.MyProgramsBottomButton_name);
//        //回收
//        typedArray.recycle();
//
//        LayoutInflater.from(context).inflate(R.layout.view_myitem, this);
//        //获取控件ID
//        mIvLeft = (ImageView) findViewById(R.id.iv_left);
//        mContent = (TextView) findViewById(R.id.name);
//
//        //设置获取到的内容
//        mIvLeft.setImageResource(ivLeft);
//        mContent.setText(name);
//    }
//
//    /**
//     * 设置左边图片
//     */
//    public void setLeftIcon(int resourceId) {
//        mIvLeft.setImageResource(resourceId);
//    }
//
//    /**
//     * 设置内容
//     */
//    public void setContent(String name) {
//        mContent.setText(name);
//    }
//}
//
//
