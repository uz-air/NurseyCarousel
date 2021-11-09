package com.ankur.nursery;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Column;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;
import com.github.pavlospt.litho.glide.GlideImage;

@LayoutSpec
class PlantRowCardSpec {

    @OnCreateInitialState
    static void onCreateInitialState(ComponentContext c
    ) {
        // TODO: remove this method if not needed. Set an initial value for a state https://fblitho.com/docs/state
    }

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c,
                                    @Prop ApiResponse.PlantDetails plantDetails,
                                    @Prop PlantRowCardSpec.Callback callback
    ) {
        // TODO: describe your UI with existing components https://fblitho.com/docs/layout-specs
        Column.Builder text = Column.create(c)
                .paddingDip(YogaEdge.ALL, plantDetails.getPad())
                .child(
                        Text.create(c)
                                .text(plantDetails.getPlantName())
                                .maxLines(1)
                                .ellipsize(TextUtils.TruncateAt.END)
                                .textSizeSp(plantDetails.getSizeHeading())
                                .textColor(Color.parseColor(plantDetails.getColourText()))
                ).child(
                        Text.create(c)
                                .text(plantDetails.getScientificName())
                                .maxLines(1)
                                .textSizeSp(plantDetails.getSizeBody())
                                .textColor(Color.parseColor(plantDetails.getColourText()))
                ).child(
                        Text.create(c)
                                .text(plantDetails.getCategory())
                                .maxLines(1)
                                .textSizeSp(plantDetails.getSizeBody())
                                .textColor(Color.parseColor(plantDetails.getColourText()))
                ).child(
                        Text.create(c)
                                .text(plantDetails.getOrigin())
                                .maxLines(1)
                                .textSizeSp(plantDetails.getSizeBody())
                                .textColor(Color.parseColor(plantDetails.getColourText()))
                );
        return Row.create(c)
                .backgroundColor(Color.parseColor(plantDetails.getColourBackground()))
                .clickHandler(PlantRowCard.onClick(c))
                .child(Card.create(c)
                        .clippingColor(Color.parseColor(plantDetails.getColourBackground()))
                        .cornerRadiusDip(plantDetails.getRadius())
                        //.backgroundColor(Color.parseColor(plantDetails.getColourBackground()))
                        //.cardBackgroundColor(Color.parseColor(plantDetails.getColourBackground()))
                        .content(GlideImage.create(c)
                                //.backgroundColor(Color.parseColor(plantDetails.getColourBackground()))
                                //.paddingDip(YogaEdge.ALL, 16)
                                .imageUrl(plantDetails.getImageUri())
                                .placeholderImageRes(R.drawable.ic_placeholder_cover)
                                // .aspectRatio(2f)
                                .widthDip(100)
                                .heightDip(100)
                                .centerCrop(true)
                                .build())
                ).child(text).build();
    }

    @OnEvent(ClickEvent.class)
    static void onClick(
            ComponentContext c,
            @FromEvent View view,
            @Prop ApiResponse.PlantDetails plantDetails,
            @Prop Callback callback
    ) {
        callback.onPlantClick(plantDetails);
    }

    public interface Callback {
        void onPlantClick(ApiResponse.PlantDetails plant);
    }
}
