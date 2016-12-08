package com.bmob.im.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bmob.im.demo.util.PixelUtil;
import com.eson.cn.R;

/** 自定义头部布局
  * @ClassName: HeaderLayout
  * @Description: TODO
  * @author smile
  * @date 2014-5-19 下午2:30:30
  */
public class HeaderLayout extends LinearLayout {
	private LayoutInflater mInflater;
	private View mHeader;
	private LinearLayout mLayoutLeftContainer;
	private LinearLayout mLayoutRightContainer;
	private TextView mHtvSubTitle;
	private LinearLayout mLayoutRightImageButtonLayout;
	private Button mRightImageButton;
	private onRightImageButtonClickListener mRightImageButtonClickListener;

	private LinearLayout mLayoutLeftImageButtonLayout;
	private ImageButton mLeftImageButton;
	private onLeftImageButtonClickListener mLeftImageButtonClickListener;
	//头部整体样式
	public enum HeaderStyle {DEFAULT_TITLE, TITLE_LIFT_IMAGEBUTTON, TITLE_RIGHT_IMAGEBUTTON, TITLE_DOUBLE_IMAGEBUTTON;}

	public HeaderLayout(Context context) {
		super(context);
		init(context);
	}

	/**
	 * 构造器，获取上下文对象
	 * @param context
	 * @param attrs
     */
	public HeaderLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	/**
	 * 初始化事件
	 * @param context
     */
	public void init(Context context) {
		//获取LayoutInflater上下文对象
		mInflater = LayoutInflater.from(context);
		mHeader = mInflater.inflate(R.layout.common_header, null);
		//将ActionBar布局添加进view中
		addView(mHeader);
		//初始化布局
		initViews();
	}

	/**
	 * 初始化布局
	 */
	public void initViews() {
		//ActionBar左边布局
		mLayoutLeftContainer = (LinearLayout) findViewByHeaderId(R.id.header_layout_leftview_container);
		//ActionBar右边布局
		mLayoutRightContainer = (LinearLayout) findViewByHeaderId(R.id.header_layout_rightview_container);
		//ActionBar中间布局
		mHtvSubTitle = (TextView) findViewByHeaderId(R.id.header_htv_subtitle);

	}

	public View findViewByHeaderId(int id) {
		return mHeader.findViewById(id);
	}

	public void init(HeaderStyle hStyle) {
		switch (hStyle) {
		case DEFAULT_TITLE:
			defaultTitle();
			break;

		case TITLE_LIFT_IMAGEBUTTON:
			defaultTitle();
			titleLeftImageButton();
			break;

		case TITLE_RIGHT_IMAGEBUTTON:
			defaultTitle();
			titleRightImageButton();
			break;

		case TITLE_DOUBLE_IMAGEBUTTON:
			defaultTitle();
			titleLeftImageButton();
			titleRightImageButton();
			break;
		}
	}

	/**
	 * 	默认文字标题
	 */
	private void defaultTitle() {
		mLayoutLeftContainer.removeAllViews();
		mLayoutRightContainer.removeAllViews();
	}

	/**
	 * 左侧自定义按钮
	 */
	private void titleLeftImageButton() {
		//将布局注射到view中
		View mleftImageButtonView = mInflater.inflate(R.layout.common_header_button, null);

		mLayoutLeftContainer.addView(mleftImageButtonView);
		//通过view对象获取布局的id
		mLayoutLeftImageButtonLayout = (LinearLayout) mleftImageButtonView.findViewById(R.id.header_layout_imagebuttonlayout);
		//获取布局里ImageButton的id
		mLeftImageButton = (ImageButton) mleftImageButtonView.findViewById(R.id.header_ib_imagebutton);
		//设置布局为可点击
		mLayoutLeftImageButtonLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (mLeftImageButtonClickListener != null) {
					mLeftImageButtonClickListener.onClick();
				}
			}
		});
	}

	/**
	 * 右侧自定义按钮
	 */
	private void titleRightImageButton() {
		View mRightImageButtonView = mInflater.inflate(R.layout.common_header_rightbutton, null);
		mLayoutRightContainer.addView(mRightImageButtonView);
		mLayoutRightImageButtonLayout = (LinearLayout) mRightImageButtonView.findViewById(R.id.header_layout_imagebuttonlayout);
		mRightImageButton = (Button) mRightImageButtonView.findViewById(R.id.header_ib_imagebutton);
		mLayoutRightImageButtonLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (mRightImageButtonClickListener != null) {
					mRightImageButtonClickListener.onClick();
				}
			}
		});
	}

	/** 获取右边按钮
	  * @Title: getRightImageButton
	  * @Description: TODO
	  * @param @return 
	  * @return Button
	  * @throws
	  */
	public Button getRightImageButton(){
		if(mRightImageButton!=null){
			return mRightImageButton;
		}
		return null;
	}
	public void setDefaultTitle(CharSequence title) {
		if (title != null) {
			mHtvSubTitle.setText(title);
		} else {
			mHtvSubTitle.setVisibility(View.GONE);
		}
	}

	public void setTitleAndRightButton(CharSequence title, int backid,String text,
			onRightImageButtonClickListener onRightImageButtonClickListener) {
		setDefaultTitle(title);
		mLayoutRightContainer.setVisibility(View.VISIBLE);
		if (mRightImageButton != null && backid > 0) {
			mRightImageButton.setWidth(PixelUtil.dp2px(45));
			mRightImageButton.setHeight(PixelUtil.dp2px(40));
			mRightImageButton.setBackgroundResource(backid);
			mRightImageButton.setText(text);
			setOnRightImageButtonClickListener(onRightImageButtonClickListener);
		}
	}
	
	public void setTitleAndRightImageButton(CharSequence title, int backid,
			onRightImageButtonClickListener onRightImageButtonClickListener) {
		setDefaultTitle(title);
		mLayoutRightContainer.setVisibility(View.VISIBLE);
		if (mRightImageButton != null && backid > 0) {
			mRightImageButton.setWidth(PixelUtil.dp2px(30));
			mRightImageButton.setHeight(PixelUtil.dp2px(30));
			mRightImageButton.setTextColor(getResources().getColor(R.color.transparent));
			mRightImageButton.setBackgroundResource(backid);
			setOnRightImageButtonClickListener(onRightImageButtonClickListener);
		}
	}

	public void setTitleAndLeftImageButton(CharSequence title, int id,
			onLeftImageButtonClickListener listener) {
		setDefaultTitle(title);
		if (mLeftImageButton != null && id > 0) {
			mLeftImageButton.setImageResource(id);
			setOnLeftImageButtonClickListener(listener);
		}
		mLayoutRightContainer.setVisibility(View.INVISIBLE);
	}

	public void setOnRightImageButtonClickListener(
			onRightImageButtonClickListener listener) {
		mRightImageButtonClickListener = listener;
	}

	public interface onRightImageButtonClickListener {
		void onClick();
	}

	public void setOnLeftImageButtonClickListener(
			onLeftImageButtonClickListener listener) {
		mLeftImageButtonClickListener = listener;
	}

	public interface onLeftImageButtonClickListener {
		void onClick();
	}

}
