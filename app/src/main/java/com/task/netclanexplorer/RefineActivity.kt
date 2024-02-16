package com.task.netclanexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.task.netclanexplorer.UIComponents.RefineScreen
import com.task.netclanexplorer.UIComponents.ToolbarRefine
import com.task.netclanexplorer.ui.theme.NetclanExplorerTheme

class RefineActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetclanExplorerTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        ToolbarRefine {
                            finish()    // on pressing back icon
                        }
                    }
                ) {
                    RefineScreen(
                        modifier = Modifier.padding(
                            top = (it.calculateTopPadding()),
                            bottom = it.calculateBottomPadding(),
                            start = 20.dp,
                            end = 20.dp
                        )
                    )
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetclanExplorerTheme {
        Greeting("Android")
    }
}