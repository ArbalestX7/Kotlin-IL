package com.dito.fundamental1.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.dito.fundamental1.R
import com.dito.fundamental1.ui.activity.LoginActivity

class HomeFragment : Fragment() {
    private lateinit var btnLogout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogout = view.findViewById(R.id.btn_Logout)
        btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        val logoutDialog = AlertDialog.Builder(requireActivity())
        with(logoutDialog) {
            setTitle(resources.getString(R.string.btn_logout))
            setMessage(resources.getString(R.string.log_desc))
            setPositiveButton(resources.getString(R.string.yes)) { _, _ ->
                val i = Intent(requireActivity(), LoginActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
                onDestroy()
            }
            setNegativeButton(resources.getString(R.string.no)) { dialog, _ -> dialog.cancel() }
        }
        val alertDialog = logoutDialog.create()
        alertDialog.show()
    }
}