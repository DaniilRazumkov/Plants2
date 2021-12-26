package com.example.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.list.databinding.ActivityEditActiviryBinding

class EditActiviry : AppCompatActivity() {
    lateinit var binding: ActivityEditActiviryBinding
    private var indexImage=0
    private var imageId=R.drawable.plant1
    private val imageIdList= listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEditActiviryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun initButtons()= with(binding){
        bNext.setOnClickListener{
            indexImage++
            if (indexImage > imageIdList.size -1)indexImage = 0
            imageId=imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener{
            val plant= Plant(imageId,edTitle.text.toString(), edTitle2.text.toString())
            val editIntent=Intent().apply {
                putExtra("plant",plant)
            }
            setResult(RESULT_OK,editIntent)
            finish()

        }
    }
}