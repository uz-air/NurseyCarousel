package com.ankur.nursery;

import android.text.Layout;
import android.util.Log;
import android.view.View;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Column;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.Text;
import com.facebook.litho.widget.TextChangedEvent;
import com.facebook.litho.widget.TextInput;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaJustify;

import kotlin.jvm.JvmStatic;

@LayoutSpec
class LoadingSpec {

    @OnCreateInitialState
    static void onCreateInitialState(ComponentContext c
    ) {
        //TODO: remove this method if not needed. Set an initial value for a state https://fblitho.com/docs/state
    }

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c
    ) {
        // TODO: describe your UI with existing components https://fblitho.com/docs/layout-specs
        TextInput textInput = TextInput.create(c).build();
        return Column.create(c).alignContent(YogaAlign.CENTER)
                .justifyContent(YogaJustify.CENTER)
                .child(Text
                        .create(c)
                        .textRes(R.string.loading)
                        .textSizeSp(20)
                        .textAlignment(Layout.Alignment.ALIGN_CENTER))
                .child(textInput)
                .build();
    }


}