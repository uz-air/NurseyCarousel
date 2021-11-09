package com.ankur.nursery

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ankur.nursery.databinding.FragmentLoadingBinding
import com.google.gson.Gson

class LoadingFragment : Fragment(R.layout.fragment_loading) {

    private var _binding: FragmentLoadingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val json = mockJson()
        binding.json.setText(json)
        binding.button.setOnClickListener {
            val plantList =
                convertJson()
            plantList?.let {
                activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.content,
                    CarousalFragment().newInstance(plantList)
                )?.addToBackStack(null)?.commit()
            } ?: run { Toast.makeText(context, "Invalid Json", Toast.LENGTH_SHORT).show() }
        }
    }

    private fun convertJson(): List<ApiResponse.PlantDetails?>? {

        return try {
            val response =
                Gson().fromJson(binding.json.text.toString(), ApiResponse::class.java).data
            response?.forEach { plantDetails ->
                plantDetails?.backgroundColour?.let { Color.parseColor(it) }
                plantDetails?.textColour?.let { Color.parseColor(it) }

            }
            response
        } catch (e: Exception) {
            null
        }
    }

    private fun mockJson() =
        """{
          "statusCode": 200,
          "message": "Okay",
          "data": [
            {
              "id": "1",
              "imageUri": "https://www.gardeningknowhow.com/wp-content/uploads/2020/11/cactus-garden.jpg",
              "plantName": "Cactus",
              "description": "Cactuses contain vitamins C, E, A, iron, calcium, and more. This wide range of nutrients and more can help reduce inflammation in the body. Research found that taking cactus extract after drinking five to seven alcoholic drinks resulted in fewer hangover symptoms (such as nausea, vomiting, or dry mouth). Cacti are succulent plants. This means that they have thick tissues that take up and hold large amounts of water. The stored water keeps them alive during dry periods. Unlike many plants, cacti do not have deep roots. Instead they have roots that spread out near the surface of the soil. This is important to their survival. These roots absorb water from a wide area during the few times it rains.

Cacti are known for their pointy spines. These grow in different patterns on the plant’s surface. Some cacti also have flowers and branches. Most do not have leaves. If a cactus has leaves, they are very small and fall off as the plant grows.

Cacti come in many sizes. The cactus called the prickly pear grows in low bunches. The giant cactus known as the saguaro can be 50 feet (15 meters) tall. Its branches may be 2 feet (about 0.6 meter) thick.

Most cacti grow in the ground. Some cacti, known as epiphytes, grow on plants. Others may grow on hard things such as rocks. Cacti are often grown for decoration. Many unusual and beautiful varieties are prized as houseplants. In South America cacti are sometimes used as fences. Arizona has adopted the saguaro as its state flower.

Some types of cacti are also grown for food. The egg-shaped fruit of the saguaro can be eaten. People also eat the fruit of the prickly pear.

",
              "category": "Plantae",
              "origin": "Desert",
              "scientificName": "Cactaceae",
              "headingSize": 24,
              "bodySize": 14,
              "padding": 10,
              "cardRadius": 0,
              "backgroundColour": "#0000FF",
              "textColour": "#FFA500"
            },{
              "id": "1",
              "imageUri": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-o1YrqXort2e0-7mcr7MY0DQ7EkH-jC3pOg&usqp=CAU",
              "plantName": "Apple",
              "description": "My Favourite Fruit
You must have heard that “an apple a day, keeps the doctor away.” I remember hearing this for the first time and I decided to eat an apple every day. Ever since it has become my favourite fruit.

It is round in shape and comes in a red colour. But, there are also green apples. An apple contains a high quantity of juice which is mixed with high fibres. It tastes sweet and is edible for everyone.

As it is one of the healthiest fruit, it is my favourite. I try to eat one every day for the betterment of my health. One single apple contains 130 calories. The insoluble fibre in the fruit is effective for the body because it does not mix with water.

Further, we get apples in many sizes and shapes. We can use it for extraction, skin, chewing and drinking juice. I always carry an apple in my tiffin and share it with my friends as well. With so many benefits it offers, it has become my favourite fruit.

Benefits of Apple
Apples offer many benefits to everyone. The dietary fibre in it is soluble which helps the body to prevent problems of cardiac diseases. Further, they are also helpful to people who suffer from asthma, anaemia and other problems.

They can combat many diseases and dietary fibre which helps to prevent constipation problems. Moreover, it also comes in use for cancer patients to fight this disease. All over the world, there are different kinds of apples which are produced in large numbers.

Apples have many other advantages like reducing weight and keeping the heart-healthy. Similarly, it also reduces the high risk of diabetes. The prebiotic effects offer healthy bacteria which prevents cancer and helps in the growth of bones.

Apples also circulate proper metabolism and maintain the digestive system well. Most importantly, it also offers protection to your brain by vitamins and proteins which are present in it.

It is essential to remember that we must always chew the apple properly so that it does end up harming you instead. With so many benefits it offers, it truly keeps the doctor away if you eat it every day.

Get the huge list of more than 500 Essay Topics and Ideas

Conclusion of the Essay on Apple
In today’s world, a lot of apples are coming with pesticides inside them. Thus, they need to certified organic now before entering the market. Thus, we must make sure to eat organic apples only. This fruit can never be boring as we can use it in many ways. This nutritional fruit is beneficial for our bodies and gives us the strength to make our body strong.

FAQ of Essay on Apple
Question 1: What vitamin is in apples?

Answer 1: Apples contain a high amount of vitamin C. It is a powerful natural antioxidant that can assist in boosting your body’s resistance to both infectious agents and damage caused by free radicals. Each time we eat an apple, we’ll get a healthy dose of this vitamin and B-complex vitamins.

Question 2: Is eating apples everyday good for you?

Answer 2: Apples are very good for you. Eating them lowers the risk of numerous major diseases, including diabetes and cancer. The soluble fibre content of the apple may promote weight loss and gut health.",
              "scientificName": "Pyrus malus",
              "headingSize": 24,
              "bodySize": 14,
              "padding": 10,
              "cardRadius": 20,
              "backgroundColour": "#FFFFFF00",
              "textColour": "#FFFF0000"
            },{
              "id": "1",
              "imageUri": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQI7_0-2maGqtMSvT5_l4f8Fxl4S478viLzZA&usqp=CAU",
              "plantName": "Bamboo",
              "description": "Bamboosa aridinarifolia",
              
              "scientificName": "Bamboosa aridinarifolia",
              "headingSize": 24,
              "bodySize": 14,
              "padding": 10,
              "cardRadius": 10,
              "backgroundColour": "#0000FF",
              "textColour": "#FFA500"
            },{
              "id": "1",
              "imageUri": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHUm4Ge7GkH9R-_T0xNZyiwlXtiV8AjPlIhA&usqp=CAU",
              "plantName": "Banana",
              "description": "description",
              "scientificName": "Musa paradisicum"
            },{
              "id": "1",
              "imageUri": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1IFG_V6xiYoozKiWjTKKWIFjYgCXM33emkw&usqp=CAU",
              "plantName": "Pineapple",
              "description": "description",
              "scientificName": "Ananus sativus"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Banyan",
              "description": "description",
              "scientificName": "Ficus benghalensis"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Black Gram",
              "description": "description",
              "scientificName": "Palsoes Mungo"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Barley",
              "description": "description",
              "scientificName": "Hordeum vulgare"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Black Pepper",
              "description": "description",
              "scientificName": "Piper nigrum"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Brinjal",
              "description": "description",
              "scientificName": "Solanum melongena"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Capsicum",
              "description": "description",
              "scientificName": "Capsicum fruitscence"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Carrot",
              "description": "description",
              "scientificName": "Daucas carota"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Clove",
              "description": "description",
              "scientificName": "Syzygium aromaticum"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Cashew nut",
              "description": "description",
              "scientificName": "Anacardium occidentale"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Cotton",
              "description": "description",
              "scientificName": "Gossypium herbaceum"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Cucumber",
              "description": "description",
              "scientificName": "Cucumis sativas"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Curry leaf",
              "description": "description",
              "scientificName": "Murraya koenigii"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Drumstick",
              "description": "description",
              "scientificName": "Moringa oleifera"
            },{
              "id": "1",
              "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
              "plantName": "Garlic",
              "description": "description",
              "scientificName": "Allium sativum"
            }
          ]
        }"""
}
