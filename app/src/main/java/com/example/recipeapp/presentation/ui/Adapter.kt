package com.example.recipeapp.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recipeapp.R
import com.example.recipeapp.domain.model.Recipe
import kotlinx.android.synthetic.main.recipe_list.view.*

class Adapter(
        private val RecipeList: List<Recipe>
) :RecyclerView.Adapter<Adapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.image
        val rating = itemView.rating1
        val title = itemView.itemName
        val publisher = itemView.publisher

        init {
            itemView.setOnClickListener { v: View ->
                //To provide the arguments for the particular recipe the user have asked for

            }
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.recipe_list,parent,false)
        return ViewHolder(itemView)


    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        when(holder){
//            is ViewHolder -> {
//                holder.bind(RecipeList.get(position)) //This will send a particular recipe to the list
//                Log.d("Tag", "Adapter checking ${holder.bind(RecipeList.get(position))}")
//            }
//        }
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.resource_default)
            .error(R.drawable.resource_default)

        var curr = RecipeList.get(position)

        curr.publisher?.let{
            holder.publisher.setText(it.capitalize())//To capitalise the fisrt letter of the text
        }

        curr.featuredImage?.let{
            Glide.with(holder.itemView)
                .applyDefaultRequestOptions(requestOptions)
                .load(it)
                .into(holder.imageView)
        }

        curr.title?.let{
            holder.title.setText(it)
        }
        curr.rating?.let{
            holder.rating.text= it.toString() //Because we cannot set integer values to the text views
        }










    }

    override fun getItemCount() = RecipeList.size
}