package com.fakhrulasa.custominappmessage

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.DialogFragment
import com.fakhrulasa.custominappmessage.databinding.FragmentPopupDialogBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PopupDialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class PopupDialog {

    private var dialog: Dialog? = null

    fun showDialog(activity: Activity,onClick:()->Unit) {
        val binding = FragmentPopupDialogBinding.inflate(LayoutInflater.from(activity), null, false)
        dialog = Dialog(activity).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(binding.root)
            setCancelable(true)
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            setCancelable(true)
            binding.imageView.setOnClickListener {
                onClick.invoke()
            }
            show()
        }
    }

    fun cancelDialog() {
        dialog?.dismiss()
    }

}