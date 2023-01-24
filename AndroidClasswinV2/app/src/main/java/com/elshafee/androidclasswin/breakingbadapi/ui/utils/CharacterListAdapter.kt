package com.elshafee.androidclasswin.breakingbadapi.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elshafee.androidclasswin.R
import com.elshafee.androidclasswin.breakingbadapi.model.BreakingBadCharacters
import com.elshafee.androidclasswin.databinding.ItemCharacterBinding

class CharacterListAdapter(private val clickCallBack: ((BreakingBadCharacters) -> Unit)?) :
    ListAdapter<BreakingBadCharacters, CharacterListAdapter.CharacterViewHolder>(CharacterCompare()) {
    class CharacterViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val tvCharcterName: TextView = itemView.findViewById(R.id.tvCharacterName)
        private val tvCharacterNickname: TextView = itemView.findViewById(R.id.tvCharacterNickName)
        private val tvCharacterBirthdat: TextView = itemView.findViewById(R.id.tvCharacterBirthday)
        private val tvCharacterOccupation: TextView =
            itemView.findViewById(R.id.tvCharacterOccupation)
        private val tvCharacterStatus: TextView = itemView.findViewById(R.id.tvCharacterStatus)
        private val ivCharacterImage: ImageView = itemView.findViewById(R.id.ivCharacterImage)


        fun bind(character: BreakingBadCharacters) {
            tvCharcterName.text = character.name
            tvCharacterNickname.text = character.nickname
            tvCharacterBirthdat.text = character.birthday
            tvCharacterOccupation.text = character.occupation.joinToString(", ")
            tvCharacterStatus.text = character.status

            if (character.img != null) {
                Glide.with(itemView).load(character.img).centerCrop().into(ivCharacterImage)
            }
        }

        companion object {
            fun create(parent: ViewGroup): CharacterViewHolder {
                return CharacterViewHolder(
                    ItemCharacterBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
        holder.itemView.setOnClickListener{
            clickCallBack?.invoke(character)
        }
    }
}


class CharacterCompare : DiffUtil.ItemCallback<BreakingBadCharacters>() {
    override fun areItemsTheSame(
        oldItem: BreakingBadCharacters, newItem: BreakingBadCharacters
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: BreakingBadCharacters, newItem: BreakingBadCharacters
    ): Boolean {
return oldItem.name == newItem.name &&
        oldItem.nickname ==newItem.nickname&&
        oldItem.status == newItem.status &&
        oldItem.img == newItem.img&&
        oldItem.birthday == newItem.birthday&&
        oldItem.occupation == newItem.occupation
    }
}