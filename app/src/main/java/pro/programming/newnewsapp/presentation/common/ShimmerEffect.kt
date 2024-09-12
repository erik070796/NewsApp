package pro.programming.newnewsapp.presentation.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import pro.programming.newnewsapp.R
import pro.programming.newnewsapp.presentation.Dimens.ARTICLE_CARD_SIZE
import pro.programming.newnewsapp.presentation.Dimens.ExtraSmallPadding
import pro.programming.newnewsapp.presentation.Dimens.mediumPadding1


fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    ).value
    background(color = colorResource(R.color.shimmer).copy(alpha))
}

@Composable
fun ArticleCardShimmerEffect(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {

        Box(
            modifier = Modifier
                .size(ARTICLE_CARD_SIZE)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect(),
        )

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ARTICLE_CARD_SIZE)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(30.dp)
                    .padding(mediumPadding1)
                    .shimmerEffect(),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .height(15.dp)
                        .padding(mediumPadding1)
                        .shimmerEffect(),
                )
            }
        }
    }
}