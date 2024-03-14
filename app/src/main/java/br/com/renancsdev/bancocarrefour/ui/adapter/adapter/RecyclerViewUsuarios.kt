package br.com.renancsdev.bancocarrefour.ui.adapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.bancocarrefour.ui.adapter.holder.ViewHolderUsuarios
import br.com.renancsdev.bancocarrefour.databinding.ItemListUsuarioBinding
import br.com.renancsdev.bancocarrefour.model.login.Login
import java.util.ArrayList

class RecyclerViewUsuarios(private var logins: List<Login>): RecyclerView.Adapter<ViewHolderUsuarios>(), Filterable {

    var loginsFilterList = logins


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUsuarios {
        return ViewHolderUsuarios(ItemListUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent , false))
    }
    override fun getItemCount() = loginsFilterList.size
    override fun onBindViewHolder(holder: ViewHolderUsuarios, position: Int) = holder.bind(loginsFilterList[position])


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {

                loginsFilterList = if (charSequence!!.isEmpty()) {
                    logins
                } else {
                    val resultList = ArrayList<Login>()
                    logins.forEach {
                        if (it.login.lowercase().contains(charSequence.toString().lowercase())) {
                            resultList.add(it)
                        }
                    }
                    resultList
                }

                val filterResults = FilterResults()
                filterResults.values = loginsFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults) {

                if (results.count > 0) {
                    loginsFilterList = ((results.values) as ArrayList<Login>)
                    notifyDataSetChanged()
                }

            }
        }
    }

}