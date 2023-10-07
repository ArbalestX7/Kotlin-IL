package com.dito.fundamental1.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.dito.fundamental1.R


class DialogFragment : Fragment() {
    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbJov: RadioButton
    private lateinit var rbRez: RadioButton
    private lateinit var rbMau: RadioButton
    private lateinit var rbReh: RadioButton
    private lateinit var rbMeg: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.rg_options)
        rbJov = view.findViewById(R.id.rb_jovian)
        rbReh = view.findViewById(R.id.rb_raihan)
        rbMau = view.findViewById(R.id.rb_maulana)
        rbMeg = view.findViewById(R.id.rb_megy)
        rbRez = view.findViewById(R.id.rb_reza)

        btnChoose.setOnClickListener {
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var mentor: String? = when (checkedRadioButtonId) {
                    R.id.rb_reza -> rbRez.text.toString().trim()
                    R.id.rb_megy -> rbMeg.text.toString().trim()
                    R.id.rb_maulana -> rbMau.text.toString().trim()
                    R.id.rb_jovian -> rbJov.text.toString().trim()
                    R.id.rb_raihan -> rbReh.text.toString().trim()
                    else -> null
                }
                optionDialogListener?.onOptionChosen(mentor)

            }
        }
        btnClose.setOnClickListener {

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }
}