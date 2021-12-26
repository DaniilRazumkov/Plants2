package com.example.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.PlantItemBinding

class PlantAdapter:RecyclerView.Adapter<PlantAdapter.PlanHolder> (){
val plantList=ArrayList<Plant>()
    class PlanHolder(item:View): RecyclerView.ViewHolder (item){
        val binding=PlantItemBinding.bind(item)
        fun bind(plant: Plant)= with(binding){
            im.setImageResource(plant.imageId)
            tvTitle.text=plant.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlanHolder(view)
    }

    override fun onBindViewHolder(holder: PlanHolder, position: Int) {
        holder.bind (plantList[position])
    }

    override fun getItemCount(): Int {
      return plantList.size
    }
    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }
}