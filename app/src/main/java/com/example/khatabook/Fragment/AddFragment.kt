package com.example.khatabook.Fragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import com.example.khatabook.DBhelper.DBhelper
import com.example.khatabook.R
import com.example.khatabook.TransactionModal
import com.example.khatabook.databinding.FragmentAddBinding
import com.nex3z.togglebuttongroup.SingleSelectToggleGroup
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.Locale.Category

class AddFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    lateinit var binding: FragmentAddBinding
    lateinit var db: DBhelper
    var isexpense = 0
    var calendar = Calendar.getInstance()
    var formatter = SimpleDateFormat("MMM. dd, yyyy", Locale.US)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)

        db = DBhelper(context)

        //  var dialog = Dialog(requireContext())

        binding.setDate.setOnClickListener {

            DatePickerDialog(
                requireContext(),
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
                .show()

        }

        binding.groupChoices.setOnCheckedChangeListener { group, checkedId ->
            if (binding.choiceA.id == checkedId) {
                isexpense = 0
                binding.txtsave.text = "ADD Income"
            } else if (binding.choiceB.id == checkedId)
                isexpense = 1
            binding.txtsave.text = "ADD Expense"
        }




        binding.txtsave.setOnClickListener {
            var amt = binding.txtamount.text.toString().toInt()
            var cate = binding.txtcategory.text.toString()
            var note = binding.txtnotes.text.toString()
            var time = binding.setDate.text.toString()

            var data = TransactionModal(0, amt, cate, note, isexpense,time)

            db.addTrans(data)
        }






        return binding.root

    }


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {


        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)


        val selecteddate = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.time)
        val selectedDateBundle = Bundle()
        selectedDateBundle.putString("", selecteddate)

        val mCalendar = Calendar.getInstance()
        mCalendar[Calendar.YEAR] = year
        mCalendar[Calendar.MONTH] = month
        mCalendar[Calendar.DAY_OF_MONTH] = dayOfMonth
        val selectedDate: String =
            DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.time)
        binding.setDate.setText(selectedDate)
    }


}

