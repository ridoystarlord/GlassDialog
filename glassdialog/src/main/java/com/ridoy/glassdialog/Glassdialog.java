package com.ridoy.glassdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;

public class Glassdialog extends Dialog implements View.OnClickListener {

    public Button confirmBtn, cancelBtn;
    Glasslisner confirmListener;
    Glasslisner cancelListener;
    String confirmButtonText, cancelButtonText, titleText, messageText;
    LottieAnimationView animationView;
    TextView titleTV, messageTV;
    int alertType;
    String customLottie;
    boolean isCancelButtonShow=false;


    public static final int ERROR_TYPE = 1;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    public static final int INFO_TYPE = 4;
    public static final int CUSTOM_TYPE = 5;

    public static interface Glasslisner {
        public void onClick(Glassdialog dialog);
    }

    public Glassdialog(@NonNull Context context) {
        super(context);
    }

    public Glassdialog(@NonNull Context context, int type) {
        super(context, R.style.alert_dialog);
        alertType=type;
    }
    public Glassdialog(@NonNull Context context, int type, String customFile) {
        super(context, R.style.alert_dialog);
        alertType = type;
        customLottie = customFile;
    }

    protected Glassdialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public Glassdialog setConfirmClickListener(Glasslisner listener) {
        confirmListener = listener;
        return this;
    }

    public Glassdialog setCancelClickListener(Glasslisner listener) {
        cancelListener = listener;
        return this;
    }


    public Glassdialog setConfirmButtonText(String text) {
        confirmButtonText = text;

        if (confirmBtn != null && confirmButtonText != null) {
            confirmBtn.setText(confirmButtonText);
        }
        return this;
    }

    public Glassdialog setCancelButtonText(String text) {
        cancelButtonText = text;
        if (cancelBtn != null && cancelButtonText != null) {
            cancelBtn.setText(cancelButtonText);
            showCancelButton(true);
        }
        return this;
    }

    public Glassdialog setTitle(String text) {
        titleText = text;

        if (titleTV != null && titleText != null) {
            titleTV.setText(titleText);
        }
        return this;
    }
    public Glassdialog showCancelButton(boolean isShow) {
        isCancelButtonShow=isShow;

        if (cancelBtn != null) {
            cancelBtn.setVisibility(isCancelButtonShow ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public Glassdialog setMessage(String text) {
        messageText = text;

        if (messageTV != null && messageText != null) {
            messageTV.setText(messageText);

        }
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glass_dialog);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        animationView = findViewById(R.id.animation_view);
        if (alertType == SUCCESS_TYPE) {
            animationView.setAnimation(R.raw.success);
        } else if (alertType == ERROR_TYPE) {
            animationView.setAnimation(R.raw.error);
        } else if (alertType == INFO_TYPE) {
            animationView.setAnimation(R.raw.info);
        } else if (alertType == WARNING_TYPE) {
            animationView.setAnimation(R.raw.warning);
        } else if (alertType == CUSTOM_TYPE) {
            animationView.setAnimation(customLottie);
        }

        confirmBtn = findViewById(R.id.positiveBtn);
        cancelBtn = findViewById(R.id.cancelBtn);
        titleTV = findViewById(R.id.title_TV);
        messageTV = findViewById(R.id.message_TV);

        confirmBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        setConfirmButtonText(confirmButtonText);
        setCancelButtonText(cancelButtonText);
        setTitle(titleText);
        setMessage(messageText);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.positiveBtn) {
            confirmListener.onClick(Glassdialog.this);
        }
        if (view.getId() == R.id.cancelBtn) {
            cancelListener.onClick(Glassdialog.this);
        }
    }
}
