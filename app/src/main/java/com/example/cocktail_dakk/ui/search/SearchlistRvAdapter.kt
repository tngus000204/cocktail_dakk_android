package com.example.cocktail_dakk.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktail_dakk.data.entities.Cocktail
import com.example.cocktail_dakk.databinding.ItemCocktailBinding

class SearchlistRvAdapter(private var cocktaillist : ArrayList<Cocktail>) : RecyclerView.Adapter<SearchlistRvAdapter.Viewholder>() {

    private lateinit var mItemClickListener: SearchlistRvAdapter.MyItemClickListener

    interface MyItemClickListener{
        fun onItemClick(cocktail: Cocktail)
    }

    fun setClickListiner(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding:ItemCocktailBinding = ItemCocktailBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(cocktaillist[position])

        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(cocktaillist[position])    //외부에서 처리할 수 있도록
        }
    }

    override fun getItemCount(): Int = cocktaillist.size

    inner class Viewholder(var binding : ItemCocktailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cocktail : Cocktail){
            binding.itemCocktailImgIv.setImageResource(cocktail.image)
            binding.itemCocktailNameLocalTv.text = cocktail.localName
            binding.itemCocktailNameEnglishTv.text = cocktail.englishName
        }
    }
}