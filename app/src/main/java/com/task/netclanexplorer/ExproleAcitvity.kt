package com.task.netclanexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.task.netclanexplorer.Model.PersonalViewData
import com.task.netclanexplorer.UIComponents.PersonSwipableView
import com.task.netclanexplorer.UIComponents.ToolbarHome
import com.task.netclanexplorer.ui.theme.NetclanExplorerTheme

class MainActivity : ComponentActivity() {
    val viewData = PersonalViewData(name = "Kalpesh Ghorse", jobType = "Fresher Not Applicable", withinKm = "400-500 m", completeDescription = "")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetclanExplorerTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        ToolbarHome{}
                    }
                ) {
                    PersonSwipableView(Modifier.padding(it), viewData)
                }
            }
        }
    }
}
