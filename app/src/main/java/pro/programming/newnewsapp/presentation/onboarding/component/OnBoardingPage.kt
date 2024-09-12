package pro.programming.newnewsapp.presentation.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import pro.programming.newnewsapp.R
import pro.programming.newnewsapp.presentation.Dimens.mediumPadding1
import pro.programming.newnewsapp.presentation.Dimens.mediumPadding2
import pro.programming.newnewsapp.presentation.onboarding.Page
import pro.programming.newnewsapp.presentation.onboarding.pages
import pro.programming.newnewsapp.ui.theme.NewNewsAppTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(mediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = mediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(R.color.display_small)
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = mediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(R.color.text_medium)
        )
    }
}
