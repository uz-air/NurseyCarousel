package com.ankur.nursery;

import android.graphics.Color;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Column;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Text;
import com.facebook.litho.widget.VerticalScroll;
import com.facebook.yoga.YogaEdge;
import com.github.pavlospt.litho.glide.GlideImage;

@LayoutSpec
class PlantDetailsSpec {

    @OnCreateInitialState
    static void onCreateInitialState(ComponentContext c
    ) {
        // TODO: remove this method if not needed. Set an initial value for a state https://fblitho.com/docs/state
    }

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop ApiResponse.PlantDetails plant
    ) {


        final Column heading = Column.create(c)
                .paddingDip(YogaEdge.ALL, plant.getPad())
                .child(
                        Text.create(c)
                                .text(plant.getPlantName())
                                .textColor(Color.parseColor(plant.getColourText()))
                                .textSizeSp(plant.getSizeHeading())
                ).child(
                        Text.create(c)
                                .text(plant.getScientificName())
                                .textColor(Color.parseColor(plant.getColourText()))
                                .textSizeSp(plant.getSizeBody())
                ).build();

        final Card.Builder titleBar = Card.create(c)
                .clippingColor(Color.parseColor(plant.getColourBackground()))
                .cornerRadiusDip(plant.getRadius())
                .paddingDip(YogaEdge.ALL, plant.getPad())
                .cardBackgroundColor(Color.parseColor(plant.getColourBackground()))
                .content(heading);

        final Column desc = Column.create(c)
                .paddingDip(YogaEdge.ALL, plant.getPad())
                .child(Text.create(c)
                        .text(plant.getDescription())
                        .textColor(Color.parseColor(plant.getColourText()))
                        .textSizeSp(plant.getSizeBody())
                ).build();
        final Card.Builder description = Card.create(c)
                .clippingColor(Color.parseColor(plant.getColourBackground()))
                .cornerRadiusDip(plant.getRadius())
                .cardBackgroundColor(Color.parseColor(plant.getColourBackground()))
                .content(desc);

        final Card.Builder image = Card.create(c)
                .paddingDip(YogaEdge.ALL, plant.getPad())
                .clippingColor(Color.parseColor(plant.getColourBackground()))
                .backgroundColor(Color.parseColor(plant.getColourBackground()))
                .cornerRadiusDip(plant.getRadius())
                .content(GlideImage.create(c)
                        .imageUrl(plant.getImageUri())
                        .placeholderImageRes(R.drawable.ic_placeholder_cover)
                        .aspectRatio(2f).fitCenter(true)
                        //.centerCrop(true)
                        .build());

        final Column.Builder info = Column.create(c)
                .paddingDip(YogaEdge.ALL, plant.getPad())
                .child(titleBar)
                .child(description);

        return VerticalScroll.create(c).scrollbarEnabled(true)
                .childComponent(Column.create(c)
                        .backgroundColor(Color.parseColor(plant.getColourBackground()))
                        .child(image)
                        .child(info))
                .build();
    }
}