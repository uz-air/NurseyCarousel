package com.ankur.nursery;

import androidx.recyclerview.widget.OrientationHelper;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Column;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.yoga.YogaEdge;

import java.util.List;

@LayoutSpec
class PlantListSpec {

    @OnCreateInitialState
    static void onCreateInitialState(ComponentContext c
    ) {
        // TODO: remove this method if not needed. Set an initial value for a state https://fblitho.com/docs/state
    }

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c,
                                    @Prop List<ApiResponse.PlantDetails> plantDetails,
                                    @Prop PlantRowCardSpec.Callback callback
    ) {
        // TODO: describe your UI with existing components https://fblitho.com/docs/layout-specs

        RecyclerBinder recyclerBinder = new RecyclerBinder.Builder().layoutInfo(
                new LinearLayoutInfo(
                        c.getApplicationContext(),
                        OrientationHelper.VERTICAL,
                        false
                )).build(c);

        if (plantDetails != null) {
            populateList(c, recyclerBinder, plantDetails,callback);
        }

        return Recycler.create(c)
                .binder(recyclerBinder)
                .build();
    }

    private static void populateList(ComponentContext c,
                                     RecyclerBinder recyclerBinder,
                                     List<ApiResponse.PlantDetails> plantDetails,
                                     PlantRowCardSpec.Callback callback) {
        int i = 0;
        for (ApiResponse.PlantDetails plant : plantDetails) {
            ComponentRenderInfo.Builder componentInfoBuilder = ComponentRenderInfo.create();
            componentInfoBuilder.component(
                    PlantRowCard.create(c).paddingDip(YogaEdge.ALL, plant.getPad())
                            .callback(callback)
                            .plantDetails(plant)
                            .build());

            recyclerBinder.insertItemAt(i++, componentInfoBuilder.build());
        }
    }
}