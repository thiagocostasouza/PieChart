package com.thiagoio.piecharttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.ViewPortHandler


class MainActivity : AppCompatActivity() {

    private val pieChart by lazy { findViewById<PieChart>(R.id.pieChart) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPieChart()
    }

    private fun setPieChart() {
        //Setup pie Entries


        val pieEntries = arrayListOf<PieEntry>()
        pieEntries.add(PieEntry(30.0f, "Android"))
        pieEntries.add(PieEntry(40.0f, "Flutter"))
        pieEntries.add(PieEntry(35.0f, "Java"))
        pieEntries.add(PieEntry(50.0f, "Fullstack"))
        pieEntries.add(PieEntry(10.0f, "Outras Trilhas"))


        //Setup Pie Chart Animation
        pieChart.animateXY(1000, 1000)

        val colors = ArrayList<Int>()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }

        for (color in ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color)
        }

        //setup value format


        //Setup Piechart Entries Colers
        val pieDataSet = PieDataSet(pieEntries, "Insiders")
        pieDataSet.valueTextSize = 10f
        pieDataSet.valueTextColor = R.color.blue
        pieDataSet.colors = colors


        //Now setup text in PieChart Center
        pieChart.centerText = "Insiders"
        pieChart.setUsePercentValues(true)
        pieChart.setCenterTextColor(resources.getColor(R.color.black))
        pieChart.setCenterTextSize(15f)
        pieChart.setEntryLabelTextSize(8f)

        // Set Pie Data Set in PieData

        val pieData = PieData(pieDataSet)

        pieData.setValueFormatter(PercentFormatter(pieChart))


        // Now Lets Hide the PieChar Entries Tags
        pieChart.legend.isEnabled = false

        //Now Hide the description of pieChart
        pieChart.description.isEnabled = false
        pieChart.holeRadius = 80f


        //This enabled the on each pieEntry
        pieData.setDrawValues(true)
        pieChart.data = pieData
    }


}