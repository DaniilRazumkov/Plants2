package com.example.list

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter=PlantAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
if (it.resultCode == RESULT_OK){
    adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
}
        }
    }
    private fun init(){
        binding.apply {
          rcViev.layoutManager=GridLayoutManager(this@MainActivity,3)
            rcViev.adapter=adapter
            buttonAdd.setOnClickListener{ editLauncher?.launch(Intent(this@MainActivity,EditActiviry::class.java))
            }
        }
    }
}