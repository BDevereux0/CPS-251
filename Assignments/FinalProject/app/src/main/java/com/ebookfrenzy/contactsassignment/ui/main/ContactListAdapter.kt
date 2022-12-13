package com.ebookfrenzy.contactsassignment.ui.main


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.contactsassignment.Contact
import com.ebookfrenzy.contactsassignment.R

class ContactListAdapter(private val contactItemLayout: Int):
            RecyclerView.Adapter<ContactListAdapter.ViewHolder>(){

    private var listener: OnItemClickListner? = null
    private var contactList: List<Contact>? = null


    interface OnItemClickListner{
        fun onClick(str : String){
        }
    }

    fun settingListener(listener: OnItemClickListner?) {
        this.listener = listener
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, listPosition: Int){
        val item = viewHolder.item
        contactList.let {
            item.text = it!![listPosition].contactName + "\n"+ it[listPosition].contactNumber
        }

        viewHolder.deleteBtn.setOnClickListener {
            listener?.onClick(viewHolder.item.text.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)

        view.isClickable
        view.focusable
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setContactList(contacts: List<Contact>){
        contactList = contacts
        notifyDataSetChanged()

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var item: TextView = itemView.findViewById(R.id.nameOutput)
        var deleteBtn: ImageButton = itemView.findViewById(R.id.deleteBtn)


    }
}