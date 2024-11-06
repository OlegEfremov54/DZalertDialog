package com.example.dzalertdial

import android.app.AlertDialog
import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast

class MyDialog { companion object {
    fun createDialog(context: Context, adapter: ArrayAdapter<User>) =
        AdapterView.OnItemClickListener { parent, v, position, id ->
            val builder = AlertDialog.Builder(context)
            builder.setTitle("ВНИМАНИЕ")
                .setIcon(R.drawable.baseline_delete_forever_24)
                .setMessage("Подтвердите удаление пользователя")
                .setCancelable(true)
                .setNegativeButton("Отмена") { dialog, which ->
                    dialog.cancel()

                }
                .setPositiveButton("Да") { dialog, which ->
                    val user = adapter.getItem(position)
                    adapter.remove(user)
                    Toast.makeText(context, "Пользователь $user удалён!", Toast.LENGTH_LONG)
                        .show()
                }.create()
            builder.show()
        }
}
}