package com.task.netclanexplorer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.task.netclanexplorer.Model.PersonalViewData
import com.task.netclanexplorer.UIComponents.PersonalSwipableView
import com.task.netclanexplorer.UIComponents.SwipableTabsExplore
import com.task.netclanexplorer.UIComponents.ToolbarHome
import com.task.netclanexplorer.ui.theme.NetclanExplorerTheme

class MainActivity : ComponentActivity() {
    val personalViewData = PersonalViewData(
        name = "Kalpesh Ghorse",
        jobType = "Fresher Not Applicable",
        withinKm = "400-500 m",
        completeDescription = "I have recently completed my internship at Brillect Tech Solutions and now I am working with Petuk Ji Pvt Ltd. It is good to work here because it's a product based company"
    )
    val businessViewData = PersonalViewData(
        name = "Shushree Swain",
        jobType = "UI and UX Designer",
        withinKm = "4.5 KM",
        experience = 3,
        completeDescription = ""
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetclanExplorerTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        ToolbarHome {
                            startActivity(Intent(this, RefineActivity::class.java))
                        }
                    }
                ) {
                    SwipableTabsExplore(
                        modifier = Modifier.padding(it),
                        personalViewData = personalViewData,
                        businessViewData = businessViewData
                    )
                }
            }
        }
    }
}
