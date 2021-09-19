package com.runwithme.runwithme.view.groups

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.runwithme.runwithme.databinding.ActivityCompareStatisticsBinding
import com.runwithme.runwithme.model.GroupRun
import com.runwithme.runwithme.model.Run
import com.runwithme.runwithme.utils.Constants.GROUP_RUN
import com.runwithme.runwithme.utils.MeasureUtils
import com.runwithme.runwithme.utils.TimeUtils

class CompareStatisticsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCompareStatisticsBinding
    private var memberRuns = ArrayList<Run>()
    private val distanceEntries = ArrayList<BarEntry>()
    private val timeEntries = ArrayList<BarEntry>()
    private val avgPaceEntries = ArrayList<BarEntry>()
    private lateinit var distanceDataSet: BarDataSet
    private lateinit var timeDataSet: BarDataSet
    private lateinit var avgPaceDataSet: BarDataSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompareStatisticsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra(GROUP_RUN)) {
            memberRuns = (intent.getSerializableExtra(GROUP_RUN) as GroupRun).groupRunData.membersRuns
        }

        val xLabels = getXLabelsAndSetEntries(memberRuns)

        val xAxisDistance = binding.barChartDistance.xAxis
        xAxisDistance.position = XAxis.XAxisPosition.BOTTOM
        xAxisDistance.labelCount = memberRuns.size
        xAxisDistance.valueFormatter = IndexAxisValueFormatter(xLabels)

        distanceDataSet = BarDataSet(distanceEntries, "Distance (km)")
        val distanceData = BarData(distanceDataSet)

        binding.barChartDistance.data = distanceData
        binding.barChartDistance.description = null

        val xAxisTime = binding.barChartTime.xAxis
        xAxisTime.position = XAxis.XAxisPosition.BOTTOM
        xAxisTime.labelCount = memberRuns.size
        xAxisTime.valueFormatter = IndexAxisValueFormatter(xLabels)

        timeDataSet = BarDataSet(timeEntries, "Duration (min.)")
        val timeData = BarData(timeDataSet)

        binding.barChartTime.data = timeData
        binding.barChartTime.description = null

        val xAxisAvgPace = binding.barChartAvgPace.xAxis
        xAxisAvgPace.position = XAxis.XAxisPosition.BOTTOM
        xAxisAvgPace.labelCount = memberRuns.size
        xAxisAvgPace.valueFormatter = IndexAxisValueFormatter(xLabels)

        avgPaceDataSet = BarDataSet(avgPaceEntries, "Avg. Pace (min/km)")
        val avgPaceData = BarData(avgPaceDataSet)

        binding.barChartAvgPace.data = avgPaceData
        binding.barChartAvgPace.description = null

        setSupportActionBar(binding.compareStatisticsToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        binding.compareStatisticsToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun getXLabelsAndSetEntries(memberRuns: java.util.ArrayList<Run>): ArrayList<String> {
        val xLabels = ArrayList<String>()
        var index = 1f
        xLabels.add("")
        memberRuns.forEach { runner ->
            xLabels.add(runner.userName)
            distanceEntries.add(BarEntry(index, runner.runData.distance))
            timeEntries.add(
                BarEntry(
                    index,
                    TimeUtils.calculateTimeDifferenceInMinutes(runner.startTime, runner.endTime).toFloat()
                )
            )
            avgPaceEntries.add(BarEntry(index, MeasureUtils.convertPaceToMinutes(runner.runData.averagePace)))

            index += 1f
        }

        return xLabels
    }
}