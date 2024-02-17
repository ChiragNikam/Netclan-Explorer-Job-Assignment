package com.task.netclanexplorer.UIComponents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.task.netclanexplorer.Model.PersonalViewData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipableTabsExplore(
    modifier: Modifier = Modifier,
    personalViewData: PersonalViewData,
    businessViewData: PersonalViewData
) {
    // list of items in tab row
    val tabItems = listOf("Personal", "Business", "Merchant")

    // selected state for tab row
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    // horizontal pager sate
    val pagerState = rememberPagerState {
        tabItems.size
    }

    // update horizontal pager state if item clicked in tab row
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    // update selected tab on scrolling of horizontal pager
    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage
    }

    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.secondary,
                indicator = { tabPosition ->
                    // custom indicator for selected tab
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPosition[selectedTabIndex]),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            ) {
                tabItems.forEachIndexed { index, item ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = {
                            Text(text = item)
                        },
                        selectedContentColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedContentColor = Color.LightGray
                    )
                }
            }
            HorizontalPager(
                state = pagerState, modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { index ->
                if (index == 0) {
                    PersonalSwipableView(viewData = personalViewData)
                } else if (index == 1) {
                    BusinessSwipableView(viewData = businessViewData)
                } else {
                    MerchantSwipableView(viewData = businessViewData)
                }
            }
        }
    }
}

@Composable
fun PersonalSwipableView(modifier: Modifier = Modifier, viewData: PersonalViewData) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            SearchBox()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                items(5) {
                    PersonalView(viewData)
                }
            }
        }
    }
}

@Composable
fun BusinessSwipableView(modifier: Modifier = Modifier, viewData: PersonalViewData) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            SearchBox()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                items(5) {
                    BusinessView(viewData)
                }
            }
        }
    }
}

@Composable
fun MerchantSwipableView(modifier: Modifier = Modifier, viewData: PersonalViewData) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            SearchBox()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                items(5) {
                    MerchantView(viewData)
                }
            }
        }
    }
}