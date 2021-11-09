package com.ankur.nursery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import java.io.Serializable

class CarousalFragment : Fragment() {
    fun newInstance(plantList: List<ApiResponse.PlantDetails?>): CarousalFragment {
        val args = Bundle()
        args.putSerializable("plantList", plantList as Serializable)
        val fragment = CarousalFragment()
        fragment.arguments = args
        return fragment
    }

    private var plantList: List<ApiResponse.PlantDetails?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plantList = arguments?.getSerializable("plantList") as? List<ApiResponse.PlantDetails>
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LithoView.create(
            context,
            PlantList.create(ComponentContext(context))
                .plantDetails(plantList).callback {
                    activity?.supportFragmentManager?.apply {
                        beginTransaction().replace(R.id.content, DetailsFragment().newInstance(it))
                            .addToBackStack(null).commit()
                    }
                }.build()
        )
    }
}