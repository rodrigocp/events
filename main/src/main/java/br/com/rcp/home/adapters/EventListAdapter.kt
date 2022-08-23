package br.com.rcp.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rcp.domain.models.Event
import br.com.rcp.home.databinding.ListItemBinding

class EventListAdapter(private val context: Context, private val list: ArrayList<Event>, private val listener: ((event: Event) -> Unit)) : RecyclerView.Adapter<EventListAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding  = ListItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun add(events: List<Event>) {
        list.addAll(events)
    }

    fun clear() {
        list.clear()
    }

    inner class ItemViewHolder(private val binding: ListItemBinding, private val listener: ((event: Event) -> Unit)) : RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event) {
            with(event) {
                binding.event   = this
                binding.dateView.bind(date)
                binding.shortDescriptionView.bind(title, latitude, longitude, price)
            }

            binding.root.setOnClickListener {
                listener.invoke(event)
            }
        }
    }
}