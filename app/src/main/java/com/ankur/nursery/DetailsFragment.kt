package com.ankur.nursery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView

class DetailsFragment : Fragment() {
    fun newInstance(plant: ApiResponse.PlantDetails): DetailsFragment {
        val args = Bundle()
        args.putSerializable("plant", plant)
        val fragment = DetailsFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val plant = arguments?.getSerializable("plant") as? ApiResponse.PlantDetails
        return LithoView.create(
            context,
            PlantDetails.create(ComponentContext(context))
                .plant(plant)
                .build()
        )
    }
}