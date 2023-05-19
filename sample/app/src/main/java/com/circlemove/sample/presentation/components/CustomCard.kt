package com.circlemove.sample.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.circlemove.sample.R
import com.circlemove.sample.theme.CoDarkBlue
import com.circlemove.sample.theme.CoDirtyWhite

@Composable
fun CustomCard(
    boardLoc: String,
    alightLoc: String,
    fare: Float
) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .background(CoDirtyWhite)
        ) {
            Box(
                modifier = Modifier
                    .background(CoDarkBlue)
                    .weight(2f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        painter = painterResource(id = R.drawable.ic_bus),
                        contentDescription = null
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(5f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 8.dp, horizontal = 4.dp)
                ) {
                    CustomText(
                        text = stringResource(id = R.string.label_board),
                        textSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    CustomText(
                        text = boardLoc,
                        color = CoDarkBlue
                    )
                    CustomText(
                        text = stringResource(id = R.string.label_alight),
                        textSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    CustomText(
                        text = alightLoc,
                        color = CoDarkBlue
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(3f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    CustomText(
                        text = stringResource(id = R.string.label_paid),
                        textSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    CustomText(
                        text = stringResource(id = R.string.label_currency),
                        textSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                    CustomText(
                        text = fare.toString(),
                        color = CoDarkBlue
                    )
                }
            }
        }
    }
}