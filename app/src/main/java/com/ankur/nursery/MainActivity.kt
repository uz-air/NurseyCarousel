package com.ankur.nursery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val repository: PlantsRepository by lazy { PlantsRepository() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showLoading()
        // callApi()
        //useMockJson()

    }


    private fun callApi() {
        repository.callGetPlants(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>?, t: Throwable?) {
                Log.d("MainActivity", "Problem calling Github API {${t?.message}}")
                errorHandler()
            }

            override fun onResponse(call: Call<ApiResponse>?, apiResponse: Response<ApiResponse>?) {
                apiResponse?.isSuccessful.let {
                    apiResponse?.body()?.data?.let { showPodcastList(it) }
                } ?: run {/*
                    val list: MutableList<ApiResponse.PlantDetails> =
                        ArrayList<ApiResponse.PlantDetails>()
                    for (i in 1..5) {
                        val podcast = ApiResponse.PlantDetails(
                            cover = "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
                            imageUri = "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
                            plantName = "Hello World",
                            headingSize = "10",
                            description = "Nothing",
                            id = String.format("%2d", i),
                            category = "Podcast",
                            origin = "English",
                            scientificName = "Yes",
                            thumbnail = "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
                        )
                        list.add(podcast)
                    }
                    showPodcastList(list)*/
                }
            }
        })
    }

    private fun errorHandler() {
        Toast.makeText(this@MainActivity, "failed", Toast.LENGTH_SHORT).show()
    }

    fun showPodcastList(plantsList: List<ApiResponse.PlantDetails?>) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, CarousalFragment().newInstance(plantsList))
            .commit()
    }

    private fun showLoading() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, LoadingFragment())
            .commit()
    }
    private fun useMockJson() {
        val json = """{
      "statusCode": 200,
      "message": "Okay",
      "data": [
        {
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        },{
          "id": "1",
          "imageUri": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "plantName": "plantName",
          "description": "Many houseplants absorb toxic substances such as formaldehyde, benzene and trichloroethylene, found in man-made materials that are known to \"off-gas\" pollutants into the air in your home, school, and office. In addition, a study done at Virginia Tech led researchers to conclude that houseplants can reduce indoor dust by up to 20%. In effect, houseplants are efficient air cleaners. \n\nNASA has done extensive studies of the role of houseplants in cleansing the air, hoping to capitalize on these benefits for future space stations. Their studies have shown that certain houseplants are exceptionally good at cleansing the air (click to see NASA’s houseplant list). NASA recommends having 15-18 houseplants for a 1,800 square-foot house. While not all of us have room for quite that many plants, even just a few can be effective. Dr. Virginia Lohr, a professor of horticulture at Washington State University, suggests that filling as little as 2% of the room with plants will make an impact.\n\nIndoor plants improve air quality in other ways as well. Plants release water vapor into the air, which increases humidity, and this can help improve respiratory and skin health by offsetting the drying effects of heating systems. This can be an incredible benefit to those with respiratory issues, headaches, and allergies.\n\nPlants also increase oxygen levels in the air by absorbing carbon dioxide and releasing oxygen during photosynthesis. According to a Seattle Times article, you can maximize your benefits by placing plants \"in your 'breathing zone,' within 6 to 8 square feet of where you normally sit or lie.\"\n\nA positive effect of this increased oxygenation can be to improve our mood, energy, and mental focus. In fact, studies have found that when people were allowed to have indoor plants in their office space, their work performance improved! No wonder so many new tech offices are including indoor spaces reminiscent of forests and tropical oases. Not only are they beautiful, they also help people feel better and work better.",
          "cover": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg",
          "category": "category",
          "origin": "origin",
          "scientificName": "scientificName",
          "thumbnail": "https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg"
        }
    
    
      ]
    }"""
        val response = Gson().fromJson(json, ApiResponse::class.java)
        response.data?.let { showPodcastList(it) }
    }

}