package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.xogame.R
import com.redvelvet.xogame.app.ui.theme.TransparentGray
import com.redvelvet.xogame.app.ui.theme.passion

@Composable
fun OneUserRow(
    modifier: Modifier = Modifier,
    image: String,
    name: String,
    hasFriend: Boolean,
) {
    Card(
        modifier = modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0x66F5F5F5)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (hasFriend)
                ProfileHomeImage(image = image)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = passion,
                    fontWeight = FontWeight.Bold
                )
                if (hasFriend)
                    Card(
                        modifier = Modifier
                            .size(width = 64.dp, height = 25.dp)
                            .border(
                                border = BorderStroke(1.dp, TransparentGray),
                                shape = RoundedCornerShape(
                                    corner = CornerSize(4.dp)
                                )
                            ),
                        shape = RoundedCornerShape(corner = CornerSize(4.dp)),
                        colors = CardDefaults.cardColors(
                            contentColor = Color.White,
                            containerColor = Color.Transparent
                        ),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = stringResource(R.string.invite), fontSize = 12.sp,
                                fontFamily = passion,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
            }
        }
    }
}