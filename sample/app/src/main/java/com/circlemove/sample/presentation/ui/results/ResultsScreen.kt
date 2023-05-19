package com.circlemove.sample.presentation.ui.results

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.circlemove.sample.R
import com.circlemove.sample.presentation.ScreenList
import com.circlemove.sample.presentation.components.BottomButton
import com.circlemove.sample.presentation.components.CustomCard
import com.circlemove.sample.presentation.components.CustomText
import com.circlemove.sample.presentation.ui.buyticket.BuyTicketViewModel


@Composable
fun ResultsScreen(navController: NavHostController) {

    val viewModel: BuyTicketViewModel = hiltViewModel()
    val model by viewModel.modelFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_ticket),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )

            CustomText(text = stringResource(id = R.string.label_done), paddingTop = 8.dp)

            model.run {
                CustomCard(boardLoc = boardAtName, alightLoc = alightAtName, fare = fare)
            }
        }

        BottomButton(text = stringResource(id = R.string.label_back)) {
            navController.navigate(route = ScreenList.MenuScreen.route) {
                popUpTo(navController.backQueue.first().destination.id)
            }
        }
    }
}