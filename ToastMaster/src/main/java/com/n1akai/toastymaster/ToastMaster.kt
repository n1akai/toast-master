package com.n1akai.toastymaster

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast

class ToastMaster private constructor(builder: Builder) : Toast(builder.context) {

    lateinit var context: Context
    lateinit var text: String
    lateinit var description: String
    lateinit var status: Status
    var duration: Int = Toast.LENGTH_SHORT

    class Builder(val context: Context) {

        lateinit var text: String
        lateinit var description: String
        lateinit var status: Status
        var duration: Int = Toast.LENGTH_SHORT

        fun setText(text: String) : Builder {
            this.text = text
            return this
        }

        fun setDescription(description: String) : Builder {
            this.description = description
            return this
        }

        fun setStatus(status: Status) : Builder {
            this.status = status
            return this
        }

        fun setDuration(duration: Int) : Builder {
            this.duration = duration
            return this
        }

        fun show() {
            val toast = Toast(context)
            val layout = LayoutInflater.from(context).inflate(R.layout.toast_master_layout, null, false);

            val text: TextView = layout.findViewById(R.id.tm_text);
            val description: TextView = layout.findViewById(R.id.tm_description);

            text.text = this.text
            description.text = this.description

            toast.view = layout
            toast.duration = duration
            toast.show()
        }

    }


    init {
        text = builder.text
        description = builder.description
        status = builder.status
        duration = builder.duration
    }

    enum class Status(val colorId: Int, val iconId: Int) {
        SUCCESS(R.color.success, R.drawable.ic_success),
        WARNING(R.color.warning, ),
        INFO(R.color.info, ),
        ERROR(R.color.error, )
    }
}