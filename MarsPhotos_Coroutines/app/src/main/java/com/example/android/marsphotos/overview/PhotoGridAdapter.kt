package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class PhotoGridAdapter : ListAdapter<MarsPhoto,PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<MarsPhoto>() {
        /**
         * This method is called by DiffUtil to decide whether two objects represent the same item.
         * The ID of every item (MarsPhoto object) is unique.
         */
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        /**
         * This method is called by DiffUtil when it wants to check whether two items have the same data.
         * The important data in the MarsPhoto is the image URL. This is the content compared.
         */
        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    /**
     * This method needs to return a new MarsPhotoViewHolder, created by inflating the GridViewItemBinding and
     * using the LayoutInflater from your parent ViewGroup context.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.MarsPhotoViewHolder {
        return MarsPhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Call getItem() to get the MarsPhoto object associated with the current RecyclerView position,
     * then pass that property to the bind() method in the MarsViewPhotoHolder
     */
    override fun onBindViewHolder( holder: PhotoGridAdapter.MarsPhotoViewHolder, position: Int){
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

    class MarsPhotoViewHolder (private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(MarsPhoto: MarsPhoto){
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }
    }
}