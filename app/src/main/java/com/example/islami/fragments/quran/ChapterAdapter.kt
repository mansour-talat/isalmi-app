package com.example.islami.fragments.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.QuranItemsBinding
import com.example.islami.models.Chapter

class ChapterAdapter(
    private val surasList: List<Chapter>,
    private val onItemClick: ((Chapter) -> Unit)? = null
) : RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {

    class ViewHolder(private val itemsBinding: QuranItemsBinding) :
        RecyclerView.ViewHolder(itemsBinding.root) {

        fun bind(chapter: Chapter, onItemClick: ((Chapter) -> Unit)?) {
            itemsBinding.ArTitle.text = chapter.titleAr
            itemsBinding.EnTitle.text = chapter.titleEn
            itemsBinding.chaptersNumberTv.text = chapter.index.toString()  // Ensure index is correct
            itemsBinding.versesNum.text = "${chapter.verseNumbers} verses" // String interpolation

            // Handle item click if provided
            itemsBinding.root.setOnClickListener { onItemClick?.invoke(chapter) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsBinding =
            QuranItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsBinding)
    }

    override fun getItemCount(): Int = surasList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chapter = surasList[position]
        holder.bind(chapter, onItemClick)
    }
}
